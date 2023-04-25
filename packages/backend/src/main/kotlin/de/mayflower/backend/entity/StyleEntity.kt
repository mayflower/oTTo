package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Style
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.net.URI
import java.util.*

@Entity
@Table(name = "style")
class StyleEntity(
name: String,
description: String,
color: String,
textColor: String,
image: String
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    @NotBlank
    var name: String = name

    @NotNull
    var description: String = description

    @NotNull
    @NotBlank
    var color: String = color

    @NotNull
    @NotBlank
    var textColor: String = textColor

    var image: String = image

    @OneToMany(
            //mappedBy = "event",
            cascade = [CascadeType.ALL])
    var events: MutableSet<EventEntity> = mutableSetOf()

    constructor() : this(String(), String(), String(), String(), String())

    constructor(style: Style) : this(
            style.name,
            style.description,
            style.color,
            style.textColor,
            style.image.toString()
    )

    fun asDto(): Style {
        return Style(
                this.id,
                this.name,
                this.description,
                this.color,
                this.textColor,
        )
    }
}