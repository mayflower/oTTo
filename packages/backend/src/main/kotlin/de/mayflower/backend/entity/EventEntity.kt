package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Event
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import java.net.URI

@Entity
@Table(name = "event")
class EventEntity(
name: String,
description: String,
details: String,
location: String,
url: String
) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    @NotBlank
    var name: String = name

    @NotNull
    var description: String = description

    @NotNull
    var details: String = details

    @NotNull
    var location: String = location

    var url: String = url

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY
            // cascade = [CascadeType.ALL] // TODO: deleteById doesn'work with this line
    )
    var days: MutableSet<DayEntity> = mutableSetOf<DayEntity>()

    @OneToMany(
            mappedBy = "event",
            //cascade = [CascadeType.ALL]
    )
    var sponsors: MutableSet<SponsorEntity> = mutableSetOf<SponsorEntity>()

    constructor() : this(String(), String(), String(), String(), String())

    constructor(event: Event) : this(
            event.name,
            event.description,
            event.details,
            event.location,
            event.url.toString(),
            )

    fun asDto(): Event {
        return Event(
                this.id,
                this.name,
                this.description,
                this.location,
                this.details,
                URI(this.url)
        )
    }
}