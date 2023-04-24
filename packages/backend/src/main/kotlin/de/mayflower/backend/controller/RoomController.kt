package de.mayflower.backend.controller

import de.mayflower.backend.entity.RoomEntity
import de.mayflower.backend.repository.RoomRepository
import de.mayflower.backend.stubs.api.RoomsControllerDelegate
import de.mayflower.backend.stubs.model.Room
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component("roomsControllerDelegate")
class RoomController(private val roomRepository: RoomRepository) : RoomsControllerDelegate  {

    override fun getRooms(): ResponseEntity<List<Room>> {
        val roomsEntityList = this.roomRepository.findAll()

        val rooms = roomsEntityList.map {  Room(it.id, it.name) }

        return ResponseEntity(rooms, HttpStatus.OK)
    }

    override fun createRoom(room: Room?): ResponseEntity<Room> {

        if(room === null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        val roomEntity = RoomEntity(room.name, "description")

        this.roomRepository.save(roomEntity)

        return ResponseEntity(room, HttpStatus.CREATED)
    }
}