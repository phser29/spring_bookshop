package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BookController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPageGET() {
		log.info("���� ������ ����");
	}

}
