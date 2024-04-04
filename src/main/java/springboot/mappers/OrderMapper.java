package springboot.mappers;

import org.mapstruct.Mapper;
import springboot.response.OrderResponseDTO;
import springboot.reuest.OrderRequestDTO;
import springboot.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toDTO(Order order);
}