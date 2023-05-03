package de.mayflower.backend.config

import de.mayflower.backend.helper.ModelParser
import org.modelmapper.ModelMapper
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class MappingTestConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun modelParser(mapper: ModelMapper): ModelParser {
        return ModelParser(mapper)
    }
}