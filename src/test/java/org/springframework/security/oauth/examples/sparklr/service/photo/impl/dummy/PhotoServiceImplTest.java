package org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth.examples.sparklr.service.ServicesConfig;
import org.springframework.security.oauth.examples.sparklr.service.photo.PhotoService;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Photo;
import org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy.domain.DummyData;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServicesConfig.class })
public class PhotoServiceImplTest {

	@Autowired
	PhotoService photoService;

	@Test
	public void testFindByName() {

		// When
		Photo photo = photoService.findByName(DummyData.Photos.PHOTO1.getName());

		// Then
		assertThat(photo, equalTo(DummyData.Photos.PHOTO1));

	}

	@Test
	public void testFindPhotosByOwner() {

		// When
		Collection<Photo> photos = photoService.findPhotosByOwner(DummyData.Owners.MARISSA);

		// Then
		assertThat(photos.size(), lessThan(DummyData.Photos.PHOTOS.size()));

	}

	@Test
	public void testLoadPhoto() {

		// When
		byte[] photoBytes = photoService.loadPhoto(DummyData.Photos.PHOTO1.getName());

		// Then
		assertThat(photoBytes.length, equalTo(7487));

	}

}
