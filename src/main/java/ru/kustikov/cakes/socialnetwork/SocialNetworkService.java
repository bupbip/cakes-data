package ru.kustikov.cakes.socialnetwork;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocialNetworkService {
    private final SocialNetworkRepository socialNetworkRepository;
    private final SocialNetworkMapper socialNetworkMapper;

    public SocialNetworkRecord create(SocialNetworkRecord socialNetworkRecord) {
        SocialNetworkEntity socialNetworkEntity = socialNetworkMapper.dtoToEntity(socialNetworkRecord);
        SocialNetworkEntity savedSocialNetworkEntity = socialNetworkRepository.save(socialNetworkEntity);
        return socialNetworkMapper.entityToDto(savedSocialNetworkEntity);
    }

    public SocialNetworkRecord get(Long id) {
        SocialNetworkEntity socialNetworkEntity = socialNetworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SocialNetwork not found"));
        return socialNetworkMapper.entityToDto(socialNetworkEntity);
    }

    public SocialNetworkRecord update(SocialNetworkRecord socialNetworkRecord) {
        SocialNetworkEntity socialNetworkEntity = socialNetworkMapper.dtoToEntity(socialNetworkRecord);
        SocialNetworkEntity savedSocialNetworkEntity = socialNetworkRepository.save(socialNetworkEntity);
        return socialNetworkMapper.entityToDto(savedSocialNetworkEntity);
    }

    public void delete(Long id) {
        socialNetworkRepository.deleteById(id);
    }
}
