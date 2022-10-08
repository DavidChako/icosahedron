package com.icosahedron.core

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import com.icosahedron.core.stub.LogbackAppender
import org.slf4j.LoggerFactory
import java.lang.reflect.UndeclaredThrowableException

class LogRecord(loggingClass: Class<out Any>, logLevel: Level): LogbackAppender() {
    private val logger: Logger = LoggerFactory.getLogger(loggingClass) as Logger
    private val appender: EventAppender = EventAppender(logLevel)
    private val events get() = appender.events

    fun getEmpty(): Boolean = events.isEmpty()
    fun getSize(): Int = events.size
    fun getFirstEvent(): ILoggingEvent = events.first()
    fun getLastEvent(): ILoggingEvent = events.last()
    fun eventAtOffset(offset: Int): ILoggingEvent = events[offset]
    fun getMessages(): List<String> = events.map { it.toString() }
    fun getFirstMessage(): String = events.first().toString()
    fun getLastMessage(): String = events.last().toString()
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