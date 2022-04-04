package ru.netology.fields

data class Comment(
    val ownerId: Int,
    val postId: Int,
    val message: String,
    val fromGroup: Int,
    val guide: Int?
) {



}