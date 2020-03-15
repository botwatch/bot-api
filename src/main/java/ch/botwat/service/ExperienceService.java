package ch.botwat.service;

import ch.botwat.data.Experience;
import ch.botwat.data.Interaction;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ExperienceService {
    @POST("experience/create")
    Call<Experience> create(
            @Header("Authorization") String token,
            @Query("skillIndex") int skillIndex,
            @Query("experience") int experience,
            @Query("sessionId") int sessionId
    );
}
