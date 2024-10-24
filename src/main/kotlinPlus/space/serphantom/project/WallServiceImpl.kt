package com.eltex

import java.time.Instant

class WallServiceImpl : WallService {
    private var id: Long = 1L
    private val posts = mutableListOf<Post>()

    override fun getLatestPosts(count: Int): List<Post> =
        posts.sortedByDescending { post -> post.id }.take(count)

    override fun getBeforePosts(count: Int, offset: Int): List<Post> =
        posts.sortedByDescending { post -> post.id }.drop(offset).take(count)

    override fun getAllLikes(): Int = posts.sumOf { post -> post.likeOwnerIds.size }

    override fun getPostsTexts(from: Instant, to: Instant): List<String> =
        posts.asSequence()
            .filter { post -> post.published > from && post.published < to }
            .map { post -> post.content }
            .toList()

    override fun getLikestPost(): Post? = posts.maxByOrNull { post -> post.likeOwnerIds.size }

    // distinct() -> toSet().toList()
    override fun getAllAuthors(): List<String> = posts.asSequence().map { post -> post.author }.distinct().toList()

    override fun getAuthorsCount(): Int = posts.asSequence().map { post -> post.author }.toSet().count()

    override fun addPost(content: String): Post {
        val post = Post(id = id++, content = content)
        posts.add(post)

        return post
    }

    override fun getPostById(postId: Long): Post? = posts.find { post -> post.id == postId }

    override fun updatePost(updated: Post) {
        updatePostById(updated.id) { updated }
    }

    override fun like(postId: Long, userId: Long) {
        updatePostById(postId) { post ->
            val mutableLikeOwner = post.likeOwnerIds.toMutableSet()

            if (!mutableLikeOwner.add(userId)) {
                mutableLikeOwner.remove(userId)
            }

            post.copy(likeOwnerIds = mutableLikeOwner)
        }
    }

    override fun setContent(postId: Long, content: String) {
        updatePostById(postId) { post ->
            post.copy(content = content)
        }
    }

    override fun setAuthor(postId: Long, author: String) {
        updatePostById(postId) { post ->
            post.copy(author = author)
        }
    }

    override fun getPosts(): List<Post> = posts.toList()

    /**
     * Обновление данный поста
     */
    private fun updatePostById(postId: Long, update: (Post) -> Post) {
        val indexOfPost = posts.indexOfFirst { post ->
            post.id == postId
        }

        if (indexOfPost < 0) {
            return
        }

        posts[indexOfPost] = update(posts[indexOfPost])
    }
}
