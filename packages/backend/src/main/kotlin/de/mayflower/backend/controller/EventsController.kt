package de.mayflower.backend.controller

import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.repository.EventRepository
import de.mayflower.backend.stubs.api.EventsControllerDelegate
import de.mayflower.backend.stubs.model.Event
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component("roomsControllerDelegate")
class EventsController(private val eventRepository: EventRepository) : EventsControllerDelegate  {

    override fun createEvent(event: Event?): ResponseEntity<Event> {
        if(event === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val eventEntity = EventEntity.fromDTO(event)

        val eventDatabaseEntity = this.eventRepository.save(eventEntity)

        return ResponseEntity(eventDatabaseEntity.toDTO(), HttpStatus.CREATED)
    }

    override fun getEventById(id: String): ResponseEntity<Event> {
        val eventDatabaseEntity = this.eventRepository.findById(id)

        if(eventDatabaseEntity.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        val event = eventDatabaseEntity.get().toDTO()

        return ResponseEntity(event, HttpStatus.OK)
    }

    override fun changeEventById(id: String, event: Event?): ResponseEntity<Unit> {
        if(event === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val eventDatabaseEntity = this.eventRepository.findById(id)

        eventDatabaseEntity.get().name = event.name
        eventDatabaseEntity.get().description = event.description
        eventDatabaseEntity.get().details = event.details
        eventDatabaseEntity.get().location = event.location
        eventDatabaseEntity.get().url = event.url.toString()


        this.eventRepository.save(eventDatabaseEntity.get())

        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteEventById(id: String): ResponseEntity<Unit> {
        this.eventRepository.deleteById(id)

        return ResponseEntity(HttpStatus.OK)
    }
}