package ch.botwat.api;

import ch.botwat.data.BotClient;
import ch.botwat.data.User;
import ch.botwat.service.UserService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Users extends ApiBase {
    protected static UserService service;

    static {
        service = retrofit.create(UserService.class);
    }

    /**
     * @return A User object from the server response, or null if there were any issues in transmission.
     */
    public static User create(String name, String email, String password) {
        try {
            Call<User> call = service.create(name, email, password);
            Response<User> response = call.execute();
            if (response.isSuccessful()) {
                user = response.body();
                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return A User object from the server response, or null if there were any issues in transmission.
     */
    public static User authenticate(String name, String password) {
        try {
            Call<User> call = service.authenticate(name, password);
            Response<User> response = call.execute();
            if (response.isSuccessful()) {
                user = response.body();
                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return A User object from the server response, or null if there were any issues in transmission.
     */
    public static User login(String name, String token) {
        try {
            Call<User> call = service.login(name, token);
            Response<User> response = call.execute();
            if (response.isSuccessful()) {
                user = response.body();
                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
