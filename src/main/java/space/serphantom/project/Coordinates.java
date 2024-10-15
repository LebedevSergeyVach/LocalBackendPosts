package space.serphantom.project;

public class Coordinates {
    private double lat;
    private double lon;

    public Coordinates(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coordinates:{ lat: " + this.lat + ", lon: " + this.lon + " }";
    }
}
