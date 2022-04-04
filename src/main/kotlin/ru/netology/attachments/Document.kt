package ru.netology.attachments
import ru.netology.*

data class Document (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var date: String = "none"
)