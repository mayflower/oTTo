package de.mayflower.backend.repository

import de.mayflower.backend.entity.RoomEntity
import org.springframework.data.repository.ListCrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository

interface RoomRepository : ListCrudRepository<RoomEntity, String>, ListPagingAndSortingRepository<RoomEntity, String> {
}