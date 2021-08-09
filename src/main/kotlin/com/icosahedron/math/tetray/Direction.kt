package com.icosahedron.math.tetray

import com.icosahedron.math.Count

enum class Direction {
    W {
        override fun coordinate(tetray: Tetray) = tetray.w
        override fun move(tetray: Tetray) = Tetray(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z)
      },

    X {
        override fun coordinate(tetray: Tetray) = tetray.x
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z)
      },

    Y {
        override fun coordinate(tetray: Tetray) = tetray.y
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z)
      },

    Z {
        override fun coordinate(tetray: Tetray) = tetray.z
        override fun move(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y, tetray.z.plusOne())
      },
    ;

    abstract fun coordinate(tetray: Tetray): Count
    abstract fun move(tetray: Tetray): Tetray
}
