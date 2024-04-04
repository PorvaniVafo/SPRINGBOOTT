package springboot.mappers;

import springboot.entity.User;
import springboot.response.UserResponseDTO;
import springboot.reuest.UserRequestDTO;


public interface UserMapper {

    UserResponseDTO toDTO(User user);
    User toEntity(UserRequestDTO userRequestDTO);
}