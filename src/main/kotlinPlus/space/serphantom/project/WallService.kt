package com.eltex

import java.time.Instant

interface WallService {
    /**
     * Получить последние сообщения
     */
    fun getLatestPosts(count: Int): List<Post>

    /**
     * Получить посты до указанного смещения
     */
    fun getBeforePosts(count: Int, offset: Int): List<Post>

    /**
     * Вернуть количество всех лайков
     */
    fun getAllLikes(): Int

    /**
     * Получить тексты всех постов за указанный период
     */
    fun getPostsTexts(from: Instant, to: Instant): List<String>

    /**
     * Вернуть самый залайканный пост
     */
    fun getLikestPost(): Post?

    /**
     * Вернуть уникальных авторов
     */
    fun getAllAuthors(): List<String>

    /**
     * Количество уникальных авторов
     */
    fun getAuthorsCount(): Int

    /**
     * Создание поста
     */
    fun addPost(content: String): Post

    /**
     * Получить пост по идентификатору
     */
    fun getPostById(postId: Long): Post?

    /**
     * Обновление поста
     */
    fun updatePost(updated: Post)

    /**
     * Поставить лайк посту
     */
    fun like(postId: Long, userId: Long)

    /**
     * Установить текст поста
     */
    fun setContent(postId: Long, content: String)

    /**
     * Установить автора поста
     */
    fun setAuthor(postId: Long, author: String)

    /**
     * Вернуть все посты
     */
    fun getPosts(): List<Post>
}
