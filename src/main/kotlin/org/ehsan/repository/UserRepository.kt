package org.ehsan.repository

import org.ehsan.document.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserDocument, String> {
    fun findByPhone(phone: Long): UserDocument?
}