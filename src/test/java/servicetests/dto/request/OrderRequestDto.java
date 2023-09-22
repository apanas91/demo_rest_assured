package servicetests.dto.request;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private String text;
    private String comment;

    public static OrderRequestDto getInstance() {
        return new OrderRequestDto()
                .setText("Пицца 4 сезона")
                .setComment("Доставить к 13.00");
    }
}
