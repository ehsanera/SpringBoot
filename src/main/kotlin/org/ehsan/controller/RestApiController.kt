package org.ehsan.controller

import org.ehsan.annotation.ApiMapping
import org.ehsan.config.TenantContext
import org.ehsan.dto.UserCreateDto
import org.ehsan.dto.UserDto
import org.ehsan.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@ApiMapping
class RestApiController @Autowired constructor(
    private val userService: UserService
) {
    @PostMapping("user")
    fun save(@RequestParam tenant: String, @RequestBody create: UserCreateDto): ResponseEntity<UserDto> {
        TenantContext.setCurrentTenant(tenant)
        return ResponseEntity(userService.save(create), HttpStatus.CREATED)
    }

    @GetMapping("user")
    fun get(): ResponseEntity<List<UserDto>> {
        return ResponseEntity(userService.getAll(), HttpStatus.OK)
    }

    @GetMapping("user/getById/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<UserDto> {
        val user = userService.get(id)
        return if (user == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(user, HttpStatus.OK)
        }
    }
}