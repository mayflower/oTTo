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
    @NotBlank
    var abstract: String,

    @NotNull
    var start_timestamp: Long,

    @NotNull
    var end_timestamp: Long,

    @ManyToOne(cascade = [CascadeType.ALL])
    var room: RoomEntity = RoomEntity(),

    var description: String = String()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), -1, -1)
}