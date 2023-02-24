import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        AuthorizationSystemGUI authGUI = new AuthorizationSystemGUI();
        authGUI.setVisible(true);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
        Bot bot = new Bot();
        bot.setAnswer("Someone logged in server successfully");
    }
}
