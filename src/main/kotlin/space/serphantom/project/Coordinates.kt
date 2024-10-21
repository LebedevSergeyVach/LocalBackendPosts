package space.serphantom.project

@JvmRecord
data class Coordinates(
    val latitude: Double,
    val longitude: Double
) {
    override fun toString(): String {
        return "Coordinates:{ latitude: " + this.latitude + ", longitude: " + this.longitude + " }"
    }
}
