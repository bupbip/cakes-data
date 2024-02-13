package ru.kustikov.cakes.showcase;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ShowcaseMapper {
    //    @Mapping(target = "userId", source = "user.userId")
    ShowcaseRecord entityToDto(ShowcaseEntity showcaseEntity);

    //    @Mapping(target = "user.userId", source = "userId")
    ShowcaseEntity dtoToEntity(ShowcaseRecord showcaseDto);
}
