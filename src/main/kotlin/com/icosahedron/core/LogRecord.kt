package com.icosahedron.core

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import com.icosahedron.stub.LogbackAppender
import org.slf4j.LoggerFactory
import java.lang.reflect.UndeclaredThrowableException
import kotlin.reflect.KClass

class LogRecord(loggingClass: Class<out Any>, logLevel: Level): LogbackAppender() {
    constructor(loggingKClass: KClass<out Any>, logLevel: Level): this(loggingKClass.java, logLevel)

    private val logger: Logger = LoggerFactory.getLogger(loggingClass) as Logger
    private val appender: EventAppender = EventAppender(logLevel)
    private val events get() = appender.events

    val empty get() = events.isEmpty()
    val size get() = events.size
    val firstEvent get() = events.first()
    val lastEvent get() = events.last()
    val messages get() = events.map { it.toString() }
    val firstMessage get() = events.first().toString()
    val lLastMessage get() = events.last().toString()

    fun eventAtOffset(offset: Int): ILoggingEvent = events[offset]
    fun messageAtOffset(offset: Int): String = events[offset].toString()

    fun <T> capture(
        execution: () -> T?
    ): T? = try {
        appender.clear()
        logger.addAppender(appender)
        execution()
    } catch (cause: Throwable) {
        throw if (cause is UndeclaredThrowableException) cause.undeclaredThrowable else cause
    } finally {
        logger.detachAppender(appender)
    }

    private class EventAppender(private val logLevel: Level) : LogbackAppender() {
        val events = mutableListOf<ILoggingEvent>()
        fun clear() { events.clear() }
        override fun doAppend(event: ILoggingEvent) { if (event.level.isGreaterOrEqual(logLevel)) events.add(event) }
    }
}