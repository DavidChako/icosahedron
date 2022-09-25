package com.icosahedron.core;

import ch.qos.logback.classic.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.temporal.Temporal;
import java.util.*;

@ExcludeFromJacocoGeneratedReport
public final class ObjectManifest {
    private static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    private ObjectManifest() {}

    public static String of (final Object object) throws Exception {
        return of(object, false);
    }

    public static String of(final Object object,
                            final boolean includeSupertype) throws Exception {
        return of(object, new HashSet<>(), includeSupertype);
    }

    public static String of(final Object object,
                            final Set<Class<?>> terminalTypes) throws Exception {
        return of(object, terminalTypes, false);
    }

    public static String of(final Object object,
                            final Set<Class<?>> terminalTypes,
                            boolean includeSupertype) throws Exception {
        if (object == null) {
            return null;
        }

        final Object hierarchy = generateHierarchy(object, terminalTypes, new HashSet<>(), includeSupertype);
        final Class<?> type = object.getClass();

        if (typeReallyIsEnum(type)) {
            final String typeName = rootTypeName(type);

            if (hierarchy == object) {
                return typeName + '.' + object;
            }

            return typeName + '.' + object + '\n' + prettyJsonString(hierarchy);
        }

        return type.getName() + '\n' + prettyJsonString(hierarchy);
    }

    public static String expected(final Class<?> type,
                                  final Map<String, Object> fields) throws Exception {
        return expected(type, new HashSet<>(), fields, new HashSet<>());
    }

    public static String expected(final Class<?> type,
                                  final Map<String, Object> fields,
                                  final Set<Class<?>> terminalTypes) throws Exception {
        return expected(type, new HashSet<>(), fields, terminalTypes);
    }

    public static String expected(final Class<?> type,
                                  final Set<Object> precursors,
                                  final Map<String, Object> fields) throws Exception {
        return expected(type, precursors, fields, new HashSet<>());
    }

    public static String expected(final Class<?> type,
                                  final Set<Object> precursors,
                                  final Map<String, Object> fields,
                                  final Set<Class<?>> terminalTypes) throws Exception {
        if (typeReallyIsEnum(type)) {
            throw new UnsupportedOperationException("Use overload of expected method with enum value as argument");
        }

        final Map<String, Object> hierarchy = generateExpectedHierarchy(type, precursors, fields, terminalTypes);
        return type.getName() + '\n' + prettyJsonString(hierarchy);
    }

    public static <E extends Enum<E>> String expected(final E enumValue,
                                                      final Map<String, Object> fields) throws Exception {
        return expected(enumValue, new HashSet<>(), fields, new HashSet<>());
    }

    public static <E extends Enum<E>> String expected(final E enumValue,
                                                      final Set<Object> precursors,
                                                      final Map<String, Object> fields) throws Exception {
        return expected(enumValue, precursors, fields, new HashSet<>());
    }

    public static <E extends Enum<E>> String expected(final E enumValue,
                                                      final Map<String, Object> fields,
                                                      final Set<Class<?>> terminalTypes) throws Exception {
        return expected(enumValue, new HashSet<>(), fields, terminalTypes);
    }

    public static <E extends Enum<E>> String expected(final E enumValue,
                                                      final Set<Object> precursors,
                                                      final Map<String, Object> fields,
                                                      final Set<Class<?>> terminalTypes) throws Exception {
        final Class<?> type = enumValue.getClass();
        final Map<String, Object> hierarchy = generateExpectedHierarchy(type, precursors, fields, terminalTypes);
        return type.getName() + '.' + enumValue + '\n' + prettyJsonString(hierarchy);
    }

    private static Map<String, Object> generateExpectedHierarchy(final Class<?> type,
                                                                 final Set<Object> precursors,
                                                                 final Map<String, Object> fields,
                                                                 final Set<Class<?>> terminalTypes) throws Exception {
        final Map<String, Object> hierarchy = new LinkedHashMap<>();

        for (final Map.Entry<String, Object> entry : fields.entrySet()) {
            final String fieldName = entry.getKey();
            final Object fieldValue = entry.getValue();
            final Object fieldHierarchy = generateHierarchy(fieldValue, terminalTypes, precursors, false);
            final Field field = type.getDeclaredField(fieldName);
            final String fieldKey = inferValueKey(field, fieldValue);
            hierarchy.put(fieldKey, fieldHierarchy);
        }

        return hierarchy;
    }

