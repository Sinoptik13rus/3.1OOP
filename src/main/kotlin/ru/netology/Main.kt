package ru.netology

import ru.netology.attachments.*

fun main() {

    val archiveAttachments = ArchiveAttachments(archive = Archive(17, 17, "abc", 171))
    val audioAttachments = AudioAttachments(audio = Audio(18, 18, "abcd", "1"))
    val documentAttachments = DocumentAttachments(document = Document(19, 19, "doc", "2022"))
    val photoAttachments = PhotoAttachments(photo = Photo(17, 17, "abc", "1920"))
    val videoAttachments = VideoAttachments(video = Video(1, 12, "a", 123))

    var post = Post(
        id = 555,
        ownerId = 1,
        fromId = 32,
        createdBy = 7777,
        date = 153256151,
        text = "Пора всем спать!",
        replyOwnerId = 1717,
        replyPostId = 3,
        friendsOnly = false,
        comments = "Так точно",
        copyright = "Нетология.ру",
        likes = 22,
        reposts = 10,
        views = 1300,
        postType = "reply",
        postSource = "sms",
        attachments = null,
        geo = "Саранск",
        signerId = 0,
        copyHistory = "121",
        canPin = true,
        canDelete = false,
        canEdit = false,
        isPinned = true,
        markedAsAds = false,
        ifFavorite = true,
        donut = "no donut",
        postponedId = 0
    )
    WallService.add(post)
}

