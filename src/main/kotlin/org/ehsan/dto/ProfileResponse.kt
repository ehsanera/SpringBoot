package org.ehsan.dto


data class ProfileResponse(
    val id: String,
    val phone: Long,
    val name: String,
    val family: String,
    val roles: List<UserRole>
)
