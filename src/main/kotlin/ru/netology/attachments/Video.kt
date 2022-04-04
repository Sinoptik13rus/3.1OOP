package ru.netology.attachments
import ru.netology.*

data class Video (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var duration: Int = 0
)