package com.thoughtworks.webquiz;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;

        res.addHeader("Access-Control-Allow-Origin", "http://localhost:1234/product");
        res.addHeader("Access-Control-Allow-Methods", "GET");

        chain.doFilter(request, response);
    }
}
