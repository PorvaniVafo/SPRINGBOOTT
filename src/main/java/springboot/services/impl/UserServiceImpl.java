package springboot.services.impl;


import springboot.response.UserResponseDTO;
import springboot.reuest.UserRequestDTO;
import springboot.entity.User;
import springboot.exceptions.GeneralException;
import springboot.mappers.UserMapper;
import springboot.repositories.UserRepository;
import springboot.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByUsername(userRequestDTO.getUsername())) {
            throw new GeneralException("Username already exists");
        }

        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new GeneralException("Email already exists");
        }
        User user = userRepository.save(userMapper.toEntity(userRequestDTO));
        return userMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new GeneralException("User not found exception"));
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO get(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new GeneralException("User not found")));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}