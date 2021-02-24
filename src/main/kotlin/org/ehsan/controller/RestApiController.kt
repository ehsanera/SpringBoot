package org.ehsan.controller

import org.ehsan.annotation.ApiMapping
import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.ehsan.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@ApiMapping
class RestApiController @Autowired constructor(
    private val userService: UserService
) {
    @PostMapping("user")
    fun save(@RequestBody create: UserCreateDto): ResponseEntity<UserDto> {
        return ResponseEntity(userService.save(create), HttpStatus.CREATED)
    }

    @GetMapping("user/{id}")
    fun save(@PathVariable id: String): ResponseEntity<UserDto> {
        val user = userService.get(id)
        return if (user == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(user, HttpStatus.OK)
        }
    }
}