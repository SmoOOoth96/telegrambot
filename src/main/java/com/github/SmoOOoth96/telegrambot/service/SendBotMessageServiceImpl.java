package com.github.SmoOOoth96.telegrambot.service;

import com.github.SmoOOoth96.telegrambot.util.JavaTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavaTelegramBot javaTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaTelegramBot javaTelegramBot) {
        this.javaTelegramBot = javaTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            javaTelegramBot.execute(sendMessage);
        }catch (TelegramApiException e){
            //todo add logging to the project
            e.printStackTrace();
        }
    }
}
