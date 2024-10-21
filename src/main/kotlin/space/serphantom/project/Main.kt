package space.serphantom.project

import java.util.*

fun main() {
    val time = Time()
    val currentTimeAndDate = time.timeData

    val random = Random()

    // Test Service Post
    println("Test Service Post:")

    val service = WallService()

    val oneTestPostService = service.addPost(
        "Wake the fuck up, Samurai. We have a city to burn.",
        "John Silverhand",
        currentTimeAndDate,
        "Rocker"
    )

    for (i in 0..9) {
        val randomNumberLikes = random.nextInt(10000).toLong()
        service.like(oneTestPostService.id, randomNumberLikes)
    }

    for (i in 0..9) {
        val randomNumberMention = random.nextInt(10000).toLong()
        service.mention(oneTestPostService.id, randomNumberMention)
    }

    service.setAuthorAvatar(
        oneTestPostService.id,
        "https://images.hdqwalls.com/download/cyberpunk-2077-johnny-silverhand-fanart-4k-4j-3840x2400.jpg"
    )

    service.setLink(
        oneTestPostService.id,
        "https://cyberpunk.fandom.com/ru/wiki/Джонни_Сильверхенд"
    )

    val randomNumberAuthorId = random.nextInt(1000000).toLong()
    service.setAuthorId(oneTestPostService.id, randomNumberAuthorId)

    val attachmentType = AttachmentType.IMAGE
    val attachment = Attachment("https://lms.academy.eltex-co.ru", attachmentType)

    service.setAttachment(oneTestPostService.id, attachment)

    val randomNumberCoordsX = random.nextDouble(1000.0)
    val randomNumberCoordsY = random.nextDouble(1000.0)
    val coords = Coordinates(randomNumberCoordsX, randomNumberCoordsY)

    service.setCoords(oneTestPostService.id, coords)

    service.setLikedByMe(oneTestPostService.id, true)
    service.setMentionedMention(oneTestPostService.id, true)

    println(service.posts)

    // Test Service User
    println("\nTest Service User:")

    val Users = UserService()

    val user1 = User.Builder()
        .setLogin("user1")
        .setName("User One")
        .setAvatar("avatar1.jpg")
        .build()
    Users.save(user1)

    val user2 = User.Builder()
        .setLogin("user2")
        .setName("User Two")
        .setAvatar("avatar2.jpg")
        .build()
    Users.save(user2)

    var allUsers = Users.all
    println("All users: $allUsers")

    val updatedUser = user1.newBuilder()
        .setLogin("user1_updated")
        .setName("User One Updated")
        .setAvatar("avatar1_updated.jpg")
        .build()
    Users.save(updatedUser)

    try {
        val userById = Users.getById(1)
        println("User by id 1: $userById")
    } catch (e: NotFoundException) {
        println(e.message)
    }

    Users.removeById(2)

    allUsers = Users.all
    println("All users after removal: $allUsers")

    try {
        val deletedUser = Users.getById(2)
        println("User by id 2: $deletedUser")
    } catch (e: NotFoundException) {
        println(e.message)
    }
}

