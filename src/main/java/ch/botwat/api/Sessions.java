package ch.botwat.api;

import ch.botwat.data.BotClient;
import ch.botwat.data.Session;
import ch.botwat.service.SessionService;
import ch.botwat.service.UserService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Sessions extends ApiBase {
    protected static SessionService service;

    static {
        service = retrofit.create(SessionService.class);
    }

    /**
     * @return A Session object from the server response, or null if there were any issues in transmission.
     */
    public static Session create(String client, String alias) {
        try {
            Call<Session> call = service.create(Utilities.tokenize(user), client, alias);
            Response<Session> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
