package ru.o0000q.ratealbumservice.mapper;

public interface Mapper<Entity, Dto> {

    Dto fromEntityToDto(Entity object);
    Entity fromDtoToEntity(Dto object);
}