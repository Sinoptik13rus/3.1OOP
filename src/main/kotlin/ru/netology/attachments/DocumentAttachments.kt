package ru.netology.attachments

data class DocumentAttachments(val document: Document?, override val type: String = "document"): Attachment