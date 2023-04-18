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

    @ManyToOne(cascade = [CascadeType.ALL])
    val event: EventEntity = EventEntity(),

    @OneToMany(
        mappedBy = "day",
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "id", nullable = false)
    val rooms: MutableSet<RoomEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(Date(), String(), EventEntity(), mutableSetOf<RoomEntity>())
}
