package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Count

enum class TetrayDirection {
    W {
        override fun project(tetray: TetrayVector) = tetray.w
        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z)
      },

    X {
        override fun project(tetray: TetrayVector) = tetray.x
        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z)
      },

    Y {
        override fun project(tetray: TetrayVector) = tetray.y
        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z)
      },

    Z {
        override fun project(tetray: TetrayVector) = tetray.z
        override fun move(tetray: TetrayVector) = TetrayVector(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
      },
    ;

    abstract fun project(tetray: TetrayVector): Count
    abstract fun move(tetray: TetrayVector): TetrayVector
}
