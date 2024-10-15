package space.serphantom.project;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Time time = new Time();
        String currentTimeAndDate = time.getTimeData();

        Random random = new Random();

        // Test Service Post
        System.out.println("Test Service Post:");

        WallService service = new WallService();

        final var oneTestPostService = service.addPost(
                "Wake the fuck up, Samurai. We have a city to burn.",
                "John Silverhand",
                currentTimeAndDate,
                "Rocker"
        );

        for (int i = 0; i < 10; i++) {
            long randomNumberLikes = random.nextInt(10000);
            service.like(oneTestPostService.id(), randomNumberLikes);
        }

        for (int i = 0; i < 10; i++) {
            long randomNumberMention = random.nextInt(10000);
            service.mention(oneTestPostService.id(), randomNumberMention);
        }

        service.setAuthorAvatar(
                oneTestPostService.id(),
                "https://images.hdqwalls.com/download/cyberpunk-2077-johnny-silverhand-fanart-4k-4j-3840x2400.jpg"
        );

        service.setLink(
                oneTestPostService.id(),
                "https://cyberpunk.fandom.com/ru/wiki/Джонни_Сильверхенд"
        );

        long randomNumberAuthorId = random.nextInt(1000000);
        service.setAuthorId(oneTestPostService.id(), randomNumberAuthorId);

        AttachmentType attachmentType = AttachmentType.IMAGE;
        Attachment attachment = new Attachment("https://lms.academy.eltex-co.ru", attachmentType);

        service.setAttachment(oneTestPostService.id(), attachment);

        double randomNumberCoordsX = random.nextDouble(1000);
        double randomNumberCoordsY = random.nextDouble(1000);
        Coordinates coords = new Coordinates(randomNumberCoordsX, randomNumberCoordsY);

        service.setCoords(oneTestPostService.id(), coords);

        service.setLikedByMe(oneTestPostService.id(), true);
        service.setMentionedMention(oneTestPostService.id(), true);

        System.out.println(service.getPosts());

        // Test Service User
        System.out.println("\nTest Service User:");

        UserService Users = new UserService();

        User user1 = new User.Builder()
                .setLogin("user1")
                .setName("User One")
                .setAvatar("avatar1.jpg")
                .build();
        Users.save(user1);

        User user2 = new User.Builder()
                .setLogin("user2")
                .setName("User Two")
                .setAvatar("avatar2.jpg")
                .build();
        Users.save(user2);

        List<User> allUsers = Users.getAll();
        System.out.println("All users: " + allUsers);

        User updatedUser = user1.newBuilder()
                .setLogin("user1_updated")
                .setName("User One Updated")
                .setAvatar("avatar1_updated.jpg")
                .build();
        Users.save(updatedUser);

        try {
            User userById = Users.getById(1);
            System.out.println("User by id 1: " + userById);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        Users.removeById(2);

        allUsers = Users.getAll();
        System.out.println("All users after removal: " + allUsers);

        // Попытка получить удаленного пользователя
        try {
            User deletedUser = Users.getById(2);
            System.out.println("User by id 2: " + deletedUser);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
