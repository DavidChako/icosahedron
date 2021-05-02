package com.icosahedron.explore.spring.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.data.annotation.Id
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*

@PropertySource("classpath:explore/spring/web/application.properties")
@SpringBootApplication
class SpringWebDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringWebDemoApplication>(*args)
}

@RestController
class MessageResource(val service: MessageService) {
    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> = service.findMessageById(id)

    @PostMapping
    fun post(@RequestBody message: Message) {
        service.post(message)
    }
}

@Service
class MessageService(val db: JdbcTemplate) {
    fun findMessages(): List<Message> =
        db.query("SELECT * FROM MESSAGES") { resultSet, _ -> Message(
            resultSet.getString("id"),
            resultSet.getString("text"))
        }

    fun findMessageById(id: String): List<Message> =
        db.query("SELECT * FROM MESSAGES WHERE id=?", id) { resultSet, _ -> Message(
            resultSet.getString("id"),
            resultSet.getString("text"))
        }

    fun post(message: Message) {
        db.update("INSERT INTO MESSAGES VALUES (?,?)", message.id ?: message.text.uuid(), message.text)
    }
}

fun String.uuid(): String = UUID.nameUUIDFromBytes(encodeToByteArray()).toString()

data class Message(@Id val id: String?, val text: String)

