package com.github.SmoOOoth96.telegrambot.command;

import com.github.SmoOOoth96.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет. Я Java Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, которые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
