package de.mayflower.backend.repository

import de.mayflower.backend.entity.EventEntity
import org.springframework.data.repository.ListCrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository

interface EventRepository : ListCrudRepository<EventEntity, String>, ListPagingAndSortingRepository<EventEntity, String> {
}