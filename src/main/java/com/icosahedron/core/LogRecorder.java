package com.icosahedron.core;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.LogbackException;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.Status;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@ExcludeFromJacocoGeneratedReport
public final class LogRecorder {
    private LogRecorder() {}

    public static <T> List<ILoggingEvent> record(final Class<T> loggingClass,
                                                 final Level logLevel,
                                                 final Runnable unit) {
        return record(LoggerFactory.getLogger(loggingClass), logLevel, unit);
    }

    public static List<ILoggingEvent> record(final org.slf4j.Logger slf4jLogger,
                                             final Level logLevel,
                                             final Runnable unit) {

        final Logger logger = (Logger) slf4jLogger;
        final EventRecorder eventAppender = new EventRecorder(logLevel);
        logger.addAppender(eventAppender);

        try {
            unit.run();
        } finally {
            logger.detachAppender(eventAppender);
        }

        return eventAppender.recordedEvents;
    }

    @ExcludeFromJacocoGeneratedReport
    private static class EventRecorder implements Appender<ILoggingEvent> {
        private final Level logLevel;
        private final List<ILoggingEvent> recordedEvents = new ArrayList<>();

        public EventRecorder(Level logLevel) {
            this.logLevel = logLevel;
        }

        @Override
        public void doAppend(final ILoggingEvent event) throws LogbackException {
            if (event.getLevel().isGreaterOrEqual(logLevel)) {
                recordedEvents.add(event);
            }
        }

        // default overrides
        @Override public String getName() { return null; }
        @Override public void setName(String s) {}
        @Override public void setContext(Context context) {}
        @Override public Context getContext() { return null; }
        @Override public void addStatus(Status status) {}
        @Override public void addInfo(String s) {}
        @Override public void addInfo(String s, Throwable throwable) {}
        @Override public void addWarn(String s) {}
        @Override public void addWarn(String s, Throwable throwable) {}
        @Override public void addError(String s) {}
        @Override public void addError(String s, Throwable throwable) {}
        @Override public void addFilter(Filter<ILoggingEvent> filter) {}
        @Override public void clearAllFilters() {}
        @Override public List<Filter<ILoggingEvent>> getCopyOfAttachedFiltersList() { return null; }
        @Override public FilterReply getFilterChainDecision(ILoggingEvent iLoggingEvent) { return null; }
        @Override public void start() {}
        @Override public void stop() {}
        @Override public boolean isStarted() { return false; }
    }
}