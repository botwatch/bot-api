package ch.botwat.api;

import ch.botwat.data.User;

public class Utilities {
    public static String tokenize(String token) {
        return "Bearer " + token;
    }

    public static String tokenize(User user) {
        return tokenize(user.token);
    }
}
