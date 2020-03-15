package ch.botwat.service;

import ch.botwat.data.User;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface UserService {
    @POST("user/create")
    Call<User> create(@Query("name") String name, @Query("email") String email, @Query("password") String password);

    @POST("user/authenticate")
    Call<User> authenticate(@Query("name")String name, @Query("password")String password);

    @POST("user/login")
    Call<User> login(@Query("name")String name, @Query("token")String token);
}
