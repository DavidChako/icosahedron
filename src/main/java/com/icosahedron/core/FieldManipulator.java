package com.icosahedron.core;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExcludeFromJacocoGeneratedReport
public final class FieldManipulator {
    private FieldManipulator() {}

    public static <T> T declaredFieldValue(final Object object,
                                           final String fieldName,
                                           final Class<T> type) {
        return declaredFieldValue(object.getClass(), object, fieldName, type);
    }

    public static <T> T declaredFieldValue(final Class<?> declaringClass,
                                           final Object object,
                                           final String fieldName,
                                           final Class<T> type) {
        final AtomicReference<Field> fieldReference = new AtomicReference<>();
        final AtomicBoolean fieldIsAccessible = new AtomicBoolean(false);

        try {
            final Field field = declaringClass.getDeclaredField(fieldName);
            fieldReference.set(field);
            fieldIsAccessible.set(field.isAccessible());
            field.setAccessible(true);
            return type.cast(field.get(object));
        } catch (final Throwable cause) {
            throw new IllegalStateException("Failed to get value of declared field " + fieldName + " from object: " + object);
        } finally {
            fieldReference.get().setAccessible(fieldIsAccessible.get());
        }
    }

    public static List<Field> declaredNonStaticFields(final Class<?> type) {
        return Stream.of(type.getDeclaredFields()).filter(FieldManipulator::fieldIsNotStatic).collect(Collectors.toList());
    }

    public static void setDeclaredFieldValue(final Object object,
                                             final String fieldName,
                                             final Object value) {
        final AtomicReference<Field> fieldReference = new AtomicReference<>();
        final AtomicBoolean fieldIsAccessible = new AtomicBoolean(false);

        try {
            final Field field = object.getClass().getDeclaredField(fieldName);
            fieldReference.set(field);
            fieldIsAccessible.set(field.isAccessible());
            field.setAccessible(true);
            field.set(object, value);
        } catch (final Throwable cause) {
            throw new IllegalStateException("Failed to set value of declared field " + fieldName + " on object: " + object);
        } finally {
            fieldReference.get().setAccessible(fieldIsAccessible.get());
        }
    }

    public static boolean fieldIsNotStatic(final Field field) {
        return !Modifier.isStatic(field.getModifiers());
    }
}
