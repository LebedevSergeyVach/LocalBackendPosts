package space.serphantom.project

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Time {
    val timeData: String
        get() {
            val now = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")

            return now.format(formatter)
        }
}
