package org.springframework.security.oauth.examples.sparklr.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth.examples.sparklr.service.photo.PhotoService;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Owner;
import org.springframework.security.oauth.examples.sparklr.service.photo.domain.Photo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ryan Heaton
 * @author Dave Syer
 */
@RestController
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	@RequestMapping("/photos/{photoId}")
	public ResponseEntity<byte[]> getPhoto(@PathVariable("photoId") String id) throws IOException {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "image/jpeg");
		byte[] bytes = getPhotoService().loadPhoto(id);

		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}

	@RequestMapping("/photos")
	public List<Photo> getAll(Principal principal) {
		return getPhotoService().findPhotosByOwner(Owner.builder().username(principal.getName()).build());
	}

	@RequestMapping("/photos/trusted/message")
	@PreAuthorize("#oauth2.clientHasRole('ROLE_CLIENT')")
	@ResponseBody
	public String getTrustedClientMessage() {
		return "Hello, Trusted Client";
	}

	private PhotoService getPhotoService() {
		return photoService;
	}

}
