package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.model.AuthorVO;
import org.zerock.model.Criteria;
import org.zerock.model.PageDTO;
import org.zerock.service.AuthorService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin")
@Log4j
public class AdminController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {
		log.info("������ ������ �̵�");
	}
	
	@RequestMapping(value = "/goodsManage", method = RequestMethod.GET)
	public void goodsManageGET() throws Exception{
		log.info("��ǰ ��� ������ ����");
	}
	
	@RequestMapping(value = "/goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET() throws Exception{
		log.info("��ǰ ���� ������ ����");
	}
	
	@RequestMapping(value = "/authorEnroll", method = RequestMethod.GET)
	public void autherEnrollGET() throws Exception{
		log.info("�۰� ��� ������ ����");
	}
	
	@RequestMapping(value = "/authorManage", method = RequestMethod.GET)
	public void autherManageGET(Criteria cri, Model model) throws Exception{
		log.info("�۰� ���� ������ ����" + cri);
		
		List<AuthorVO> list = authorService.authorGetList(cri);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
		}
		
		int total = authorService.authorGetTotal(cri);
		PageDTO pageMaker = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/authorDetail")
	public void authorGetInfoGET() throws Exception {
		
	}
	
	@RequestMapping(value = "/authorEnroll.do", method = RequestMethod.POST)
	public String autherEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{
		log.info("authorEnroll: " + author);
		
		authorService.authorEnroll(author);
		rttr.addFlashAttribute("enroll_result", author.getAuthorName());
		
		return "redirect:/admin/authorManage";
	}
	
}


