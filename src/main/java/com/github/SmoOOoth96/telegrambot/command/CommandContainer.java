package com.github.SmoOOoth96.telegrambot.command;

import com.github.SmoOOoth96.telegrambot.service.SendBotMessageService;

import java.util.Map;

import static com.github.SmoOOoth96.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService){
        commandMap = Map
                .ofEntries(
                        Map.entry(START.getCommandName(), new StartCommand(sendBotMessageService)),
                        Map.entry(STOP.getCommandName(), new StopCommand(sendBotMessageService)),
                        Map.entry(HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                        Map.entry(NO.getCommandName(), new NoCommand(sendBotMessageService)));

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
