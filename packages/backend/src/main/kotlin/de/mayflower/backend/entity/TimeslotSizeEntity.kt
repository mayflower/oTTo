package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.UUID
import java.util.Date

@Entity
@Table(name = "timeslotSize")
class TimeslotSizeEntity(
    @NotNull
    val name: String,

    @NotNull
    val minutes: Number,

    @OneToMany(
        mappedBy = "timeslotSize",
        cascade = [CascadeType.ALL]
    )
    val timeslots: MutableSet<TimeslotEntity> = mutableSetOf()
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), 0, mutableSetOf())
}
