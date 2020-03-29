package ch.botwat.api;

import ch.botwat.data.Interaction;
import ch.botwat.data.Session;
import ch.botwat.service.InteractionService;
import ch.botwat.service.SessionService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.io.IOException;

public class Interactions extends ApiBase {

    protected static InteractionService service;

    static {
        service = retrofit.create(InteractionService.class);
    }


    /**
     * @return A Interaction object from the server response, or null if there were any issues in transmission.
     */
    public static Interaction create(int param1, int param2, int param3, int identifier, int menuOption,
                                     int menuTarget, int mouseX, int mouseY,int locationX, int locationY, int sessionId) {
        try {
            Call<Interaction> call = service.create(Utilities.tokenize(user), param1, param2, param3, identifier,
                    menuOption, menuTarget, mouseX, mouseY, locationX, locationY, sessionId);
            Response<Interaction> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
