package com.xk.bigdata.cws.start.config;

import org.jboss.resteasy.plugins.spring.SpringBeanProcessor;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.springmvc.ResteasyHandlerAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * 控制rest服务发布仍然存在问题，需要跟进解决
 */
@ConditionalOnClass(ResteasyHandlerMapping.class)
@EnableConfigurationProperties
@Configuration
public class ResteasyAutoConfiguration {

	@ConditionalOnMissingBean(ResteasyDeployment.class)
	@ConfigurationProperties(prefix = "resteasy.deployment")
	@Bean(initMethod = "start", destroyMethod = "stop")
	public ResteasyDeployment resteasyDeployment(final SpringBeanProcessor springBeanProcessor) {
		ResteasyDeployment resteasyDeployment = new ResteasyDeployment() {

			public void start() {
				super.start();
				if (springBeanProcessor.getRegistry() == null) {
					springBeanProcessor.setRegistry(this.getRegistry());
				}
			}
		};
		resteasyDeployment.setApplication(new JaxrsApplication());
		resteasyDeployment.setProviderFactory(springBeanProcessor.getProviderFactory());
		return resteasyDeployment;
	}

	@ConditionalOnMissingBean(SpringBeanProcessor.class)
	@Bean
	public SpringBeanProcessor springBeanProcessor() {
		SpringBeanProcessor springBeanProcessor = new SpringBeanProcessor();
		springBeanProcessor.setProviderFactory(ResteasyProviderFactory.getInstance());
//		ResourceMethodRegistry registry = new ResourceMethodRegistry(ResteasyProviderFactory.getInstance());
//		springBeanProcessor.setRegistry(registry);
		return springBeanProcessor;
	}

	@ConditionalOnMissingBean(ResteasyHandlerMapping.class)
	@Bean
	public ResteasyHandlerMapping resteasyHandlerMapper(ResteasyDeployment deployment) {
		ResteasyHandlerMapping handlerMapping = new ResteasyHandlerMapping(deployment);
		handlerMapping.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
		handlerMapping.setPrefix("/");  //服务注册，默认没有前缀
		handlerMapping.setThrowNotFound(false);
		//拦截器没有什么卵用
//		handlerMapping.setInterceptors(Arrays.asList(new RestHandlerInterceptor()).toArray(new RestHandlerInterceptor[0]));
		return handlerMapping;
	}

	@ConditionalOnMissingBean(ResteasyHandlerAdapter.class)
	@Bean
	public ResteasyHandlerAdapter resteasyHandlerAdapter(ResteasyDeployment deployment) {
		ResteasyHandlerAdapter resteasyHandlerAdapter = new ResteasyHandlerAdapter(deployment);
		return resteasyHandlerAdapter;
	}
}
