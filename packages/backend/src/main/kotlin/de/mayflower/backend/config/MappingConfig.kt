package de.mayflower.backend.config

import de.mayflower.backend.helper.ModelParser
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MappingConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun modelParser(mapper: ModelMapper): ModelParser {
        return ModelParser(mapper)
    }
}