package com.wm.workoutmonitoring.mapper;

import org.modelmapper.ModelMapper;

public class Mapper {
    private Mapper() {

    }

    public static <T, E> T convertSourceToDestinationType(E source, ModelMapper modelMapper, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
