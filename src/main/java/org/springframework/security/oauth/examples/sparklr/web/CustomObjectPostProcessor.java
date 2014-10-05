package org.springframework.security.oauth.examples.sparklr.web;

import org.springframework.security.config.annotation.ObjectPostProcessor;

public class CustomObjectPostProcessor implements ObjectPostProcessor<String> {

	@Override
	public <O extends String> O postProcess(O object) {
		System.out.println(object);
		return null;
	}

}