    private static Object generateHierarchy(final Object object,
                                            final Set<Class<?>> terminalTypes,
                                            final Set<Object> precursors,
                                            final boolean includeSuperType) throws Exception {
        if (object == null) {
            return null;
        }

        final Class<?> type = object.getClass();
        return generateHierarchy(type, object, terminalTypes, precursors, includeSuperType);
    }

    private static Object generateHierarchy(final Class<?> type,
                                            final Object object,
                                            final Set<Class<?>> terminalTypes,
                                            final Set<Object> precursors,
                                            final boolean includeSuperType) throws Exception {
        if (type == Class.class) {
            return ((Class<?>) object).getSimpleName();
        }

        final List<Field> declaredNonStaticFields = FieldManipulator.declaredNonStaticFields(type);
        final Class<?> supertype = type.getSuperclass();

        if (declaredNonStaticFields.isEmpty() && (!includeSuperType || supertype == Object.class)) {
            if (typeIsCollection(type)) {
                return rectifyCollection(object, terminalTypes, precursors);
            }

            return typeReallyIsEnum(type) ? object : "{}";
        }

        if (typeIsElided(type)) {
            return type.getName();
        }

        if (terminalTypes.contains(type) || typeIsTerminal(type)) {
            return object.toString();
        }

        if (typeIsCollection(type)) {
            return rectifyCollection(object, terminalTypes, precursors);
        }

        final Map<String, Object> fields = new LinkedHashMap<>();
        final Set<Object> fieldPrecursors = new HashSet<>(precursors);
        fieldPrecursors.add(object);

        if (includeSuperType) {
            if (supertype != Object.class && supertype != Enum.class) {
                final Object supertypeHierarchy = generateHierarchy(supertype, object, terminalTypes, new HashSet<>(), true);
                final String supertypeTag = type.getSimpleName() + "_supertype";
                fields.put(supertypeTag, supertypeHierarchy);
            }
        }

        for (final Field field : declaredNonStaticFields) {
            field.setAccessible(true);

            final Object value = field.get(object);
            final String key = inferValueKey(field, value);

            if (fieldPrecursors.contains(value)) {
                fields.put(key, "circular reference");
            } else {
                final Object valueHierarchy = generateHierarchy(value, terminalTypes, fieldPrecursors, false);
                fields.put(key, valueHierarchy);
            }
        }

        return fields;
    }

    private static String inferValueKey(final Field field, final Object value) {
        final Class<?> valueType = value == null ? field.getType() : value.getClass();
        final String valueTypeName = typeReallyIsEnum(valueType) ? inferEnumValueSimpleName(valueType, value) : valueType.getSimpleName();
        final String fieldName = field.getName();

        if (valueTypeName.startsWith("$Proxy")) {
            final Class<?>[] interfaces = valueType.getInterfaces();
            final String interfaceName = interfaces[0].getSimpleName();
            return interfaceName + ' ' + fieldName;
        }

        return valueTypeName + ' ' + fieldName;
    }

    private static String inferEnumValueSimpleName(final Class<?> type,
                                                   final Object value) {
        final String rootName = rootTypeName(type);
        final String[] rootNameFragments = rootName.split("\\.");
        final String simpleName = rootNameFragments[rootNameFragments.length - 1];

        if (FieldManipulator.declaredNonStaticFields(type).isEmpty()) {
            return simpleName;
        }

        return simpleName + '@' + value;
    }

    private static String rootTypeName(final Class<?> type) {
        return type.getName().split("\\$")[0];
    }

    private static boolean typeReallyIsEnum(final Class<?> type) {
        if (type.isEnum()) {
            return true;
        }

        final Class<?> superclass = type.getSuperclass();
        return superclass != null && superclass.isEnum();
    }

    private static boolean typeIsTerminal(final Class<?> type) {
        return type.isPrimitive() ||
                Number.class.isAssignableFrom(type) ||
                Temporal.class.isAssignableFrom(type) ||
                type == String.class ||
                type == Boolean.class ||
                type == Character.class ||
                type == Logger.class ||
                type.getSimpleName().equals("KStreamMap");
    }

