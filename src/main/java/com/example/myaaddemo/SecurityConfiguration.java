/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myaaddemo;

import com.azure.spring.aad.webapp.AADWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfiguration extends AADWebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
			// -- swagger ui
			"/swagger-resources/**",
			"/swagger-ui/index.html",
			"/swagger-ui.html",
			"/swagger-ui",
			"/swagger-ui/**",
			"/v3/api-docs",
			"/webjars/**",
			"/webjars/bootstrap/**",
			// actuator endpoints
			"/actuator/health",
			"/actuator/info",
			"/actuator/env",
			"/actuator/metrics",
			"/actuator/prometheus",
			"/favicon.ico",
			"/Admin",
			"/css/**",
			"/js/**",
			"/assets/**",
			"/" // just to avoid WARNING log when azure always-on calls /
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		// @formatter:off
		http
			.authorizeRequests((authorize) -> authorize
				.antMatchers("/").permitAll()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
			)
			.oauth2Login(Customizer.withDefaults());
		// @formatter:on
	}

}
