package de.mayflower.backend.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "room")
class RoomEntity(
    val name: String,

    @OneToMany(
    mappedBy = "room",
    cascade = [CascadeType.ALL])
    val sessions: MutableSet<SessionEntity> = mutableSetOf<SessionEntity>()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String())
}