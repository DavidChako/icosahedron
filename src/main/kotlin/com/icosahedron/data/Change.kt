package com.icosahedron.data

data class Change(val target: Target, val value: Value?, val since: ULong = ULong.MIN_VALUE, val until: ULong = ULong.MAX_VALUE)
