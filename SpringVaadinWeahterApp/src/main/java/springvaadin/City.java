package springvaadin;

import java.util.ArrayList;

public class City {


    public static ArrayList<City> elements = new ArrayList<City>();

    int code;
    String name;

    String country;


    public City(int code, String name, String country){

        this.code=code;
        this.name=name;
        this.country=country;


    }

    public int getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

}
