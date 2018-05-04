
import io.fouad.jtb.core.TelegramBotApi;
import io.fouad.jtb.core.UpdateHandler;
import io.fouad.jtb.core.beans.CallbackQuery;
import io.fouad.jtb.core.beans.ChosenInlineResult;
import io.fouad.jtb.core.beans.InlineKeyboardButton;
import io.fouad.jtb.core.beans.InlineKeyboardMarkup;
import io.fouad.jtb.core.beans.InlineQuery;
import io.fouad.jtb.core.beans.Message;
import io.fouad.jtb.core.builders.ApiBuilder;
import io.fouad.jtb.core.enums.ParseMode;
import io.fouad.jtb.core.exceptions.NegativeResponseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * https://github.com/Eng-Fouad/JTelegramBot
 */
/**
 *
 * @author dfguzman
 */
public class MyBot implements UpdateHandler {

    @Override
    public void onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message) {
        if (message.getText().equals("/start")) {

            try {
                ApiBuilder.api(telegramBotApi)
                        .sendMessage("Tu id es: *" + message.getChat().getId() + "*\nPara recibir el código de validación envía el texto: /codigo")
                        .toChatId(message.getChat().getId())
                        //.asReplyToMessage(message.getMessageId())
                        //.asSilentMessage()
                        .parseMessageAs(ParseMode.MARKDOWN)
                        .execute();
            } catch (IOException | NegativeResponseException e) {
                e.printStackTrace();
            }

        } else if (message.getText().equals("/codigo")) {

            int numero = (int) (Math.random() * 1000) + 1;

            try {
                ApiBuilder.api(telegramBotApi)
                        .sendMessage("Código de verificación: *" + String.valueOf(numero) + "*")
                        .toChatId(message.getChat().getId())
                        .parseMessageAs(ParseMode.MARKDOWN)
                        .execute();
            } catch (IOException | NegativeResponseException e) {
                e.printStackTrace();
            }

        } else {

            int numero = (int) (Math.random() * 1000) + 1;

            try {
                ApiBuilder.api(telegramBotApi)
                        .sendMessage("Para recibir el código de validación envía el texto: /codigo")
                        .toChatId(message.getChat().getId())
                        .parseMessageAs(ParseMode.MARKDOWN)
                        .execute();

            } catch (IOException | NegativeResponseException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMessage(TelegramBotApi telegramBotApi, Long id, String message) {
        try {
            ApiBuilder.api(telegramBotApi)
                    .sendMessage(message)
                    .toChatId(id)
                    .parseMessageAs(ParseMode.MARKDOWN)
                    .disableLinkPreviews()
                    //.applyReplyMarkup(ReplyMarkup replyMarkup)
                    .execute();
        } catch (IOException | NegativeResponseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onEditedMessageReceived(TelegramBotApi telegramBotApi, int id, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInlineQueryReceived(TelegramBotApi telegramBotApi, int id, InlineQuery inlineQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChosenInlineResultReceived(TelegramBotApi telegramBotApi, int id, ChosenInlineResult chosenInlineResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onCallbackQueryReceived(TelegramBotApi telegramBotApi, int id, CallbackQuery callbackQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onGetUpdatesFailure(Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
