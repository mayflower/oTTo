package de.mayflower.backend.service

import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.helper.ModelParser
import de.mayflower.backend.repository.EventRepository
import de.mayflower.backend.stubs.api.EventsControllerDelegate
import de.mayflower.backend.stubs.model.Event
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service("eventsControllerDelegate")
class EventsService(
    private val eventRepo: EventRepository,
    private val parser: ModelParser
) : EventsControllerDelegate {

    override fun createEvent(event: Event?): ResponseEntity<Event> {
//        if(event === null) {
//            return ResponseEntity(HttpStatus.BAD_REQUEST)
//        }

        return ResponseEntity(
            createOrUpdateEvent(event!!),
            HttpStatus.CREATED
        )
    }

    override fun getEventById(id: String): ResponseEntity<Event> {
        val eventDatabaseEntity = this.eventRepo.findById(id)

        if (eventDatabaseEntity.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val event = eventDatabaseEntity.get().asDto()

        return ResponseEntity(event, HttpStatus.OK)
    }

    override fun changeEventById(id: String, event: Event?): ResponseEntity<Unit> {
//        if(event === null) {
//            return ResponseEntity(HttpStatus.BAD_REQUEST)
//        }
        if (id != event!!.id) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        createOrUpdateEvent(event)

        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteEventById(id: String): ResponseEntity<Unit> {
        this.eventRepo.deleteById(id)

        return ResponseEntity(HttpStatus.OK)
    }

    private fun createOrUpdateEvent(event: Event): Event {
        val eventEntity = parser.parse<Event, EventEntity>(event)
        val newEvent = this.eventRepo.save(eventEntity)
        return parser.parse(newEvent)
    }
}