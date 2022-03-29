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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

//	@GetMapping("/")
//	String index() {
//		return "index";
//	}

	@GetMapping("/")
	String index(){
		return "/about";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/loginAD")
	String loginUser(Model model, OAuth2AuthenticationToken authentication) {
		OAuth2User authUSer = authentication.getPrincipal();
		Object details = authentication.getDetails();
//		model.addAttribute("body", "Hi, " + authUSer.getName()
//				+ "\n ,granted authorities: " + authUSer.getAuthorities());
//		return "response";

		return "/about";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/logout")
	public String logout() {
		return "/home";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

}
