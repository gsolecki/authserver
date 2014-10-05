package org.springframework.security.oauth.examples.sparklr.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

// @formatter:off
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig {

	@Configuration
	public static class CustomAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.addObjectPostProcessor(new CustomObjectPostProcessor());
			clients.inMemory().withClient("tonr")
				.authorizedGrantTypes("implicit")
				.scopes("read");
		}
	}
}
// @formatter:on
