package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.GenericGenerator
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "session")
class SessionEntity(
    @NotNull
    @NotBlank
    var name: String,

    @NotNull
    var description: String,

    /*@OneToMany(
        mappedBy = "session",
        cascade = [CascadeType.ALL])
    var timeslots: MutableSet<TimeSlotEntity> = mutableSetOf(),*/

    @ManyToOne(cascade = [CascadeType.ALL])
    var event: EventEntity = EventEntity(),

    /*@OneToMany(
        mappedBy = "session",
        cascade = [CascadeType.ALL])
    var speakers: MutableSet<SpeakerEntity> = mutableSetOf(),*/
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String())
}