package com.sangsang.backend.common.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

public interface ObjectMapper<D, E> {

    D entityToDto(E e);
    E dtoToEntity(D d);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D dto, @MappingTarget E entity);
}
