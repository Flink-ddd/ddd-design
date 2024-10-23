package com.rmpl.business.common.bottom.domain;

import com.rmpl.business.common.bottom.dto.Response;
import com.rmpl.business.common.bottom.dto.Request;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class CommandBus implements CommandBusI {
    private final CommandHub commandHub;

    public Response send(Request cmd) {
        return this.commandHub.getCommandInvocation(cmd.getClass()).invoke(cmd);
    }

    @ConstructorProperties({"commandHub"})
    public CommandBus(CommandHub commandHub) {
        this.commandHub = commandHub;
    }
}
