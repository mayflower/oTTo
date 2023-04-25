package de.mayflower.backend.service

import de.mayflower.backend.entity.DayEntity
import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.entity.RoomEntity
import de.mayflower.backend.entity.SponsorEntity
import de.mayflower.backend.repository.EventRepository
import de.mayflower.backend.stubs.api.EventsControllerDelegate
import de.mayflower.backend.stubs.model.Day
import de.mayflower.backend.stubs.model.Event
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.ZoneId
import java.util.*

@Service("eventsControllerDelegate")
class EventsService(private val eventRepository: EventRepository) : EventsControllerDelegate  {

    override fun createEvent(event: Event?): ResponseEntity<Event> {
        if(event === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val eventEntity = EventEntity.fromDto(event)

        val eventDatabaseEntity = this.eventRepository.save(eventEntity)

        return ResponseEntity(eventDatabaseEntity.asDto(), HttpStatus.CREATED)
    }

    override fun getEventById(id: String): ResponseEntity<Event> {
        val eventDatabaseEntity = this.eventRepository.findById(id)

        if(eventDatabaseEntity.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val event = eventDatabaseEntity.get().asDto()

        return ResponseEntity(event, HttpStatus.OK)
    }

    override fun changeEventById(id: String, event: Event?): ResponseEntity<Unit> {
        if(event === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val days = mutableSetOf<DayEntity>()

        event.days?.forEach { day: Day ->
            run {
                val dayEntity = DayEntity(Date.from(day.date.atStartOfDay(ZoneId.systemDefault()).toInstant()), day.note.toString())
                days += setOf<DayEntity>(dayEntity)
            }
        }

        val eventDatabaseEntity = EventEntity(event.name, event.description, event.details, event.location, event.url.toString())

        this.eventRepository.save(eventDatabaseEntity)

        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteEventById(id: String): ResponseEntity<Unit> {
        this.eventRepository.deleteById(id)

        return ResponseEntity(HttpStatus.OK)
    }
}