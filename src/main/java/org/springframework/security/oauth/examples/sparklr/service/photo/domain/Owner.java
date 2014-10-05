package org.springframework.security.oauth.examples.sparklr.service.photo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = {"username"})
@Builder
public class Owner {
	
	@NonNull
	private String username;
	private String name;
	
}
