package space.serphantom.project;

import org.jetbrains.annotations.NotNull;

public class Attachment {
    @NotNull
    private String url;
    @NotNull
    private AttachmentType  type;

    public Attachment(@NotNull String url, @NotNull AttachmentType type) {
        this.url = url;
        this.type = type;
    }

    public @NotNull String getUrl() {
        return url;
    }

    public void setUrl(@NotNull String url) {
        this.url = url;
    }

    public @NotNull AttachmentType getType() {
        return type;
    }

    public void setType(@NotNull AttachmentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Attachment:{ url: " + this.url + ", type: " + this.type + " }";
    }
}
