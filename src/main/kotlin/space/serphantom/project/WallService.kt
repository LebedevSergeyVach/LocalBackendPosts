package space.serphantom.project

class WallService {
    private var nextId = 1L
    var posts: List<Post> = emptyList()
        private set

    fun like(postId: Long, likerId: Long?) {
        val post = getPostById(postId) ?: return

        val mutableLkeOwners = ArrayList(post.likeOwnerIds)

        if (!mutableLkeOwners.remove(likerId)) {
            mutableLkeOwners.add(likerId)
        }

        val allUsers = HashSet<Long?>(post.mentionIds.size + mutableLkeOwners.size)
        allUsers.addAll(post.mentionIds)
        allUsers.addAll(mutableLkeOwners)

        val users = createUsers(allUsers)

        val updatedPost = post.newBuilder()
            .setLikeOwnerIds(mutableLkeOwners)
            .setUsers(users)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun mention(postId: Long, userId: Long?) {
        val post = getPostById(postId) ?: return

        val mutableMentionIds = ArrayList(post.mentionIds)

        if (!mutableMentionIds.remove(userId)) {
            mutableMentionIds.add(userId)
        }

        val allUsers = HashSet<Long?>(post.likeOwnerIds.size + mutableMentionIds.size)
        allUsers.addAll(post.likeOwnerIds)
        allUsers.addAll(mutableMentionIds)

        val users = createUsers(allUsers)

        val updatedPost = post.newBuilder()
            .setMentionIds(mutableMentionIds)
            .setUsers(users)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }


    fun setId(postId: Long, id: Long) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setId(id)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setAuthorId(postId: Long, authorId: Long) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setAuthorId(authorId)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setAuthor(postId: Long, author: String?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setAuthor(author!!)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setAuthorJob(postId: Long, authorJob: String?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setAuthorJob(authorJob!!)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setAuthorAvatar(postId: Long, authorAvatar: String?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setAuthorAvatar(authorAvatar!!)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setContent(postId: Long, content: String?) {
        val post = getPostById(postId)
            ?: //            throw new IllegalArgumentException("Post with id " + postId + " not found");
            return

        val updatedPost = post.newBuilder()
            .setContent(content!!)
            .build()

        posts = updatedPostById(postId, updatedPost)

        /*
        for (int i = 0; i < posts.size(); i++) {
            final var iterated = posts.get(i);

            if (iterated.id() == postId) {
                final var newPost = iterated.newBuilder()
                        .setContent(content)
                        .build();

                final var updatedPosts = new ArrayList<>(posts);
                updatedPosts.set(i, newPost);
                posts = updatedPosts;

                break;
            }
        }
        */
    }

    fun setPublished(postId: Long, published: String?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setPublished(published!!)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setLink(postId: Long, link: String?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setLink(link!!)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setMentionedMention(postId: Long, mentionedMention: Boolean) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setMentionedMention(mentionedMention)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setLikedByMe(postId: Long, likedByMe: Boolean) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setLikedByMe(likedByMe)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun addPost(content: String?): Post {
        val newPosts = ArrayList(posts)

        val post = Post.Builder()
            .setId(nextId++)
            .setContent(content!!)
            .build()

        newPosts.add(post)

        posts = newPosts

        return post
    }

    fun addPost(content: String?, author: String?): Post {
        val newPosts = ArrayList(posts)

        val post = Post.Builder()
            .setId(nextId++)
            .setContent(content!!)
            .setAuthor(author!!)
            .build()

        newPosts.add(post)

        posts = newPosts

        return post
    }

    fun addPost(content: String?, author: String?, published: String?): Post {
        val newPosts = ArrayList(posts)

        val post = Post.Builder()
            .setId(nextId++)
            .setContent(content!!)
            .setAuthor(author!!)
            .setPublished(published!!)
            .build()

        newPosts.add(post)

        posts = newPosts

        return post
    }

    fun addPost(content: String?, author: String?, published: String?, authorJob: String?): Post {
        val newPosts = ArrayList(posts)

        val post = Post.Builder()
            .setId(nextId++)
            .setContent(content!!)
            .setAuthor(author!!)
            .setPublished(published!!)
            .setAuthorJob(authorJob!!)
            .build()

        newPosts.add(post)

        posts = newPosts

        return post
    }

    private fun getPostById(postId: Long): Post? {
        for (post in posts) {
            if (post.id == postId) {
                return post
            }
        }

        return null
    }

    fun setAttachment(postId: Long, attachment: Attachment?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setAttachment(attachment)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    fun setCoords(postId: Long, coords: Coordinates?) {
        val post = getPostById(postId) ?: return

        val updatedPost = post.newBuilder()
            .setCoords(coords)
            .build()

        posts = updatedPostById(postId, updatedPost)
    }

    private fun updatedPostById(postId: Long, updatedPost: Post): ArrayList<Post> {
        val updatedList = ArrayList<Post>(posts.size)

        for (currentPost in posts) {
            if (currentPost.id == postId) {
                updatedList.add(updatedPost)
            } else {
                updatedList.add(currentPost)
            }
        }

        return updatedList
    }

    companion object {
        private fun createUsers(allUsers: HashSet<Long?>): HashMap<Long?, UserPreview?> {
            val users = HashMap<Long?, UserPreview?>(allUsers.size)

            for (userId in allUsers) {
                users[userId] = userId?.let { UserPreview(it, null) }
            }
            return users
        }
    }
}
