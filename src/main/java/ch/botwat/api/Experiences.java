package ch.botwat.api;

import ch.botwat.data.BotClient;
import ch.botwat.data.Experience;
import ch.botwat.service.ExperienceService;
import ch.botwat.service.SessionService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Experiences extends ApiBase {
    protected static ExperienceService service;

    static {
        service = retrofit.create(ExperienceService.class);
    }

    /**
     * @return A Experience object from the server response, or null if there were any issues in transmission.
     */
    public static Experience create(int skillIndex, int experience, int sessionId) {
        try {
            Call<Experience> call = service.create(Utilities.tokenize(user), skillIndex, experience, sessionId);
            Response<Experience> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
