package org.ehsan.controller

import org.ehsan.annotation.ApiMapping
import org.ehsan.dto.CreateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@ApiMapping
class RestApiController {
    @GetMapping("rest")
    fun get(): ResponseEntity<String> {
        Thread.sleep(3000)
        return ResponseEntity("hello world", HttpStatus.OK)
    }

    @PostMapping("rest/{name}")
    fun post(
        @PathVariable name: String,
        @RequestParam age: Int,
        @RequestBody create: CreateDto
    ): ResponseEntity<String> {
        return ResponseEntity("hi $name age:$age family: ${create.family} work: ${create.work}", HttpStatus.CREATED)
    }
}