package ch.botwat.service;

import ch.botwat.data.BotClient;
import ch.botwat.data.Session;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SessionService {
    @POST("account/create")
    Call<Session> create(
            @Header("Authorization") String token,
            @Query("alias") String client,
            @Query("alias") String alias
    );
}
