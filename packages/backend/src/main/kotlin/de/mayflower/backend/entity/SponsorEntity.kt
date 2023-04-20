package de.mayflower.backend.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "sponsor")
class SponsorEntity(
    @NotNull
    var title: String,

    var description: String,

    var url: String,

    var image: String,

        //@ManyToOne(cascade = [CascadeType.ALL])
        //var event: EventEntity = EventEntity(),

) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), String())
}
