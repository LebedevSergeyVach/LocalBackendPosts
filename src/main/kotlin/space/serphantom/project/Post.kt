package space.serphantom.project

import java.util.*

@JvmRecord
data class Post(
    @JvmField val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String,
    val authorAvatar: String,
    val content: String,
    val published: String,
    val link: String,
    val mentionedMention: Boolean,
    val likedByMe: Boolean,
    val coords: Coordinates?,
    val attachment: Attachment?,
    val likeOwnerIds: List<Long?>,
    val mentionIds: List<Long?>,
    val users: Map<Long?, UserPreview?>
) {
    fun newBuilder(): Builder {
        return Builder()
            .setId(id)
            .setAuthorId(authorId)
            .setAuthor(author)
            .setAuthorJob(authorJob)
            .setAuthorAvatar(authorAvatar)
            .setContent(content)
            .setPublished(published)
            .setLink(link)
            .setMentionedMention(mentionedMention)
            .setLikedByMe(likedByMe)
            .setCoords(coords)
            .setAttachment(attachment)
            .setLikeOwnerIds(likeOwnerIds)
            .setMentionIds(mentionIds)
            .setUsers(users)
    }

    class Builder {
        private var id = 0L
        private var authorId = 0L
        private var author = ""
        private var authorJob = ""
        private var authorAvatar = ""
        private var content = ""
        private var published = ""
        private var link = ""
        private var mentionedMention = false
        private var likedByMe = false
        private var coords: Coordinates? = null
        private var attachment: Attachment? = null
        private var likeOwnerIds: List<Long?> = emptyList<Long>()
        private var mentionIds: List<Long?> = emptyList<Long>()
        private var users: Map<Long?, UserPreview?> = emptyMap<Long?, UserPreview>()

        fun setId(id: Long): Builder {
            this.id = id
            return this
        }

        fun setAuthorId(authorId: Long): Builder {
            this.authorId = authorId
            return this
        }

        fun setAuthor(author: String): Builder {
            this.author = author
            return this
        }

        fun setAuthorJob(authorJob: String): Builder {
            this.authorJob = authorJob
            return this
        }

        fun setAuthorAvatar(authorAvatar: String): Builder {
            this.authorAvatar = authorAvatar
            return this
        }

        fun setContent(content: String): Builder {
            this.content = content
            return this
        }

        fun setPublished(published: String): Builder {
            this.published = published
            return this
        }

        fun setLink(link: String): Builder {
            this.link = link
            return this
        }

        fun setMentionedMention(mentionedMention: Boolean): Builder {
            this.mentionedMention = mentionedMention
            return this
        }

        fun setLikedByMe(likedByMe: Boolean): Builder {
            this.likedByMe = likedByMe
            return this
        }

        fun setCoords(coords: Coordinates?): Builder {
            this.coords = coords
            return this
        }

        fun setAttachment(attachment: Attachment?): Builder {
            this.attachment = attachment
            return this
        }

        fun setLikeOwnerIds(likeOwnerIds: List<Long?>): Builder {
            this.likeOwnerIds = likeOwnerIds
            return this
        }

        val likes: Int
            get() = likeOwnerIds.size

        fun setMentionIds(mentionIds: List<Long?>): Builder {
            this.mentionIds = mentionIds
            return this
        }

        fun setUsers(users: Map<Long?, UserPreview?>): Builder {
            this.users = users
            return this
        }

        fun build(): Post {
            return Post(
                id,
                authorId,
                author,
                authorJob,
                authorAvatar,
                content,
                published,
                link,
                mentionedMention,
                likedByMe,
                coords,
                attachment,
                Collections.unmodifiableList(likeOwnerIds),
                Collections.unmodifiableList(mentionIds),
                Collections.unmodifiableMap(users)
            )
        }
    }
}
