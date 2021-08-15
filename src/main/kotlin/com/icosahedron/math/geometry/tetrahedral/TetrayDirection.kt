package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Count

enum class TetrayDirection {
    W {
        override fun project(tetray: Tetray) = tetray.w
        override fun move(tetray: Tetray) = Tetray(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z)
      },

    X {
        override fun project(tetray: Tetray) = tetray.x
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z)
      },

    Y {
        override fun project(tetray: Tetray) = tetray.y
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z)
      },

    Z {
        override fun project(tetray: Tetray) = tetray.z
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
      },
    ;

    abstract fun project(tetray: Tetray): Count
    abstract fun move(tetray: Tetray): Tetray
}