    private static boolean typeIsElided(final Class<?> type) {
        return type.getSimpleName().equals("KStreamMap");
    }

    private static boolean typeIsCollection(final Class<?> type) {
        return type.isArray() ||
                Collection.class.isAssignableFrom(type) ||
                Set.class.isAssignableFrom(type) ||
                Map.class.isAssignableFrom(type);
    }

    private static Object rectifyCollection(final Object object,
                                            final Set<Class<?>> terminalTypes,
                                            final Set<Object> precursors) throws Exception {
        final Class<?> type = object.getClass();
        final Set<Object> elementPrecursors = new HashSet<>(precursors);

        if (type.isArray()) {
            return rectifyArray(object, terminalTypes, elementPrecursors);
        }

        if (Set.class.isAssignableFrom(type)) {
            return rectifySet((Set<?>)object, terminalTypes, elementPrecursors);
        }

        if (Map.class.isAssignableFrom(type)) {
            return rectifyMap((Map<?,?>)object, terminalTypes, elementPrecursors);
        }

        return rectifyScalarCollection(object, terminalTypes, elementPrecursors);
    }

    private static Object rectifyArray(final Object object,
                                       final Set<Class<?>> terminalTypes,
                                       final Set<Object> precursors) throws Exception {
        final List<Object> list = new ArrayList<>();

        for (int n=0; n<Array.getLength(object); ++n) {
            final Object hierarchy = generateElementHierarchy(Array.get(object, n), terminalTypes, precursors);
            list.add(hierarchy);
        }

        return list;
    }

    private static Object rectifyScalarCollection(final Object object,
                                                  final Set<Class<?>> terminalTypes,
                                                  final Set<Object> precursors) throws Exception {
        final List<Object> list = new ArrayList<>();

        for (final Object element : ((Collection<?>) object)) {
            final Object hierarchy = generateElementHierarchy(element, terminalTypes, precursors);
            list.add(hierarchy);
        }

        return list;
    }

    private static Object rectifyMap(final Map<?,?> object,
                                     final Set<Class<?>> terminalTypes,
                                     final Set<Object> precursors) throws Exception {
        final Map<Object, Object> map = new LinkedHashMap<>();

        for (final Map.Entry<?,?> entry : object.entrySet()) {
            final Object key = entry.getKey();

            if (key == null) {
                continue;
            }

            final Object keyHierarchy = typeReallyIsEnum(key.getClass()) ? key : generateHierarchy(key, terminalTypes, precursors, false);
            final Object value = entry.getValue();
            final Object valueHierarchy = generateElementHierarchy(value, terminalTypes, precursors);
            map.put(keyHierarchy, valueHierarchy);
        }

        return map;
    }

    private static Object rectifySet(final Set<?> object,
                                     final Set<Class<?>> terminalTypes,
                                     final Set<Object> precursors) throws Exception {
        if (object.isEmpty()) {
            return Collections.emptySet();
        }

        final Set<Object> orderedEntries;
        if (object.iterator().next() instanceof Comparable) {
            orderedEntries = new TreeSet<>(object);
        } else {
            orderedEntries = new LinkedHashSet<>(object);
        }

        final Set<Object> set = new LinkedHashSet<>();

        for (final Object entry : orderedEntries) {
            if (entry == null) {
                continue;
            }

            final Object entryHierarchy = generateElementHierarchy(entry, terminalTypes, precursors);
            set.add(entryHierarchy);
        }

        return set;
    }

    private static Object generateElementHierarchy(final Object element,
                                                   final Set<Class<?>> terminalTypes,
                                                   final Set<Object> precursors) throws Exception {
        if (element == null) {
            return null;
        }

        final Object hierarchy = generateHierarchy(element, terminalTypes, precursors, false);
        final Class<?> elementType = element.getClass();

        if (typeReallyIsEnum(elementType)) {
            return Collections.singletonMap(elementType.getName(), hierarchy);
        }

        final String typeName = rootTypeName(elementType);

        if (hierarchy == element) {
            return typeName + ' ' + element;
        }

        return Collections.singletonMap(typeName + '.' + element, hierarchy);
    }

    private static String prettyJsonString(final Object object) {
        return PRETTY_GSON.toJson(object);
    }
}
