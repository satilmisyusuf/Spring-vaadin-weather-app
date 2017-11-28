package springvaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class SpringVaadinApplication {



	public static void main(String[] args)
	{
		try {

			BufferedReader in = new BufferedReader(new FileReader("/Users/yusufsatilmis/Desktop/JavaProgramlama/Spring-vaadin-weather-app-master/JavaOdevi/city_list.txt"));

			String line;
			line = in.readLine();


			while((line = in.readLine()) != null)
			{

				int code;
				String name;
				String country;

				int konum1=line.indexOf('\t');


				code=Integer.parseInt(line.substring(0,konum1));
				line=line.substring(konum1+1);



				int konum2=line.indexOf('\t');
				name=line.substring(0,konum2);
				line=line.substring(konum2+1);

				int konum3=line.indexOf('\t');
				line=line.substring(konum3+1);

				int konum4=line.indexOf('\t');
				country=line.substring(konum4+1);



				City cty=new City(code,name,country);
				City.elements.add(cty);

			}
			in.close();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.println(City.elements.size()+"maaain");
		SpringApplication.run(SpringVaadinApplication.class, args);
	}
}
