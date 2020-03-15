package ch.botwat.service;

import ch.botwat.data.Interaction;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InteractionService {
    @POST("interaction/create")
    Call<Interaction> create(
            @Header("Authorization") String token,
            @Query("param1") int param1,
            @Query("param2") int param2,
            @Query("param3") int param3,
            @Query("identifier") int identifier,
            @Query("menuOption") int menuOption,
            @Query("menuTarget") int menuTarget,
            @Query("mouseX") int mouseX,
            @Query("mouseY") int mouseY,
            @Query("sessionId") int sessionId
    );
}
