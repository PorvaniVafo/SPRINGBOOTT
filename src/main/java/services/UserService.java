package services;

import response.UserResponseDTO;
import reuest.UserRequestDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO update(Long id, UserRequestDTO userRequestDTO);
    UserResponseDTO get(Long id);
    List<UserResponseDTO> getAll();
}