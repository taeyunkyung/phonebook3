package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");

		return "/WEB-INF/views/writeForm.jsp";
	}

	/*@RequestMapping(value = "phone/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, 
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write");
		// System.out.println(name + "/" + hp + "/" + company);
		PersonVo vo = new PersonVo(name, hp, company);

		return "/WEB-INF/views/writeForm.jsp";
	}*/
	
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write");
		
		// System.out.println(personVo);
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController>list");
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		// controller --> DispatcherServlet
		model.addAttribute("personList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(@RequestParam("personId") int personId,
		Model model) {
		System.out.println("PhoneController>updateForm");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(personId);
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("PhoneController>delete");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(personId);
		
		return "redirect:/phone/list";
	}

}
