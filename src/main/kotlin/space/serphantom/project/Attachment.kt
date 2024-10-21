package space.serphantom.project

class Attachment(private var url: String, private var type: AttachmentType) {
    override fun toString(): String {
        return "Attachment:{ url: " + this.url + ", type: " + this.type + " }"
    }
}
