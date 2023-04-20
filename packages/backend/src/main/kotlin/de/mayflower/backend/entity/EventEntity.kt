package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.util.Date

@Entity
@Table(name = "event")
class EventEntity(
    @NotNull
    @NotBlank
    var name: String,

    @NotNull
    var description: String,

    @NotNull
    var location: String,

    @NotNull
    var startDate: Date,

    @NotNull
    var endDate: Date,

    var url: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    var style: Style = Style(),

    @OneToMany(
        //mappedBy = "event",
        cascade = [CascadeType.ALL])
    var days: MutableSet<DayEntity> = mutableSetOf<DayEntity>(),

    @OneToMany(
        //mappedBy = "event",
        cascade = [CascadeType.ALL])
    var sponsors: MutableSet<SponsorEntity> = mutableSetOf<SponsorEntity>(),

    @OneToMany(
        mappedBy = "event",
        cascade = [CascadeType.ALL])
    var sessions: MutableSet<SessionEntity> = mutableSetOf(),

) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), Date(), Date(), String())

}