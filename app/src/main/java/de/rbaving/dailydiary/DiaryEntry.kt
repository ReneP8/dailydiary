package de.rbaving.dailydiary

import java.time.LocalDateTime

data class DiaryEntry(
        val date: LocalDateTime,
        val rating: Int,
        val content: String

)
