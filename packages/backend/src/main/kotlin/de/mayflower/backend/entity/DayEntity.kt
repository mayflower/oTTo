package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.util.Date

@Entity
@Table(name = "day")
class DayEntity(
    @NotNull
    val date: Date,

    @NotNull
    val note: String,

        // @ManyToOne(cascade = [CascadeType.ALL])
        // val event: EventEntity = EventEntity(),

    @ManyToMany(cascade = [CascadeType.ALL])
    val rooms: MutableSet<RoomEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(Date(), String())
}
