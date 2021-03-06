package org.ehsan.document

import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.ehsan.dto.UserRole
import org.ehsan.dto.UserUpdateDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
class UserDocument(
    @Id
    var id: String?,
    val phone: Long,
    val name: String,
    val family: String,
    val pass: String,
    val roles: List<UserRole>
) {
    fun toDto() = UserDto(
        id!!,
        phone,
        name,
        family,
        pass,
        roles
    )
}

fun UserCreateDto.to(): UserDocument {
    return UserDocument(null, phone, name, family, pass, listOf(UserRole.USER))
}

fun UserUpdateDto.to(current: UserDocument) = UserDocument(
    current.id,
    current.phone,
    name ?: current.name,
    family ?: current.family,
    pass ?: current.pass,
    roles ?: current.roles
)