package org.o7planning.fontend.controller;

import java.util.List;

import org.o7planning.fontend.model.Service1;
import org.o7planning.fontend.service.Service1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class Service1Controller {
	@Autowired
	private Service1Service service1Service;

	

	@RequestMapping("/list-service1")
	public String listService1(Model model) throws JsonMappingException, JsonProcessingException {
		List<Service1> service1s = service1Service.getAllService1();
		model.addAttribute("listService1", service1s);
		return "Service1/list-service1";
	}

	

	@RequestMapping("/add-service1")
	public String linkAddService1() {
		return "Service1/add-service1";
	}

	@RequestMapping("/createService1")
	public String addService1(Service1 service1) {
		// DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// service1.setBirth_day(formatter.parse(service1.getBirth_day()));
		// Service1 service1 = (Service1) model.getAttribute("service1");
//		System.out.println(service1);
	//	service1.setNumberpcurrent(0);
		service1Service.insertService1(service1);
		return "redirect:/list-service1";
	}

	@RequestMapping("/deleteService1/{id}")
	public String deleteService1(@PathVariable("id") Long id) {
		service1Service.deleteService1(id);
		return "redirect:/list-service1";
	}

	@RequestMapping("/infoService1/{id}")
	public String infoService1(@PathVariable("id") Long id, Model model) {
		model.addAttribute("service1", service1Service.getService1ById(id));
		return "Service1/info-service1";
	}


	@RequestMapping("/pageUpdateService1/{id}")
	public String pageUpdateService1(@PathVariable("id") Long id, Model model) {
		model.addAttribute("service1", service1Service.getService1ById(id));
		return "Service1/edit-service1";
	}

	@RequestMapping("/updateService1")
	public String updateService1(Service1 service1) {
		service1Service.updateService1(service1);
		return "redirect:/list-service1";
	}

	@RequestMapping("/info-service1")
	public String infoService1() {
		return "Service1/info-service1";
	}
}
