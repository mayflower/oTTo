package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Session
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.GenericGenerator
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
@Table(name = "session")
class SessionEntity(
name: String,
description: String,
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

    @OneToMany(
            mappedBy = "session",
            cascade = [CascadeType.ALL])
    var timeslots: MutableSet<TimeslotEntity> = mutableSetOf()

    @ManyToOne(cascade = [CascadeType.ALL])
    var event: EventEntity = EventEntity()

    @ManyToMany(
            cascade = [CascadeType.ALL])
    var speakers: MutableSet<SpeakerEntity> = mutableSetOf()

    constructor() : this(String(), String())

    constructor(session: Session) : this(
            session.title,
            session.description.toString()
    )

    fun asDto(): Session {
        return Session(
                this.id,
                this.name,
                Collections.emptyList(),
                Collections.emptyList(),
                this.description
        )
    }
}