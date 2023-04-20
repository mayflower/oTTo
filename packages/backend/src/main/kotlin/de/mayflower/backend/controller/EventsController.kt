package de.mayflower.backend.controller

import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.entity.RoomEntity
import de.mayflower.backend.repository.EventRepository
import de.mayflower.backend.repository.RoomRepository
import de.mayflower.backend.stubs.api.EventsControllerDelegate
import de.mayflower.backend.stubs.model.Event
import de.mayflower.backend.stubs.model.Room
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI
import java.sql.Timestamp
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

    override fun deleteEventById(id: String): ResponseEntity<Unit> {
        val eventDatabaseEntity = this.eventRepository.deleteById(id)

        return ResponseEntity(HttpStatus.OK)
    }

    /*
    override fun getRooms(): ResponseEntity<List<Room>> {
        val roomsEntityList = this.roomRepository.findAll()

        // TODO: get correct timeslot list
        /*val rooms = roomsEntityList.map {  Room(it.id, it.name, it.timeslots.map {
            Timeslot(it.id, it.room.id, it.start, it.end,  )
        }) }*/

        return ResponseEntity(HttpStatus.OK)
    }

    override fun createRoom(room: Room?): ResponseEntity<Room> {

        if(room === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val roomEntity = RoomEntity(room.name, "description")

        this.roomRepository.save(roomEntity)

        return ResponseEntity(room, HttpStatus.CREATED)
    }

    override fun changeRoomById(id: String, room: Room?): ResponseEntity<Unit> {

        val roomEntity = this.roomRepository.findById(id)

        if(room === null || roomEntity.isEmpty) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }


        //val roomEntity = RoomEntity(room.name, "description")



        return super.changeRoomById(id, room)
    }

    override fun deleteRoomById(id: String): ResponseEntity<Unit> {
        this.roomRepository.deleteById(id)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
     */
}