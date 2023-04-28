package de.mayflower.backend.helper

import org.modelmapper.ModelMapper

class ModelParser(val modelMapper: ModelMapper) {
    inline fun <S, reified T> parse(source: S): T {
        return modelMapper.map(source, T::class.java)
    }
}