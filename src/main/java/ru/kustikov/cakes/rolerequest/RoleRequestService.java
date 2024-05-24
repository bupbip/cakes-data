package ru.kustikov.cakes.rolerequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.user.Role;
import ru.kustikov.cakes.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleRequestService {
    private final RoleRequestRepository roleRequestRepository;
    private final UserRepository userRepository;
    private final RoleRequestMapper roleRequestMapper;

    public List<RoleRequestRecord> getAll() {
        List<RoleRequestEntity> requests = (List<RoleRequestEntity>) roleRequestRepository.findAll();

        return requests.stream()
                .map(roleRequestMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public String approve(RoleRequestRecord request) {
        RoleRequestEntity entity = roleRequestMapper.dtoToEntity(request);

        entity.getUser().setRole(Role.ROLE_CONFECTIONER);

        userRepository.save(entity.getUser());
        roleRequestRepository.delete(entity);

        return "success";
    }

    public String decline(RoleRequestRecord request) {
        RoleRequestEntity entity = roleRequestMapper.dtoToEntity(request);

        roleRequestRepository.delete(entity);
        return "success";
    }

    public String save(RoleRequestRecord request) {
        RoleRequestEntity entity = roleRequestMapper.dtoToEntity(request);

        roleRequestRepository.save(entity);
        return "saved";
    }
}
