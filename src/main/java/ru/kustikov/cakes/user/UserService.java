package ru.kustikov.cakes.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserRecord getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserRecord getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserRecord saveUser(UserRecord userRecord) {
        UserEntity userEntity = userMapper.dtoToEntity(userRecord);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.entityToDto(savedUser);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
