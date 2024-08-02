package com.ctw.workstation.rest;

import io.quarkus.logging.Log;
import jakarta.annotation.Priority;
import jakarta.interceptor.Interceptor;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
@Priority(Interceptor.Priority.APPLICATION -1)
public class LogRequestFilter implements ContainerRequestFilter {

    @Context
    UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        Log.infov("Request URL: %s", uriInfo.getRequestUri().getPath());
    }
}
