package order;

import springboot.request.OrderRequestDTO;
import springboot.response.OrderResponseDTO;
import springboot.entity.Order;
import springboot.entity.Product;
import springboot.entity.User;
import springboot.repositories.OrderRepository;
import springboot.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void testCreateOrder() {
        User user = new User();
        user.setId(1L);

        Product cake = new Product();
        cake.setName("Cake");

        Product Pakhlawa= new Product();
        Pakhlawa.setName("Pakhlawa");

        List<Product> products = new ArrayList<>();
        products.add(cake);
        products.add(Pakhlawa);

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUser(user);
        orderRequestDTO.setProducts(products);
        orderRequestDTO.setTotalPrice(100.0);
        orderRequestDTO.setOrderDate(LocalDateTime.now());

        when(orderRepository.save(any())).thenReturn(new Order());

        OrderResponseDTO createdOrder = orderService.create(orderRequestDTO);

        verify(orderRepository, times(1)).save(any());
        assertEquals(orderRequestDTO.getTotalPrice(), createdOrder.getTotalPrice());
    }
    @Test
    void testGetOrder() {
        Order order = new Order();
        order.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        OrderResponseDTO fetchedOrder = orderService.get(1L);

        verify(orderRepository, times(1)).findById(1L);
        assertEquals(order.getId(), fetchedOrder.getId());
    }

    @Test
    void testUpdateOrder() {
        Order order = new Order();
        order.setId(1L);

        User user = new User();
        user.setId(1L);

        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUser(user);
        orderRequestDTO.setProducts(products);
        orderRequestDTO.setTotalPrice(200.0);
        orderRequestDTO.setOrderDate(LocalDateTime.now());

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any())).thenReturn(order);

        OrderResponseDTO updatedOrder = orderService.update(1L, orderRequestDTO);

        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(any());
        assertEquals(orderRequestDTO.getTotalPrice(), updatedOrder.getTotalPrice());
    }

    @Test
    void testDeleteOrder() {
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }
}
