package springvaadin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import springvaadin.WearherService.weather;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherManager {

//	@JsonProperty("name")
	public String name;


	@JsonProperty("main")
	public springvaadin.WearherService.main main;


	@JsonProperty("sys")
	public springvaadin.WearherService.sys sys;


	@JsonProperty("weather")
	public List<weather> weather;





	@Override
	public String toString() {
		return "WeatherManager [name=" + name + ", main=" + main + ", property="
				+ weather + "]";
	}
	
	
	
}
