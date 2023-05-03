package de.mayflower.backend.helper

import org.hibernate.MappingException
import org.modelmapper.ModelMapper

class ModelParser(val modelMapper: ModelMapper, val options: Map<String, Map<String, String>>) {

    @Throws(MappingException::class)
    inline fun <S: Any, reified T: Any> parse(source: S): T {
        return modelMapper.map(source, T::class.java)
    }
}