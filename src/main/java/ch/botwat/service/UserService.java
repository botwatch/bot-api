package ch.botwat.service;

import ch.botwat.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/create")
    Call<User> create(@Body User user);

    @POST("user/authenticate")
    Call<User> authenticate(@Body User user);
}
