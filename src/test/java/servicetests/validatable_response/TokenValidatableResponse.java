package servicetests.validatable_response;

import io.restassured.response.Response;
import servicetests.config.Config;
import servicetests.dto.response.TokenResponseDto;

public class TokenValidatableResponse {

    private TokenResponseDto model;
    private Response response;

    public TokenValidatableResponse(Response response) {
        this.response = response;
        model = response.as(TokenResponseDto.class);
    }

    public TokenValidatableResponse checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
        return this;
    }

    public TokenValidatableResponse saveTokenForAuth() {
        Config.setToken(getToken().getToken());
        return this;
    }

    public TokenResponseDto getToken() {
        return model;
    }
}
