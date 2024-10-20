package space.serphantom.project;

public record Coordinates(
        double latitude,
        double longitude
) {

    @Override
    public String toString() {
        return "Coordinates:{ latitude: " + this.latitude + ", longitude: " + this.longitude + " }";
    }
}
