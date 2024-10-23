package com.rmpl.business.common.bottom.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandHub {
    private List<CommandInterceptorI> globalPreInterceptors = new ArrayList<>();
    private List<CommandInterceptorI> globalPostInterceptors = new ArrayList();
    private Map<Class, CommandInvocation> commandRepository = new HashMap<>();
    private Map<Class, Class> responseRepository = new HashMap();

    public CommandHub() {
    }

    public CommandInvocation getCommandInvocation(Class cmdClass) {
        CommandInvocation commandInvocation = (CommandInvocation)this.commandRepository.get(cmdClass);
        if (this.commandRepository.get(cmdClass) == null) {
            throw new SharpenException(cmdClass + " is not registered in CommandHub, please register first");
        } else {
            return commandInvocation;
        }
    }

    public List<CommandInterceptorI> getGlobalPreInterceptors() {
        return this.globalPreInterceptors;
    }

    public void setGlobalPreInterceptors(List<CommandInterceptorI> globalPreInterceptors) {
        this.globalPreInterceptors = globalPreInterceptors;
    }

    public List<CommandInterceptorI> getGlobalPostInterceptors() {
        return this.globalPostInterceptors;
    }

    public void setGlobalPostInterceptors(List<CommandInterceptorI> globalPostInterceptors) {
        this.globalPostInterceptors = globalPostInterceptors;
    }

    public Map<Class, CommandInvocation> getCommandRepository() {
        return this.commandRepository;
    }

    public void setCommandRepository(Map<Class, CommandInvocation> commandRepository) {
        this.commandRepository = commandRepository;
    }

    public Map<Class, Class> getResponseRepository() {
        return this.responseRepository;
    }

}
