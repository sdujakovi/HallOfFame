package com.example.halloffame.util

fun Double?.toStringAsFixed(fractionDigits: Int): String {
    return this?.let { String.format("%.${fractionDigits}f", this) } ?: ""
}