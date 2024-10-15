package space.serphantom.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record User(
        long id,
        @NotNull
        String login,
        @NotNull
        String name,
        @Nullable
        String avatar
) {
    public Builder newBuilder() {
        return new Builder()
                .setId(id)
                .setLogin(login)
                .setName(name)
                .setAvatar(avatar);
    }

    public static class Builder {
        private long id = 0L;
        @NotNull
        private String login = "";
        @NotNull
        private String name = "";
        @Nullable
        private String avatar = "";

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(@NotNull String login) {
            this.login = login;
            return this;
        }

        public Builder setName(@NotNull String name) {
            this.name = name;
            return this;
        }

        public Builder setAvatar(@Nullable String avatar) {
            this.avatar = avatar;
            return this;
        }

        public User build() {
            return new User(
                    id,
                    login,
                    name,
                    avatar);
        }
    }
}
