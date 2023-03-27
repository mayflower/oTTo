package de.mayflower.backend.repository

import de.mayflower.backend.entity.SessionEntity
import org.springframework.data.repository.ListCrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository

interface SessionRepository : ListCrudRepository<SessionEntity, String>, ListPagingAndSortingRepository<SessionEntity, String> {
}