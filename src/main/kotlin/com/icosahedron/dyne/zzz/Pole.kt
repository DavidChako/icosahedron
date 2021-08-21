package com.icosahedron.dyne.zzz

enum class Pole {
    A {
//        override fun project(tetray: TetrayVector) = tetray.w
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z)
      },

    B {
//        override fun project(tetray: TetrayVector) = tetray.x
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z)
      },

    C {
//        override fun project(tetray: TetrayVector) = tetray.y
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z)
      },

    D {
//        override fun project(tetray: TetrayVector) = tetray.z
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
      },

    E {
//        override fun project(tetray: TetrayVector) = tetray.z
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
    },

    F {
//        override fun project(tetray: TetrayVector) = tetray.z
//        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
    },
    ;

//    abstract fun project(tetray: TetrayVector): Count
//    abstract fun move(tetray: TetrayVector): TetrayVector
}
