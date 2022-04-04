package ru.netology

import org.junit.Test

import org.junit.Assert.*
import ru.netology.attachments.*
import ru.netology.errors.PostNotFoundException
import ru.netology.fields.Comment

class WallServiceTest {

    @Test
    fun addTest() {
        val actualExpected = 1

        val post = Post(
                id = 1, ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
        )

        assertEquals(post.id, actualExpected)
    }

    @Test
    fun updateTestTrue() {
        val result = WallService
            result.add(
            Post(
                id = 101, ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = null,
                reposts = null, views = null, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        result.add(
            Post(
                ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = null,
                reposts = null, views = null, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        val resultUpdate = Post(
                id = 1, ownerId = 222, fromId = 44, createdBy = 117, date = 13456789,
                text = "text1", replyOwnerId = 7777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = null,
                reposts = null, views = null, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 1234,
                copyHistory = "121", canPin = false, canDelete = false, canEdit = false, isPinned = false,
                markedAsAds = false, ifFavorite = false, donut = "donut1", postponedId = 1234, attachments = null
        )
        val finishResult = result.update(resultUpdate)
        assertTrue(finishResult)
    }

    @Test
    fun updateTestFalse() {
        val result = WallService
        result.add(
            Post(
                ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        result.add(
            Post(
                ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        val resultUpdate = Post(
            id = 12, ownerId = 222, fromId = 44, createdBy = 117, date = 13456789,
            text = "text1", replyOwnerId = 7777, replyPostId = 15, friendsOnly = true,
            comments = "comments", copyright = "copyright", likes = 222,
            reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Саранск", signerId = 1234,
            copyHistory = "121", canPin = false, canDelete = false, canEdit = false, isPinned = false,
            markedAsAds = false, ifFavorite = false, donut = "donut1", postponedId = 1234, attachments = null
        )
        val finishResult = result.update(resultUpdate)
        assertFalse(finishResult)
    }

    @Test
    fun createCommentTest() {
        val result = WallService
        val actualExpected = 0
        result.add(
            Post(
                id = 1, ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                postSource = "sms", geo = "Саранск", copyHistory = "121", attachments = null,
                reposts = 44, views = 1717, postType = "reply", signerId = 123,
                canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123
            )
        )

        val comment = Comment(
            ownerId = 22, postId = 0, message = "И тебя вылечат...и меня вылечат!",
            fromGroup = 33, guide = 1
        )

        val finishResult = result.createComment(comment)
        assertEquals(finishResult.postId, actualExpected)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentExceptionTest() {
        val result = WallService
        val actualExpected = 1
        result.add(
            Post(
                id = 1, ownerId = 22, fromId = 4, createdBy = 17, date = 123456789,
                text = "text", replyOwnerId = 777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                postSource = "sms", geo = "Саранск", copyHistory = "121", attachments = null,
                reposts = 44, views = 1717, postType = "reply", signerId = 123,
                canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123
            )
        )

        val comment = Comment(
            ownerId = 22, postId = 0, message = "И тебя вылечат...и меня вылечат!",
            fromGroup = 33, guide = 1
        )

        val finishResult = result.createComment(comment)
        assertEquals(finishResult.postId, actualExpected)
    }

}