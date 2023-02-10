package forAPI;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserAPI extends SpecificationAPI {

    private static final String PATH_AUTH = "/api/auth/login";
    private static final String PATH_DELETE = "/api/auth/user";

    public ValidatableResponse authorization(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH_AUTH)
                .then();
    }

    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getSpec())
                .auth()
                .oauth2(accessToken)
                .when()
                .delete(PATH_DELETE)
                .then();
    }

}
