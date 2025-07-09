package com.certichain.bff.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

@Component
public class RemoveTransferEncodingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        HttpServletResponseWrapper wrapped = new HttpServletResponseWrapper(res) {
            @Override
            public void setHeader(String name, String value) {
                if (!"transfer-encoding".equalsIgnoreCase(name)) {
                    super.setHeader(name, value);
                }
            }

            @Override
            public void addHeader(String name, String value) {
                if (!"transfer-encoding".equalsIgnoreCase(name)) {
                    super.addHeader(name, value);
                }
            }
        };
        chain.doFilter(req, wrapped);
    }

}
