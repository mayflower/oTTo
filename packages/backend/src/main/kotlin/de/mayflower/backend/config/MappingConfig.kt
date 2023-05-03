package de.mayflower.backend.config

import de.mayflower.backend.helper.ModelParser
import org.modelmapper.ModelMapper
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import java.util.*

@Configuration
class MappingConfig(var env: Environment) {

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun modelParser(mapper: ModelMapper, options: Map<String, Map<String, String>>): ModelParser {
        return ModelParser(mapper, options)
    }

    @Bean
    @ConfigurationProperties("custom.model-matching-options")
    fun modelMatchingOptions(): Map<String, Map<String, String>> {
        return HashMap()
    }
}
