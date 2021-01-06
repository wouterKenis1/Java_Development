package com.vdab;

import com.vdab.models.Location;
import com.vdab.services.LocationService;
import com.vdab.services.LocationServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WouterApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WouterApplication.class, args);

//		LocationService service = ctx.getBean(LocationService.class);
//
//		Location location = new Location();
//		location.setName("testName");
//		location.setCountry("Belgium");
//		location.setRegion("Europe");
//		location.setCode(1234);
//
//		service.addLocation(location);


	}

}
