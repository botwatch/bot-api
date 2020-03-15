package ch.botwat.api;

import ch.botwat.data.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {
    protected static final String endpoint = "http://localhost/";
    protected static User user;
    protected static Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
