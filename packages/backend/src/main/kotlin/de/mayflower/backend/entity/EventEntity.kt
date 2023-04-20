package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Event
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.repository.Modifying
import java.net.URI
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
    var details: String,

    @NotNull
    var location: String,

    var url: String,

        // @OneToMany(
        //mappedBy = "event",
        //       cascade = [CascadeType.ALL])
        //   var days: MutableSet<DayEntity> = mutableSetOf<DayEntity>(),

        //  @OneToMany(
        //mappedBy = "event",
        //      cascade = [CascadeType.ALL])
        //  var sponsors: MutableSet<SponsorEntity> = mutableSetOf<SponsorEntity>(),

) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), String(), String())

    fun toDTO(): Event {
        return Event(this.id, this.name, this.description, this.location, this.details, URI(this.url))
    }
    companion object {
        fun fromDTO(event: Event): EventEntity {
            return EventEntity(event.name, event.description, event.details, event.location, event.url.toString())
        }
    }
}