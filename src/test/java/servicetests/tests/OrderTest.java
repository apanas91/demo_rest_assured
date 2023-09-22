package servicetests.tests;

import org.junit.jupiter.api.Test;
import servicetests.client.Client;
import servicetests.dto.request.AuthRequestDto;
import servicetests.dto.request.OrderRequestDto;
import servicetests.dto.response.OrderResponseDto;
import servicetests.dto.response.TokenResponseDto;

class OrderTest {

    @Test
    void orderTest() {
        AuthRequestDto req = new AuthRequestDto("admin", "admin");
        TokenResponseDto token = Client.authenticate(req)
                .checkStatusCode(200)
                .saveTokenForAuth()
                .getToken();

        OrderRequestDto order = OrderRequestDto.getInstance();

        OrderResponseDto orderResponse = Client.createOrder(order)
                .checkStatusCode(200)
                .getOrder();

        OrderResponseDto getOrderResponse = Client.getOrderById(orderResponse.getId())
                .checkStatusCode(200)
                .checkText("Пицца 4 сезона")
                .getOrder();
    }
}
