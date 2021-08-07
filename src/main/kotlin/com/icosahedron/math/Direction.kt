package com.icosahedron.math

enum class Direction {
    W {
        override fun count(tetray: Tetray) = tetray.w
        override fun increment(tetray: Tetray) = Tetray(tetray.w.increment(), tetray.x, tetray.y, tetray.z)
      },

    X {
        override fun count(tetray: Tetray) = tetray.x
        override fun increment(tetray: Tetray) = Tetray(tetray.w, tetray.x.increment(), tetray.y, tetray.z)
      },

    Y {
        override fun count(tetray: Tetray) = tetray.y
        override fun increment(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y.increment(), tetray.z)
      },

    Z {
        override fun count(tetray: Tetray) = tetray.z
        override fun increment(tetray: Tetray) = Tetray(tetray.w, tetray.x, tetray.y, tetray.z.increment())
    };

    abstract fun count(tetray: Tetray): Count
    abstract fun increment(tetray: Tetray): Tetray
}