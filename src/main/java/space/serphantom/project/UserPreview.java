package space.serphantom.project;

import org.jetbrains.annotations.Nullable;

public record UserPreview(
        long id,
        @Nullable
        String avatar) {
}
