package org.springframework.security.oauth.examples.sparklr.service.photo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = {"name"})
@Builder
public class Photo {

	private String name;

	@JsonIgnore
	private Owner owner;

}
