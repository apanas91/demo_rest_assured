package servicetests.validatable_response;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import servicetests.dto.response.OrderResponseDto;

public class OrderValidatableResponse {
    private OrderResponseDto model;
    private Response response;

    public OrderValidatableResponse(Response response) {
        this.response = response;
        model = response.as(OrderResponseDto.class);
    }

    public OrderValidatableResponse checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
        return this;
    }

    public OrderValidatableResponse checkText(String text) {
        response.then().body("text", Matchers.equalTo(text));
        return this;
    }

    public OrderResponseDto getOrder() {
        return model;
    }
}
