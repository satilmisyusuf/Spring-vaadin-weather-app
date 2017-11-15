package springvaadin.WearherService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class sys {

    @JsonProperty("type")
    private int type;


    @JsonProperty("id")
    private int id;


    @JsonProperty("sunrise")
    private int sunrise;


    @JsonProperty("country")
    public String country;



    @Override
    public String toString() {
        return "sys [" + id + "," + type + "," +sunrise + "," +country + "," +"]";
    }
}
