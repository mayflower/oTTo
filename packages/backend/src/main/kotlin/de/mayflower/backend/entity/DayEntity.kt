package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Day
import de.mayflower.backend.stubs.model.Event
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.time.ZoneId
import java.util.Date
import java.util.Optional

@Entity
@Table(name = "day")
class DayEntity(
    date: Date,
    note: String
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    var date: Date = date

    var note: String = note

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var event: EventEntity? = null

    @ManyToMany(cascade = [CascadeType.ALL])
    val rooms: MutableSet<RoomEntity> = mutableSetOf()

    constructor() : this(Date(), String())

    constructor(day: Day) : this(
            Date.from(day.date.atStartOfDay(ZoneId.systemDefault()).toInstant()),
            day.note.toString()
    )

    fun asDto(): Day {
        return Day(
                this.id,
                this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                this.note,
        )
    }
}
