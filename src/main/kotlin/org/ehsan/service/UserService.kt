package org.ehsan.service

import org.ehsan.document.to
import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.ehsan.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun save(t: UserCreateDto): UserDto {
        return userRepository.save(t.to()).toDto()
    }

    fun get(id: String): UserDto? {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            user.get().toDto()
        } else {
            null
        }
    }

    fun getAll(): List<UserDto>? {
        return userRepository.findAll().map { it.toDto() }
    }
}
