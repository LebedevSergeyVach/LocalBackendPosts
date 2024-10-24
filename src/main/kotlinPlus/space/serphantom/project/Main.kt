package com.eltex


fun main() {
    val service = WallServiceImpl()

    val first = service.addPost("First").apply {
        service.setAuthor(id,"First author")
    }

    val second = service.addPost("Second").apply {
        service.setAuthor(id, "PiskaGruz author")
    }


    service.like(first.id, 1)
    service.like(first.id, 2)
    service.like(first.id, 3)

    service.like(second.id, 4)

    println(service.getAuthorsCount())
}
