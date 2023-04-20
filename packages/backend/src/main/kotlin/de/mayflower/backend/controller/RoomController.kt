package de.mayflower.backend.controller

import de.mayflower.backend.entity.RoomEntity
import de.mayflower.backend.repository.RoomRepository
import de.mayflower.backend.stubs.api.RoomsControllerDelegate
import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Timeslot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.Date

@Component("roomsControllerDelegate")
class RoomController(private val roomRepository: RoomRepository) : RoomsControllerDelegate  {

    override fun getRooms(): ResponseEntity<List<Room>> {
        val roomsEntityList = this.roomRepository.findAll()

        // TODO: get correct timeslot list
        val rooms = roomsEntityList.map {  Room(it.id, it.name, it.timeslots.map {
            Timeslot(it.id, it.room.id, it.start, it.end,  )
        }) }

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
}