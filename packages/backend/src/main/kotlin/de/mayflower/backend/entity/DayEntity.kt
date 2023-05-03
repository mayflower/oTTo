package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Day
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator
import java.time.ZoneId
import java.util.*

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
    var rooms: MutableSet<RoomEntity> = mutableSetOf()

    constructor() : this(Date(), String())

    @Deprecated("inject ModelParser and use Modelparser.parse()")
    constructor(day: Day) : this(
            Date.from(day.date.atStartOfDay(ZoneId.systemDefault()).toInstant()),
            day.note.toString()
    )

    @Deprecated("inject ModelParser and use Modelparser.parse()")
    fun asDto(): Day {
        return Day(
                this.id,
                this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                this.note,
        )
    }
}
