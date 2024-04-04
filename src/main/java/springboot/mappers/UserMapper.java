package springboot.mappers;

import org.mapstruct.Mapper;
import springboot.entity.User;
import springboot.response.UserResponseDTO;
import springboot.reuest.UserRequestDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toDTO(User user);
    User toEntity(UserRequestDTO userRequestDTO);
}