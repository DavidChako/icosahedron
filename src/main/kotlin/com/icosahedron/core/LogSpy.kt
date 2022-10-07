package com.icosahedron.core

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.Appender
import ch.qos.logback.core.Context
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply
import ch.qos.logback.core.status.Status
import org.slf4j.LoggerFactory
import java.lang.reflect.UndeclaredThrowableException

class LogSpy(loggingClass: Class<out Any>, logLevel: Level) {
    private val logger: Logger = LoggerFactory.getLogger(loggingClass) as Logger
    private val appender: EventAppender = EventAppender(logLevel)

    fun getEmpty(): Boolean = appender.events.isEmpty()
    fun getSize(): Int = appender.events.size
    fun getEvents(): List<ILoggingEvent> = appender.events
    fun getFirstEvent(): ILoggingEvent = appender.events.first()
    fun getLastEvent(): ILoggingEvent = appender.events.last()
    fun eventAtOffset(offset: Int): ILoggingEvent = appender.events[offset]
    fun getMessages(): List<String> = appender.events.map { it.toString() }
    fun getFirstMessage(): String = appender.events.first().toString()
    fun getLastMessage(): String = appender.events.last().toString()
    fun messageAtOffset(offset: Int): String = appender.events[offset].toString()
    fun watch(execution: () -> Unit)  = capture(execution)

    fun <T> capture(execution: () -> T?): T?  = try {
        appender.clear()
        logger.addAppender(appender)
        execution()
    } catch (cause: Throwable) {
        throw if (cause is UndeclaredThrowableException) cause.undeclaredThrowable else cause
    } finally {
        logger.detachAppender(appender)
    }

    private class EventAppender(private val logLevel: Level) : Appender<ILoggingEvent> {
        val events = mutableListOf<ILoggingEvent>()
        fun clear() { events.clear() }
        override fun doAppend(event: ILoggingEvent) { if (event.level.isGreaterOrEqual(logLevel)) events.add(event) }
        override fun start() {}
        override fun stop() {}
        override fun isStarted() = false
        override fun setContext(context: Context?) {}
        override fun getContext(): Context? = null
        override fun addStatus(status: Status?) {}
        override fun addInfo(msg: String?) {}
        override fun addInfo(msg: String?, ex: Throwable?) {}
        override fun addWarn(msg: String?) {}
        override fun addWarn(msg: String?, ex: Throwable?) {}
        override fun addError(msg: String?) {}
        override fun addError(msg: String?, ex: Throwable?) {}
        override fun addFilter(newFilter: Filter<ILoggingEvent>?) {}
        override fun clearAllFilters() {}
        override fun getCopyOfAttachedFiltersList(): MutableList<Filter<ILoggingEvent>>? = null
        override fun getFilterChainDecision(event: ILoggingEvent?): FilterReply? = null
        override fun getName(): String? = null
        override fun setName(name: String?) {}
    }
}