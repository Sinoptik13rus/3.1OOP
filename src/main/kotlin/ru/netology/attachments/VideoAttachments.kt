package ru.netology.attachments

data class VideoAttachments(val video: Video?, override val type: String = "video"): Attachment