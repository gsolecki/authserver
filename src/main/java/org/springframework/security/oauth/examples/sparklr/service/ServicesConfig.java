package org.springframework.security.oauth.examples.sparklr.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth.examples.sparklr.service.photo.PhotoService;
import org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy.PhotoServiceDummy;
import org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy.domain.DummyData;

@Configuration
public class ServicesConfig {

	@Bean
	public PhotoService photoService() {
		return new PhotoServiceDummy(DummyData.Photos.PHOTOS);
	}

}
