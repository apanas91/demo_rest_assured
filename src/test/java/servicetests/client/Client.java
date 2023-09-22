package servicetests.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import servicetests.config.Config;
import servicetests.dto.request.AuthRequestDto;
import servicetests.dto.request.OrderRequestDto;
import servicetests.validatable_response.OrderValidatableResponse;
import servicetests.validatable_response.TokenValidatableResponse;

public class Client {

    private String authToken = null;

    public static TokenValidatableResponse authenticate(AuthRequestDto authReq) {
        Response response = RestAssured.given().spec(Config.serviceSpec())
                .when()
                .body(authReq)
                .post("authenticate");
        response.then().log().all();
        return new TokenValidatableResponse(response);
    }

    public static OrderValidatableResponse createOrder(OrderRequestDto order) {
        Response response = RestAssured.given().spec(Config.serviceSpec())
                .when()
                .body(order)
                .post("order");
        response.then().log().all();
        return new OrderValidatableResponse(response);
    }

    public static OrderValidatableResponse getOrderById(long id) {
        Response response = RestAssured.given().spec(Config.serviceSpec())
                .when()
                .get("order/{id}", id);
        response.then().log().all();
        return new OrderValidatableResponse(response);
    }
}
