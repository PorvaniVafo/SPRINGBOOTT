package springboot.mappers;

import springboot.response.OrderResponseDTO;
import springboot.reuest.OrderRequestDTO;
import springboot.entity.Order;


public interface OrderMapper {

    Order toEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toDTO(Order order);
}