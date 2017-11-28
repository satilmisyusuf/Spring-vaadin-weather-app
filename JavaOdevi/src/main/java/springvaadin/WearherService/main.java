package springvaadin.WearherService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class main {

	@JsonProperty("temp")
	public int temp;


	@JsonProperty("pressure")
	public int pressure;


	@JsonProperty("humidity")
	public int humidity;



	@Override
	public String toString() {
		return "main [temp=" + temp + ", pressure=" + pressure +", humidity"+humidity+"]";
	}
	
	
}
