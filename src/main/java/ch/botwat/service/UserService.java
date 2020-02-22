package ch.botwat.service;

import ch.botwat.dto.user.UserAuthenticateRequest;
import ch.botwat.dto.user.UserAuthenticateResponse;
import ch.botwat.dto.user.UserCreateRequest;
import ch.botwat.dto.user.UserCreateResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/create")
    Call<UserCreateRequest> create(@Body UserCreateResponse user);

    @POST("user/authenticate")
    Call<UserAuthenticateRequest> authenticate(@Body UserAuthenticateResponse user);
}
