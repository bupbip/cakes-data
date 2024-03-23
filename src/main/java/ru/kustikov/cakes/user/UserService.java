package ru.kustikov.cakes.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.socialnetwork.SocialNetworkRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SocialNetworkRepository socialNetworkRepository;

    private final UserMapper userMapper;

    private UserRecord getUserById(Long id) {
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

    public UserRecord getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.entityToDto(user);
    }

    public UserRecord update(UserRecord userRecord) {
        UserEntity userEntity = userMapper.dtoToEntity(userRecord);
        userEntity.getSocialNetworks().forEach(social -> social.setUser(userEntity));
        userEntity.getFillings().forEach(filling -> filling.setUser(userEntity));
        userEntity.getProductTypes().forEach(productType -> productType.setUser(userEntity));
        socialNetworkRepository.saveAll(userEntity.getSocialNetworks());
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.entityToDto(savedUserEntity);
    }

    public List<UserRecord> getConfectioners() {
        return userRepository.findAllByRoleOrderByLastActivity(Role.ROLE_CONFECTIONER)
                .stream().map(userMapper::entityToDto)
                .toList();
    }
}
