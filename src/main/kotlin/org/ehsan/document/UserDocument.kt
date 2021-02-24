package org.ehsan.document

import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
class UserDocument(
    @Id
    var id: String?,
    val phone: Long,
    val name: String
) {
    fun toDto() = UserDto(
        id!!,
        phone,
        name
    )
}

fun UserCreateDto.to(): UserDocument {
    return UserDocument(null, phone, name)
}