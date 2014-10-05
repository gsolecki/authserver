package org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Owner;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Photo;

public interface DummyData {

	public static interface Owners {
		public static final Owner MARISSA = Owner.builder().username("marissa").build();
		public static final Owner PAUL = Owner.builder().username("paul").build();
	}

	public static interface Photos {
		public static final Photo PHOTO1 = Photo.builder().name("photo1").owner(Owners.MARISSA).build();
		public static final Photo PHOTO2 = Photo.builder().name("photo2").owner(Owners.PAUL).build();
		public static final Photo PHOTO3 = Photo.builder().name("photo3").owner(Owners.MARISSA).build();
		public static final Photo PHOTO4 = Photo.builder().name("photo4").owner(Owners.PAUL).build();
		public static final Photo PHOTO5 = Photo.builder().name("photo5").owner(Owners.MARISSA).build();
		public static final Photo PHOTO6 = Photo.builder().name("photo6").owner(Owners.PAUL).build();
		public static final List<Photo> PHOTOS = Arrays.asList(PHOTO1, PHOTO2, PHOTO3, PHOTO4, PHOTO5, PHOTO6);
	}

}
