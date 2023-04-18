package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "room")
class RoomEntity(
    @NotNull
    var name: String,

    var description: String,

    @ManyToMany(
    //mappedBy = "room",
    cascade = [CascadeType.ALL])
    val days: MutableSet<DayEntity> = mutableSetOf(),

    @OneToMany(
    mappedBy = "room",
    cascade = [CascadeType.ALL])
    val timeslots: MutableSet<TimeslotEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String())
}