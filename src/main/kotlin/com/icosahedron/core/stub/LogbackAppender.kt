package com.icosahedron.core.stub

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.Appender
import ch.qos.logback.core.Context
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply
import ch.qos.logback.core.status.Status

open class LogbackAppender : Appender<ILoggingEvent> {
    override fun doAppend(event: ILoggingEvent) {}
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