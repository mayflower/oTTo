package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "style")
class Style(
    @NotNull
    @NotBlank
    val name: String,

    @NotNull
    val description: String,

    @NotNull
    @NotBlank
    val color: String,

    @NotNull
    @NotBlank
    val textColor: String,

    val image: String,
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), String(), String())
}