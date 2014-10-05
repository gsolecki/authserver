package org.springframework.security.oauth.examples.sparklr.service.photo;

import java.util.List;

import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Owner;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Photo;

/**
 * Service for retrieving photos.
 *
 * @author Ryan Heaton
 */
public interface PhotoService {

	/**
	 * Find photos by the name.
	 *
	 * @param name
	 *            the name of a photo
	 * @return the photo
	 */
	Photo findByName(String name);

	/**
	 * Find photos by the given owner.
	 *
	 * @param owner
	 *            the owner of a photo
	 * @return photos for the given owner.
	 */
	List<Photo> findPhotosByOwner(Owner owner);

	/**
	 * Load a photo by name.
	 *
	 * @param name
	 *            The name of the photo.
	 * @return The photo that was read.
	 */
	byte[] loadPhoto(String name);
}
