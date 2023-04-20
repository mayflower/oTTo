package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator
import java.sql.Time
import java.time.LocalTime

@Entity
@Table(name = "timeslot")
class TimeslotEntity(
    @NotNull
    val start: Time,

    @NotNull
    val end: Time,

    @ManyToOne(cascade = [CascadeType.ALL])
    val room: RoomEntity = RoomEntity(),

    @ManyToOne(
        //mappedBy = "timeslot",
        cascade = [CascadeType.ALL]
    )
    val session: SessionEntity = SessionEntity(),

    @NotNull
    val isBreak: Boolean,

    @NotNull
    val isBlocking: Boolean,

    @NotNull
    val isNoBlockingBreak: Boolean,
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(
        Time.valueOf(LocalTime.now()),
        Time.valueOf(LocalTime.now()),
        RoomEntity(),
        SessionEntity(),
        false,
        false,
        false
    )
}
