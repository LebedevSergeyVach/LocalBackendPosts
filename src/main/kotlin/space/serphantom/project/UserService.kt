package space.serphantom.project

import java.util.*

class UserService {
    private var nextId: Long = 1
    private var users: MutableList<User> = Collections.emptyList()

    fun save(user: User) {
        if (user.id == 0L) {
            val newUser = user.newBuilder().setId(nextId++).build()

            users = ArrayList(users)
            users.add(newUser)
        } else {
            for (i in users.indices) {
                if (users[i].id == user.id) {
                    users[i] = user
                    break
                }
            }
        }
    }

    fun removeById(userId: Long) {
        users = ArrayList(users)
        users.removeIf { user: User -> user.id == userId }
    }

    fun getById(userId: Long): User {
        for (user in users) {
            if (user.id == userId) {
                return user
            }
        }

        // The user by id numbers was not found
        throw NotFoundException(
            "NotFoundException: The User by id numbers: $userId was not found."
        )
    }

    val all: List<User>
        get() = Collections.unmodifiableList(users)
}
