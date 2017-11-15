package springvaadin.WearherService;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springvaadin.WeatherManager;

@Component
public class Service {
	
	RestTemplate restTemplate;
	WeatherManager weatherManager;
	

	public WeatherManager getWeather(String city){
		
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
    	restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    	
    	//weatherManager = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=d71bf9828a75d362d858d04df4c6e1e6", WeatherManager.class);
    	weatherManager = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=a2035307b1bf830eef8777619bb91fbb", WeatherManager.class);

    	return weatherManager;
	}
	
	public WeatherManager getWeatherManager(){
		return this.weatherManager;
	}
}
