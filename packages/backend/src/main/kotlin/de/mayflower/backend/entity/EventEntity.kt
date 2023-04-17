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
    val name: String,

    @NotNull
    val description: String,

    @NotNull
    val location: String,

    @NotNull
    val startDate: Date,

    @NotNull
    val endDate: Date

) {
    @Id
    @GenericGenerator(name = "ulid_generator", strategy = "de.mayflower.backend.helper.UlidGenerator")
    @GeneratedValue(generator = "ulid_generator")
    val id: String = String()

    constructor() : this(String(), String(), String(), Date(), Date())
}