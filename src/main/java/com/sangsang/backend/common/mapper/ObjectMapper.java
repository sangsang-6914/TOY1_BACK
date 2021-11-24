package com.sangsang.backend.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ObjectMapper<E, D>{

    E dtoToEntity(D dto);

    D entityToDto(E entity);
}
