package com.athentech.srcalender

import java.util.Date

interface EventHandler {
    fun longPressed(date: Date)
    fun clicked(date: Date)
    fun dayViewClicked()
}