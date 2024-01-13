package ru.o0000q.ratealbumservice.mapper;

public interface Mapper<F, T> {

    F map(T object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}