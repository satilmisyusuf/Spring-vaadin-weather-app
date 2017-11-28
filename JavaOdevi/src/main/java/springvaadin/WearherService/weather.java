package springvaadin.WearherService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class weather {


	@JsonProperty("main")
	public String main;

	@JsonProperty("description")
	public String description;





	@Override
	public String toString() {
		return "weather [ main=" + main + ", description=" + description + "]";
	}
}
