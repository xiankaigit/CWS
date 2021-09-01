package com.xk.bigdata.cws.start.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>Rest请求拦截器<p>
 * @author xulexun 2018年11月5日 下午3:23:57 
 * @version: v1.0
 * @modify {create} by xulexun 2018年11月5日 下午3:23:57 
 */
public class RestHandlerInterceptor implements HandlerInterceptor {
	/**默认日志配置*/
	private static Logger LOG = LoggerFactory.getLogger(RestHandlerInterceptor.class);
	
	private static String[] staticResources = {".css",".jsp",".jpg",".png",".ftl",".ico",".js",".gif"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.info("pre handler: " + request.getRequestURI());
		//执行静态资源的过滤
		String requestURI = request.getRequestURI();
		for (int i = 0 ; i < staticResources.length; i ++) {
			if (requestURI.endsWith(staticResources[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOG.info("post handler: " + request.getRequestURI());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		LOG.info("after handler: " + request.getRequestURI());
	}

}
