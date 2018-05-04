
import io.fouad.jtb.core.JTelegramBot;
import io.fouad.jtb.core.TelegramBotApi;
import io.fouad.jtb.core.beans.ReplyMarkup;
import io.fouad.jtb.core.builders.ApiBuilder;
import io.fouad.jtb.core.enums.ParseMode;
import static java.awt.SystemColor.text;
import static javax.management.Query.or;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dfguzman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MyBot mb = new MyBot();

        JTelegramBot bot = new JTelegramBot(<botName>, <botKey>, mb);

        mb.sendMessage(bot, 563343042L, "mensaje de inicio");
        bot.startAsync();
        System.out.println("DieBotTokens successfully started!");

    }

}
