package ch.botwat.api;

import ch.botwat.data.BotClient;
import ch.botwat.service.ClientService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Clients extends ApiBase {
    protected static ClientService service;

    static {
        service = retrofit.create(ClientService.class);
    }

    /**
     * @return A BotClient object from the server response, or null if there were any issues in transmission.
     */
    public static BotClient createOrGet(String name, String description, String url, String authors) {
        BotClient client = create(name, description, url, authors);
        if (client == null) client = get(name);
        return client;
    }

    /**
     * @return A BotClient object from the server response, or null if there were any issues in transmission.
     */
    public static BotClient create(String name, String description, String url, String authors) {
        try {
            Call<BotClient> call = service.create(Utilities.tokenize(user), name, description, url, authors);
            Response<BotClient> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return A BotClient object from the server response, or null if there were any issues in transmission.
     */
    public static BotClient get(String clientName) {
        try {
            Call<BotClient> call = service.get(Utilities.tokenize(user), clientName);
            Response<BotClient> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
