package mappers;

import response.OrderResponseDTO;
import reuest.OrderRequestDTO;
import entity.Order;


public interface OrderMapper {

    Order toEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toDTO(Order order);
}