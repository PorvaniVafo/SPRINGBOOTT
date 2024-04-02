package services;

import response.OrderResponseDTO;
import reuest.OrderRequestDTO;

import java.util.List;

public interface OrderService {

    OrderResponseDTO create(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO update(Long id, OrderRequestDTO orderRequestDTO);
    OrderResponseDTO get(Long id);
    List<OrderResponseDTO> getAll(Long id);
    void deleteOrder(Long id);

}