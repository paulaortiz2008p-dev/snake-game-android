package com.paulaortiz.catchthemouse

data class Mouse(
    val x: Float,
    val y: Float,
    var lifetime: Int = 200 // Milisegundos antes de desaparecer
)