package ru.kustikov.cakes.socialnetwork;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SocialNetworkMapper {
    SocialNetworkEntity dtoToEntity(SocialNetworkRecord dto);

    SocialNetworkRecord entityToDto(SocialNetworkEntity entity);
}
