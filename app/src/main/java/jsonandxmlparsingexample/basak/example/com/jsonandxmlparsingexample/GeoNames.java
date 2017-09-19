package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

/**
 * Created by basak on 17.06.2017.
 */


public class GeoNames {

    //private int id;

    private String toponymName;

    private String name;

    private double lat;

    private double lng;

    private int geonameId;

    private String countryCode;

    private String countryName;

    private int population;

    private String fcl;

    private String fcode;

    public GeoNames(String toponymName, String name, double lat,
                    double lng, int geonameId, String countryCode,
                    String countryName, String fcl, String fcode) {
        this.toponymName = toponymName;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.geonameId = geonameId;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.fcl = fcl;
        this.fcode = fcode;
    }

    public GeoNames(String toponymName, String name, double lat, double lng, int geonameId,
                    String countryCode, int population, String fcl, String fcode) {
        this.toponymName = toponymName;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.geonameId = geonameId;
        this.countryCode = countryCode;
        this.population = population;
        this.fcl = fcl;
        this.fcode = fcode;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
