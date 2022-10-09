package com.icosahedron.core

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FILE,
    AnnotationTarget.CLASS,
    AnnotationTarget.TYPE,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY
)
annotation class ExcludeFromJacocoGeneratedReport 