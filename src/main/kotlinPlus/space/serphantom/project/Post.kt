package com.eltex

import java.time.Instant

@JvmRecord
data class Post(
    val id: Long = 0,
    val authorId: Long = 0,
    val author: String = "",
    val authorJob: String = "",
    val authorAvatar: String = "",
    val content: String = "",
    val published: Instant = Instant.now(),
    val link: String = "",
    val likeOwnerIds: Set<Long> = setOf(),
    val mentionedMention: Boolean = false,
    val likedByMe: Boolean = false,

//    val coords: Coordinates? = null,
//    val attachment: Attachment? = null,
//    val likeOwnerIds: List<Long?> = emptyList(),
//    val mentionIds: List<Long?> = emptyList(),
//    val users: Map<Long?, UserPreview?> = emptyMap()
)
