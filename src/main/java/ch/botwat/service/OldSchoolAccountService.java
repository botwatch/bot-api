package ch.botwat.service;

import ch.botwat.data.OldSchoolAccount;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OldSchoolAccountService {
    @POST("account/create")
    Call<OldSchoolAccount> create(
            @Header("Authorization") String token,
            @Query("alias") String alias
    );
    @POST("account/banned")
    Call<OldSchoolAccount> banned(
            @Header("Authorization") String token,
            @Query("alias") String alias
    );
}
