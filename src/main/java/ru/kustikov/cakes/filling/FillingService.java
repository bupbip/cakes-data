package ru.kustikov.cakes.filling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kustikov.cakes.user.UserEntity;
import ru.kustikov.cakes.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class FillingService {
    private final FillingRepository fillingRepository;
    private final UserRepository userRepository;
    private final FillingMapper fillingMapper;

    public List<FillingRecord> save(List<FillingRecord> fillingRecords) {
        List<FillingEntity> entities = fillingRecords.stream()
                .map(fillingMapper::dtoToEntity)
                .toList();

        UserEntity user = userRepository.findById(fillingRecords.get(0).getUserId()).orElseThrow();
        entities.forEach(entity -> entity.setUser(user));
        Iterable<FillingEntity> savedFillings = fillingRepository.saveAll(entities);

        return StreamSupport.stream(savedFillings.spliterator(), false)
                .map(fillingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        fillingRepository.deleteById(id);
    }
}