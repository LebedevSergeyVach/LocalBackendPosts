package space.serphantom.project

@JvmRecord
data class User(
    @JvmField val id: Long,
    val login: String,
    val name: String,
    val avatar: String?
) {
    fun newBuilder(): Builder {
        return Builder()
            .setId(id)
            .setLogin(login)
            .setName(name)
            .setAvatar(avatar)
    }

    class Builder {
        private var id = 0L
        private var login = ""
        private var name = ""
        private var avatar: String? = ""

        fun setId(id: Long): Builder {
            this.id = id
            return this
        }

        fun setLogin(login: String): Builder {
            this.login = login
            return this
        }

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setAvatar(avatar: String?): Builder {
            this.avatar = avatar
            return this
        }

        fun build(): User {
            return User(
                id,
                login,
                name,
                avatar
            )
        }
    }
}
