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
    val name: String,
    val family: String
) {
    fun toDto() = UserDto(
        id!!,
        phone,
        name,
        family
    )
}

fun UserCreateDto.to(): UserDocument {
    return UserDocument(null, phone, name, family)
}