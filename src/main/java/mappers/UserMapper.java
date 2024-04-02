package mappers;

import response.UserResponseDTO;
import reuest.UserRequestDTO;
import entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO toDTO(User user);
    User toEntity(UserRequestDTO userRequestDTO);
}