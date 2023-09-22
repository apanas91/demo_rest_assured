package servicetests.dto.response;

import lombok.*;
import servicetests.dto.request.OrderRequestDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto extends OrderRequestDto {
    private Long id;
}
