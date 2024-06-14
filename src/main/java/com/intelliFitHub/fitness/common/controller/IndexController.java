package com.intelliFitHub.fitness.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		log.info("*** index");
		return "index";
	}

	// direct to about page, so on so forth
	@GetMapping({ "/about" })
	public String about(Model model) {
		log.info("*** about");
		return "about";
	}

	@GetMapping({ "/blog" })
	public String blog(Model model) {
		log.info("*** blog");
		return "blog";
	}

	@GetMapping({ "/class" })
	public String goclass(Model model) {
		log.info("*** class");
		return "class";
	}
}
