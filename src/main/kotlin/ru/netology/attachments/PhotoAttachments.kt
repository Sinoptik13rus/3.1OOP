package ru.netology.attachments

data class PhotoAttachments(val photo: Photo?, override val type: String = "photo"): Attachment