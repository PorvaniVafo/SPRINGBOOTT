package mappers;

import response.OrderResponseDTO;
import reuest.OrderRequestDTO;
import entity.Order;
import entity.Product;
import entity.User;


@Mapper(componentModel = "spring", uses = {User.class, Product.class})
public interface OrderMapper {

    Order toEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toDTO(Order order);
}