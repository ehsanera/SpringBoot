package org.ehsan.service


import org.ehsan.document.to
import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.ehsan.dto.UserUpdateDto
import org.ehsan.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun getAll(): List<UserDto>? {
        return userRepository.findAll().map { it.toDto() }
    }

    fun getById(id: String): UserDto? {
        return userRepository.findByIdOrNull(id)?.toDto()
    }

    fun save(t: UserCreateDto): UserDto {
        return userRepository.save(t.to()).toDto()
    }

    fun update(id: String, t: UserUpdateDto): UserDto? {
        val currentUserDocument = userRepository.findByIdOrNull(id) ?: return null
        return userRepository.save(t.to(currentUserDocument)).toDto()
    }

    fun getByPhone(phone: Long): UserDto? {
        return userRepository.findByPhone(phone)?.toDto()
    }
}
