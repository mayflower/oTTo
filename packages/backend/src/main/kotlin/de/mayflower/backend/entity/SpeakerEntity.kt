package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "speaker")
class SpeakerEntity(
    @NotNull
    val name: String,

    @NotNull
    val description: String,

    @NotNull
    val url: String,

    @NotNull
    val image: String,

    @ManyToMany(cascade = [CascadeType.ALL])
    val sessions: MutableSet<SessionEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), String(), mutableSetOf())
}
