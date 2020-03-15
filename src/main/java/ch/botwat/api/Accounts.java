package ch.botwat.api;

import ch.botwat.data.BotClient;
import ch.botwat.data.OldSchoolAccount;
import ch.botwat.service.OldSchoolAccountService;
import ch.botwat.service.SessionService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Accounts extends ApiBase {
    protected static OldSchoolAccountService service;

    static {
        service = retrofit.create(OldSchoolAccountService.class);
    }

    /**
     * @return A OldSchoolAccount object from the server response, or null if there were any issues in transmission.
     */
    public static OldSchoolAccount create(String alias) {
        try {
            Call<OldSchoolAccount> call = service.create(Utilities.tokenize(user), alias);
            Response<OldSchoolAccount> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
