package ch.botwat.service;

import ch.botwat.data.BotClient;
import ch.botwat.data.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface ClientService {

    @POST("client/create")
    Call<BotClient> create(
            @Header("Authorization") String token,
            @Query("name") String name,
            @Query("description") String description,
            @Query("url") String url,
            @Query("authors") String authors
    );
}
