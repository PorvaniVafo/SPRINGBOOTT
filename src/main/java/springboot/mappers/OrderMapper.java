package springboot.mappers;

import springboot.response.OrderResponseDTO;
import springboot.request.OrderRequestDTO;
import springboot.entity.Order;
import springboot.entity.Product;
import springboot.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {User.class, Product.class})
public interface OrderMapper {

    Order toEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toDTO(Order order);
}