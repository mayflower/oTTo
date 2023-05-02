package de.mayflower.backend.helper

import org.hibernate.MappingException
import org.modelmapper.ModelMapper

class ModelParser(val modelMapper: ModelMapper, val typeMatcher: TypeMatcher) {

    @Throws(MappingException::class)
    inline fun <S: Any, reified T: Any> parse(source: S): T {
            typeMatcher.match(S::class, T::class)
        return modelMapper.map(source, T::class.java)
    }
}