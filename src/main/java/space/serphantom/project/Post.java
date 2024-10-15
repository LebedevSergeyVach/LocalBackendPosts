package space.serphantom.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public record Post(
        long id,
        long authorId,
        @NotNull
        String author,
        @NotNull
        String authorJob,
        @NotNull
        String authorAvatar,
        @NotNull
        String content,
        @NotNull
        String published,
        @NotNull
        String link,
        boolean mentionedMention,
        boolean likedByMe,
        @Nullable
        Coordinates coords,
        @Nullable
        Attachment attachment,
        List<Long> likeOwnerIds,
        List<Long> mentionIds,
        Map<Long, UserPreview> users
) {


    @Nullable
    public Coordinates getCoords() {
        return coords;
    }

    @Nullable
    public Attachment getAttachment() {
        return attachment;
    }

    public Builder newBuilder() {
        return new Builder()
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
                .setUsers(users);
    }

    public static class Builder {
        private long id = 0L;
        private long authorId = 0L;
        @NotNull
        private String author = "";
        @NotNull
        private String authorJob = "";
        @NotNull
        private String authorAvatar = "";
        @NotNull
        private String content = "";
        @NotNull
        private String published = "";
        @NotNull
        private String link = "";
        private boolean mentionedMention = false;
        private boolean likedByMe = false;
        @Nullable
        private Coordinates coords = null;
        @Nullable
        private Attachment attachment = null;
        @NotNull
        private List<Long> likeOwnerIds = Collections.emptyList();
        @NotNull
        private List<Long> mentionIds = Collections.emptyList();
        @NotNull
        private Map<Long, UserPreview> users = Collections.emptyMap();

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthor(@NotNull String author) {
            this.author = author;
            return this;
        }

        public Builder setAuthorJob(@NotNull String authorJob) {
            this.authorJob = authorJob;
            return this;
        }

        public Builder setAuthorAvatar(@NotNull String authorAvatar) {
            this.authorAvatar = authorAvatar;
            return this;
        }

        public Builder setContent(@NotNull String content) {
            this.content = content;
            return this;
        }

        public Builder setPublished(@NotNull String published) {
            this.published = published;
            return this;
        }

        public Builder setLink(@NotNull String link) {
            this.link = link;
            return this;
        }

        public Builder setMentionedMention(boolean mentionedMention) {
            this.mentionedMention = mentionedMention;
            return this;
        }

        public Builder setLikedByMe(boolean likedByMe) {
            this.likedByMe = likedByMe;
            return this;
        }

        public Builder setCoords(@Nullable Coordinates coords) {
            this.coords = coords;
            return this;
        }

        public Builder setAttachment(@Nullable Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder setLikeOwnerIds(@NotNull List<Long> likeOwnerIds) {
            this.likeOwnerIds = likeOwnerIds;
            return this;
        }

        public int getLikes() {
            return likeOwnerIds.size();
        }

        public Builder setMentionIds(@NotNull List<Long> mentionIds) {
            this.mentionIds = mentionIds;
            return this;
        }

        public Builder setUsers(@NotNull Map<Long, UserPreview> users) {
            this.users = users;
            return this;
        }

        public Post build() {
            return new Post(
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
            );
        }
    }
}
