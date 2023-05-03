package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Timeslot
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator
import java.sql.Time
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "timeslot")
class TimeslotEntity(
start: Time,
end: Time
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    val start: Time = start

    @NotNull
    val end: Time = end

    @ManyToOne(cascade = [CascadeType.ALL])
    val room: RoomEntity = RoomEntity()

    @ManyToOne(
            //mappedBy = "timeslot",
            cascade = [CascadeType.ALL]
    )
    val session: SessionEntity = SessionEntity()

    @NotNull
    val isBreak: Boolean = false

    @NotNull
    val isBlocking: Boolean = false

    constructor() : this(
        Time.valueOf(LocalTime.now()),
        Time.valueOf(LocalTime.now())
    )

    constructor(timeslot: Timeslot) : this(
        Time.valueOf(timeslot.startTime),
        Time.valueOf(timeslot.endTime)
    )

    fun asDto(): Timeslot {
        return Timeslot(
            this.id,
            this.start.toString(),
            this.end.toString()
        )
    }
}
