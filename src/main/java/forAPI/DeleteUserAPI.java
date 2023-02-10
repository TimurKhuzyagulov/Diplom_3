package forAPI;

import io.restassured.response.ValidatableResponse;

public class DeleteUserAPI {
    static UserAPI userApi;

    public static void deleteUser(User user) {
        userApi = new UserAPI();
        ValidatableResponse responseAuth = userApi.authorization(user);
        String accessTokenWithPrefix = responseAuth.extract().path("accessToken");
        String accessToken = accessTokenWithPrefix.substring(7);
        userApi.delete(accessToken);
    }
}
