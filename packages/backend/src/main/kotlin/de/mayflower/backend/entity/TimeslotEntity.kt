package de.mayflower.backend.entity

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Boolean
import io.azam.ulidj.ULID
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.UUID
import java.sql.Time
import java.time.LocalTime
import java.util.Date

@Entity
@Table(name = "timeslot")
class TimeslotEntity(
    @NotNull
    val start: Time,

    @NotNull
    val end: Time,

    @ManyToOne(cascade = [CascadeType.ALL])
    val room: RoomEntity = RoomEntity(),

    @OneToMany(
        mappedBy = "timeslot",
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "id", nullable = false)
    val sessions: MutableSet<SessionEntity> = mutableSetOf(),

    @NotNull
    val isBreak: Boolean,

    @NotNull
    val isBlocking: Boolean,

    @NotNull
    val isNoBlockingBreak: Boolean,

    @ManyToOne(cascade = [CascadeType.ALL])
    val timeslotSize: TimeslotSizeEntity = TimeslotSizeEntity()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(
        Time.valueOf(LocalTime.now()),
        Time.valueOf(LocalTime.now()),
        RoomEntity(),
        mutableSetOf(),
        false,
        false,
        false,
        TimeslotSizeEntity()
    )
}
