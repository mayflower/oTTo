package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Day
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.time.ZoneId
import java.util.Date

@Entity
@Table(name = "day")
class DayEntity(
    @NotNull
    val date: Date,

    val note: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    val event: EventEntity = EventEntity(),

    @ManyToMany(cascade = [CascadeType.ALL])
    val rooms: MutableSet<RoomEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(Date(), String())

    fun toDTO(): Day {
        return Day(
                this.id,
                this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                this.note,
        )
    }

    companion object {
        fun fromDTO(day: Day): DayEntity {
            return DayEntity(
                    Date.from(day.date.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    day.note.toString(),
            )
        }
    }
}
