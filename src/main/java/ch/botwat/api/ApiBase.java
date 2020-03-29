package ch.botwat.api;

import ch.botwat.data.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {
    protected static final String endpoint = "http://localhost";//"https://botwat.ch/";
    protected static User user;
    protected static Retrofit retrofit;

    static {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
