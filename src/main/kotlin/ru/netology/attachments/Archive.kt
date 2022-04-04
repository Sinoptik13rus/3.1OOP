package ru.netology.attachments
import ru.netology.*

data class Archive (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var size: Int = 0
)