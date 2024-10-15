package space.serphantom.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class WallService {
    private Long nextId = 1L;
    private List<Post> posts = Collections.emptyList();

    public List<Post> getPosts() {
        return posts;
    }

    public void like(Long postId, Long likerId) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        ArrayList<Long> mutableLkeOwners = new ArrayList<>(post.likeOwnerIds());

        if (!mutableLkeOwners.remove(likerId)) {
            mutableLkeOwners.add(likerId);
        }

        final var allUsers = new HashSet<Long>(post.mentionIds().size() + mutableLkeOwners.size());
        allUsers.addAll(post.mentionIds());
        allUsers.addAll(mutableLkeOwners);

        final var users = createUsers(allUsers);

        final var updatedPost = post.newBuilder()
                .setLikeOwnerIds(mutableLkeOwners)
                .setUsers(users)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void mention(Long postId, Long userId) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        ArrayList<Long> mutableMentionIds = new ArrayList<>(post.mentionIds());

        if (!mutableMentionIds.remove(userId)) {
            mutableMentionIds.add(userId);
        }

        final var allUsers = new HashSet<Long>(post.likeOwnerIds().size() + mutableMentionIds.size());
        allUsers.addAll(post.likeOwnerIds());
        allUsers.addAll(mutableMentionIds);

        final var users = createUsers(allUsers);

        final var updatedPost = post.newBuilder()
                .setMentionIds(mutableMentionIds)
                .setUsers(users)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }


    public void setId(long postId, long id) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setId(id)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setAuthorId(long postId, long authorId) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setAuthorId(authorId)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setAuthor(long postId, String author) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setAuthor(author)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setAuthorJob(long postId, String authorJob) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setAuthorJob(authorJob)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setAuthorAvatar(long postId, String authorAvatar) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setAuthorAvatar(authorAvatar)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setContent(Long postId, String content) {
        final var post = getPostById(postId);

        if (post == null) {
//            throw new IllegalArgumentException("Post with id " + postId + " not found");
            return;
        }

        final var updatedPost = post.newBuilder()
                .setContent(content)
                .build();

        posts = updatedPostById(postId, updatedPost);

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

    public void setPublished(long postId, String published) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setPublished(published)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setLink(long postId, String link) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setLink(link)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setMentionedMention(long postId, boolean mentionedMention) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setMentionedMention(mentionedMention)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setLikedByMe(long postId, boolean likedByMe) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setLikedByMe(likedByMe)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public Post addPost(String content) {
        final var newPosts = new ArrayList<>(posts);

        Post post = new Post.Builder()
                .setId(nextId++)
                .setContent(content)
                .build();

        newPosts.add(post);

        posts = newPosts;

        return post;
    }

    public Post addPost(String content, String author) {
        final var newPosts = new ArrayList<>(posts);

        Post post = new Post.Builder()
                .setId(nextId++)
                .setContent(content)
                .setAuthor(author)
                .build();

        newPosts.add(post);

        posts = newPosts;

        return post;
    }

    public Post addPost(String content, String author, String published) {
        final var newPosts = new ArrayList<>(posts);

        Post post = new Post.Builder()
                .setId(nextId++)
                .setContent(content)
                .setAuthor(author)
                .setPublished(published)
                .build();

        newPosts.add(post);

        posts = newPosts;

        return post;
    }

    public Post addPost(String content, String author, String published, String authorJob) {
        final var newPosts = new ArrayList<>(posts);

        Post post = new Post.Builder()
                .setId(nextId++)
                .setContent(content)
                .setAuthor(author)
                .setPublished(published)
                .setAuthorJob(authorJob)
                .build();

        newPosts.add(post);

        posts = newPosts;

        return post;
    }

    @Nullable
    public Post getPostById(long postId) {
        for (final Post post : posts) {
            if (post.id() == postId) {
                return post;
            }
        }

        return null;
    }

    public void setAttachment(long postId, Attachment attachment) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setAttachment(attachment)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    public void setCoords(long postId, Coordinates coords) {
        final var post = getPostById(postId);

        if (post == null) {
            return;
        }

        final var updatedPost = post.newBuilder()
                .setCoords(coords)
                .build();

        posts = updatedPostById(postId, updatedPost);
    }

    private @NotNull ArrayList<Post> updatedPostById(long postId, Post updatedPost) {
        final var updatedList = new ArrayList<Post>(posts.size());

        for (final Post currentPost : posts) {
            if (currentPost.id() == postId) {
                updatedList.add(updatedPost);
            } else {
                updatedList.add(currentPost);
            }
        }

        return updatedList;
    }

    private static @NotNull HashMap<Long, UserPreview> createUsers(HashSet<Long> allUsers) {
        final var users = new HashMap<Long, UserPreview>(allUsers.size());

        for (long userId : allUsers) {
            users.put(userId, new UserPreview(userId, null));
        }
        return users;
    }
}
