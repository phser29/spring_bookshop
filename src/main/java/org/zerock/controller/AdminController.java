package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.model.AuthorVO;
import org.zerock.model.BookVO;
import org.zerock.model.Criteria;
import org.zerock.model.PageDTO;
import org.zerock.service.AdminService;
import org.zerock.service.AuthorService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin")
@Log4j
public class AdminController {
	
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {
		log.info("관리자 페이지 이동");
	}
	
	@RequestMapping(value = "/goodsManage", method = RequestMethod.GET)
	public void goodsManageGET() throws Exception{
		log.info("상품 등록 페이지 접속");
	}
	
	@RequestMapping(value = "/goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET() throws Exception{
		log.info("상품 관리 페이지 접속");
	}
	
	@RequestMapping(value = "/authorEnroll", method = RequestMethod.GET)
	public void autherEnrollGET() throws Exception{
		log.info("작가 등록 페이지 접속"); 
	}
	
	@RequestMapping(value = "/authorManage", method = RequestMethod.GET)
	public void autherManageGET(Criteria cri, Model model) throws Exception{
		log.info("작가 관리 페이지 접속" + cri);
		
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
	
	@RequestMapping(value = {"/authorDetail", "/authorModify"}, method = RequestMethod.GET)
	public void authorGetInfoGET(int authorId, Criteria cri, Model model) throws Exception {
		log.info("authorDetail.. " + authorId);
		
		model.addAttribute("cri", cri);
		model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
	}
	
	@RequestMapping(value = "/authorEnroll.do", method = RequestMethod.POST)
	public String autherEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		log.info("authorEnroll: " + author);
		
		authorService.authorEnroll(author);
		rttr.addFlashAttribute("author_result", author.getAuthorName());
		
		return "redirect:/admin/authorManage";
	}
	
	@RequestMapping(value = "/authorPop", method = RequestMethod.GET)
	public void authorPopGET(Criteria cri, Model model) throws Exception {
		log.info("authorPopGET..");
		
		cri.setAmount(5);
		
		List<AuthorVO> list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);	
		} else {
			model.addAttribute("listCheck", "empty");	
		}
		
		//페이지 이동 인터페이스 데이터
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
	}
	
	@RequestMapping(value = "/authorModify", method = RequestMethod.POST)
	public String authorModifyPOST(AuthorVO authorVO, RedirectAttributes rttr) throws Exception {
		log.info("authroModifyPOST.. " + authorVO);
		
		int result = authorService.authorModify(authorVO);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
	@RequestMapping(value = "/goodsEnroll", method = RequestMethod.POST)
	public String goodsEnrollPOST(BookVO book, RedirectAttributes rttr) throws Exception {
		log.info("goodsEnrollPOST..." + book);
		
		adminService.bookEnroll(book);
		rttr.addFlashAttribute("enroll_result", book.getBookName());
		
		return "redirect:/admin/authorManage";
	}
}


