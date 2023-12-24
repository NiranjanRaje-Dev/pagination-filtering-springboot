package com.gamers;

import com.gamers.Utils.DataInsertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GamersApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(GamersApplication.class, args);
		DataInsertUtil dataInsertUtil = applicationContext.getBean(DataInsertUtil.class);
		//dataInsertUtil.insertDataInDb();

	}

	@Bean
	public ModelMapper modelMapper(){ return new ModelMapper(); }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){ return builder.build(); }


}
