package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin")
@Log4j
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {
		
		log.info("������ ������ �̵�");
	}
}

