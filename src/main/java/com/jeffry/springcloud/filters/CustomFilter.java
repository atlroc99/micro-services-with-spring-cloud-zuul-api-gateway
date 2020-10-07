package com.jeffry.springcloud.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class CustomFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public String filterType() {
        //four types of itler: pre, post, router, error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String httpMethod = request.getMethod();

        StringBuilder sb = new StringBuilder();
        sb.append(httpMethod + " ")
                .append(" | ContextPath: " + contextPath)
                .append(" | RequestURI:" + requestURI)
                .append(" | RequestURL: " + requestURL);
        logger.info(sb.toString());
        return null;
    }
}
