package springboot.services;

import springboot.response.UserResponseDTO;
import springboot.reuest.UserRequestDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO update(Long id, UserRequestDTO userRequestDTO);
    UserResponseDTO get(Long id);
    List<UserResponseDTO> getAll();
}