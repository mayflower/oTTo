package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "style")
class Style(
    @NotNull
    @NotBlank
    var name: String,

    @NotNull
    var description: String,

    @NotNull
    @NotBlank
    var color: String,

    @NotNull
    @NotBlank
    var textColor: String,

    var image: String,

    @OneToMany(
        mappedBy = "event",
        cascade = [CascadeType.ALL])
    var events: MutableSet<EventEntity> = mutableSetOf(),
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), String(), String())
}