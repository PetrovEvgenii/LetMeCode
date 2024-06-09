package com.example.lmcxml.presentation.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:MM:SS")

fun formatDateTime(date: ZonedDateTime?): String = date!!.format(formatter)