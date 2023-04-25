package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Event
import de.mayflower.backend.stubs.model.Room
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator
import java.net.URI
import java.util.Collections

@Entity
@Table(name = "room")
class RoomEntity(
name: String,
description: String
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    var name: String = name

    var description: String = description

    @ManyToMany(
            //mappedBy = "room",
            cascade = [CascadeType.ALL])
    val days: MutableSet<DayEntity> = mutableSetOf()

    @OneToMany(
            mappedBy = "room",
            cascade = [CascadeType.ALL])
    val timeslots: MutableSet<TimeslotEntity> = mutableSetOf()

    constructor() : this(String(), String())

    constructor(room: Room) : this(
            room.name,
            room.description.toString()
    )

    fun asDto(): Room {
        return Room(
                this.id,
                this.name,
                Collections.emptyList(),
                this.description
        )
    }
}