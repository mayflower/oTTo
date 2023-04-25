package de.mayflower.backend.entity

import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Sponsor
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator
import java.net.URI
import java.util.*

@Entity
@Table(name = "sponsor")
class SponsorEntity(
title: String,
url: String,
image: String,

) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    @NotNull
    var title: String = title

    var url: String = url

    var image: String = image

    @ManyToOne(cascade = [CascadeType.ALL])
    var event: EventEntity = EventEntity()

    constructor() : this(String(), String(), String())

    constructor(sponsor: Sponsor) : this(
            sponsor.name,
            sponsor.url.toString(),
            sponsor.image.toString(),
    )

    fun asDto(): Sponsor {
        return Sponsor(
                this.id,
                this.title,
                URI(this.url),
                URI(this.image),
        )
    }
}
