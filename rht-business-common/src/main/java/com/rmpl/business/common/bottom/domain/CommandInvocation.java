package com.rmpl.business.common.bottom.domain;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.UnmodifiableIterator;
import com.rmpl.business.common.bottom.dto.Response;
import com.rmpl.business.common.bottom.logger.Logger;
import com.rmpl.business.common.bottom.logger.LoggerFactory;
import com.rmpl.business.common.bottom.dto.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CommandInvocation {
    private static Logger logger = LoggerFactory.getLogger(CommandInvocation.class);
    private CommandExecutorI commandExecutor;
    private Iterable<CommandInterceptorI> preInterceptors;
    private Iterable<CommandInterceptorI> postInterceptors;
    @Autowired
    private CommandHub commandHub;

    public CommandInvocation() {
    }

    public CommandInvocation(CommandExecutorI commandExecutor, List<CommandInterceptorI> preInterceptors, List<CommandInterceptorI> postInterceptors) {
        this.commandExecutor = commandExecutor;
        this.preInterceptors = preInterceptors;
        this.postInterceptors = postInterceptors;
    }

    public Response invoke(Request request) {
        Response response = null;

        try {
            this.preIntercept(request);
            response = this.commandExecutor.execute(request);
        } catch (Exception var7) {
            response = this.getResponseInstance(request);
            response.setSuccess(false);
            ExceptionHandlerFactory.getExceptionHandler().handleException(request, response, var7);
        } finally {
            this.postIntercept(request, response);
        }

        return response;
    }

    private void postIntercept(Request request, Response response) {
        try {
            UnmodifiableIterator var3 = FluentIterable.from(this.postInterceptors).toSet().iterator();

            while(var3.hasNext()) {
                CommandInterceptorI postInterceptor = (CommandInterceptorI)var3.next();
                postInterceptor.postIntercept(request, response);
            }
        } catch (Exception var5) {
            logger.error("postInterceptor error:" + var5.getMessage(), var5);
        }

    }

    private void preIntercept(Request request) {
        UnmodifiableIterator var2 = FluentIterable.from(this.preInterceptors).toSet().iterator();

        while(var2.hasNext()) {
            CommandInterceptorI preInterceptor = (CommandInterceptorI)var2.next();
            preInterceptor.preIntercept(request);
        }

    }

    private Response getResponseInstance(Request request) {
        Class responseClz = (Class)this.commandHub.getResponseRepository().get(request.getClass());

        try {
            return (Response)responseClz.newInstance();
        } catch (Exception var4) {
            return new Response();
        }
    }

    public void setCommandExecutor(CommandExecutorI commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public void setPreInterceptors(Iterable<CommandInterceptorI> preInterceptors) {
        this.preInterceptors = preInterceptors;
    }

    public void setPostInterceptors(Iterable<CommandInterceptorI> postInterceptors) {
        this.postInterceptors = postInterceptors;
    }

}
