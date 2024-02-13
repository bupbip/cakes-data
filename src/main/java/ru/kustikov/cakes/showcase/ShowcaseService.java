package ru.kustikov.cakes.showcase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowcaseService {
    private final ShowcaseRepository showcaseRepository;

    private final ShowcaseMapper showcaseMapper;

    public ShowcaseRecord create(ShowcaseRecord showcaseRecord) {
        ShowcaseEntity showcaseEntity = showcaseMapper.dtoToEntity(showcaseRecord);
        ShowcaseEntity savedShowcaseEntity = showcaseRepository.save(showcaseEntity);
        return showcaseMapper.entityToDto(savedShowcaseEntity);
    }

    public ShowcaseRecord get(Long id) {
        ShowcaseEntity showcaseEntity = showcaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Showcase not found"));
        return showcaseMapper.entityToDto(showcaseEntity);
    }

    public ShowcaseRecord update(ShowcaseRecord showcaseRecord) {
        ShowcaseEntity showcaseEntity = showcaseMapper.dtoToEntity(showcaseRecord);
        ShowcaseEntity savedShowcaseEntity = showcaseRepository.save(showcaseEntity);
        return showcaseMapper.entityToDto(savedShowcaseEntity);
    }

    public void delete(Long id) {
        showcaseRepository.deleteById(id);
    }
}
