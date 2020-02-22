package ch.botwat;

import ch.botwat.data.User;
import ch.botwat.service.UserService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Botwatch {
    private static final String endpoint = "https://botwat.ch";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.create(new User("abc", "abc12345"));

        Response<User> response = call.execute();
        User yeet = response.body();
        System.out.println(yeet.token);
    }


}
