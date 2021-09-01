package com.xk.bigdata.cws.start.config;

import org.jboss.resteasy.core.ResourceInvoker;
import org.jboss.resteasy.core.SynchronousDispatcher;
import org.jboss.resteasy.plugins.spring.i18n.LogMessages;
import org.jboss.resteasy.plugins.spring.i18n.Messages;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.springmvc.RequestUtil;
import org.jboss.resteasy.springmvc.ResteasyRequestWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

/**
 * 在源码基础上加了过滤
 */
public class ResteasyHandlerMapping implements HandlerMapping, Ordered, InitializingBean {
    //增加过滤的静态变量
    private String[] staticResources = {".css", ".jsp", ".jpg", ".png", ".ftl", ".ico", ".js", ".gif"};

    private int order = Integer.MAX_VALUE;
    private SynchronousDispatcher dispatcher;

    private String prefix = "";
    private HandlerInterceptor[] interceptors;
    private boolean throwNotFound = false;

    public ResteasyHandlerMapping(ResteasyDeployment deployment) {
        super();
        this.dispatcher = (SynchronousDispatcher) deployment.getDispatcher();
    }

    public SynchronousDispatcher getDispatcher() {
        return dispatcher;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public HandlerInterceptor[] getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(HandlerInterceptor[] interceptors) {
        this.interceptors = interceptors;
    }

    public HandlerExecutionChain getHandler(HttpServletRequest request)
            throws Exception {
        String requestURI = request.getRequestURI();
        for (int i = 0; i < staticResources.length; i++) {
            if (requestURI.endsWith(staticResources[i])) {
                return null;
            }
        }

        ResteasyRequestWrapper requestWrapper = RequestUtil.getRequestWrapper(
                request, request.getMethod(), prefix);
        try {
            // NOTE: if invoker isn't found, RESTEasy throw NoReourceFoundFailure
            HttpRequest httpRequest = requestWrapper.getHttpRequest();
            if (!httpRequest.isInitial()) {
                String message = Messages.MESSAGES.pathNotInitialRequest(httpRequest.getUri().getPath());
                LogMessages.LOGGER.error(message);
                requestWrapper.setError(500, message);
            } else {
                Response response = dispatcher.preprocess(httpRequest);
                if (response != null) {
                    requestWrapper.setAbortedResponse(response);
                } else {
                    requestWrapper.setInvoker(getInvoker(httpRequest));
                }
            }
            return new HandlerExecutionChain(requestWrapper, interceptors);
        } catch (NotFoundException e) {
            if (throwNotFound) {
                throw e;
            }
            LogMessages.LOGGER.error(Messages.MESSAGES.resourceNotFound(e.getMessage()), e);
        } catch (Failure e) {
            LogMessages.LOGGER.error(Messages.MESSAGES.resourceFailure(e.getMessage()), e);
            throw e;
        }
        return null;
    }

    private ResourceInvoker getInvoker(HttpRequest httpRequest) {
        if (dispatcher != null)
            return dispatcher.getInvoker(httpRequest);
        return null;
    }

    public int getOrder() {
        return order;
    }

    public boolean isThrowNotFound() {
        return throwNotFound;
    }

    public void setThrowNotFound(boolean throwNotFound) {
        this.throwNotFound = throwNotFound;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void afterPropertiesSet() throws Exception {
        if (!throwNotFound && order == Integer.MAX_VALUE) {
            LogMessages.LOGGER.info(Messages.MESSAGES.resteasyHandlerMappingHasDefaultOrder());
        }
    }
}
