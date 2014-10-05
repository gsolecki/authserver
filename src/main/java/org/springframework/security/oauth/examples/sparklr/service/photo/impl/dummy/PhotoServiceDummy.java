package org.springframework.security.oauth.examples.sparklr.service.photo.impl.dummy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.io.FileUtils;
import org.springframework.security.oauth.examples.sparklr.service.photo.PhotoService;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Owner;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Photo;
import org.springframework.util.ResourceUtils;

public class PhotoServiceDummy implements PhotoService {

	private static final String PHOTOS_FORMAT = ".jpg";
	private static final String PHOTOS_LOCATION = "classpath:/photos/";
	private List<Photo> photos;

	public PhotoServiceDummy(List<Photo> photos) {
		setPhotos(photos);
	}

	@Override
	public Photo findByName(final String name) {
		return CollectionUtils.find(getPhotos(), new Predicate<Photo>() {
			@Override
			public boolean evaluate(Photo photo) {
				return photo.getName().equals(name);
			}
		});
	}

	@Override
	public List<Photo> findPhotosByOwner(final Owner owner) {
		return (List<Photo>) CollectionUtils.select(getPhotos(), new Predicate<Photo>() {
			@Override
			public boolean evaluate(Photo photo) {
				return photo.getOwner().equals(owner);
			}
		});
	}

	@Override
	public byte[] loadPhoto(final String name) {
		try {
			File file = ResourceUtils.getFile(getPhotoPath(name));
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String getPhotoPath(final String name) {
		return PHOTOS_LOCATION + findByName(name).getName() + PHOTOS_FORMAT;
	}

	private List<Photo> getPhotos() {
		return photos;
	}

	private void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}
