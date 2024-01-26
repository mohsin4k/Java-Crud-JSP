package com.example.crudselfdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("*.do")
public class LoginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String uri = httpServletRequest.getRequestURI();

        if(httpServletRequest.getSession().getAttribute("username") != null || uri.endsWith("error.do"))
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            httpServletRequest.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);
        }
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    public void destroy() {}
}
