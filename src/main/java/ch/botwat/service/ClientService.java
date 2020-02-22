package ch.botwat.service;

import ch.botwat.data.BotClient;
import ch.botwat.dto.client.BotClientCreateRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClientService {
    @POST("user/create")
    Call<BotClient> create(@Body BotClientCreateRequest client);
}
