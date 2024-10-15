package space.serphantom.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private Long nextId = 1L;
    private List<User> users = Collections.emptyList();

    public void save(final User user) {
        if (user.id() == 0) {
            User newUser = user.newBuilder().setId(nextId++).build();

            users = new ArrayList<>(users);
            users.add(newUser);
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).id() == user.id()) {
                    users.set(i, user);

                    break;
                }
            }
        }
    }

    public void removeById(final long userId) {
        users = new ArrayList<>(users);
        users.removeIf(user -> user.id() == userId);
    }

    // Метод для получения пользователя по id
    public User getById(final long userId) {
        for (User user : users) {
            if (user.id() == userId) {
                return user;
            }
        }

        // The user by id numbers was not found
        throw new NotFoundException(
                "NotFoundException: " + "The User by id numbers: " + userId + " was not found."
        );
    }

    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }
}
