package org.ehsan.dto

data class UserCreateDto(
    val phone: Long,
    val name: String,
    val family: String
)