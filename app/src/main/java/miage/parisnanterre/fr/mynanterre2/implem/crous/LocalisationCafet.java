package miage.parisnanterre.fr.mynanterre2.implem.crous;

import android.location.Location;


public class LocalisationCafet {


    private int  image;
    private String nom;
    private String distance;
    private String info;
    private String plat;

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }




    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String CalculDistance(double latitudeCafet, double longitudeCafet, double latitudeUser, double longitudeUser ){

        Location locCafet = new Location("");
        locCafet.setLatitude(latitudeCafet);
        locCafet.setLongitude(longitudeCafet);

        Location locUser = new Location("");
        locUser.setLatitude(latitudeUser);
        locUser.setLongitude(longitudeUser);

        String distanceToReturn = String.format("%.0f", locCafet.distanceTo(locUser));

        return distanceToReturn;
    }
}
