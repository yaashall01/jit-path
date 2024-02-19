package com.jobintech.jitpath.mapper;


import java.util.List;

public interface EntityDtoMapper<T, U> {
    U toDto(T entity);
    T toEntity(U dto);

    default List<U> toDtos(List<T> entities){
        if(entities==null) return null;
        return  entities.stream().map(this::toDto).toList();
    }

    default List<T> toEntities(List<U> dtos){
        if(dtos==null) return null;
        return  dtos.stream().map(this::toEntity).toList();
    }
}
