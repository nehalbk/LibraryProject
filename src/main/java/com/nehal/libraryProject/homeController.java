package com.nehal.libraryProject;
//package com.nehal.learnSpring;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//@Controller
//public class homeController {
//	@Autowired
//	borrowerRepo repo;
//	
////	@ModelAttribute
////	public void modelData(Model m,borrowers b) {
////		m.addAttribute("name", b.getBorrower_id());
////	}
//	
//	@RequestMapping("/") 
//	public String home() {
//		//System.out.print("Home page requested");
//		return "index";
//	}
//	
//	@RequestMapping("/borrow") 
//	public String borrow(@ModelAttribute("borrower") borrowers b) {
//		return "borrowed";
//	}
//	
////	@RequestMapping("/borrowers")
////	@ResponseBody
////	public List<borrowers> getBorrowers(Model m) {
//////		m.addAttribute("result",repo.findAll());
////		return repo.findAll();
////	}
//	
//	@GetMapping("/getborrower")
//	public String getBorrower(@RequestParam int borrower_id,Model m) {
//		m.addAttribute("result",repo.findById(borrower_id));
//		return "showBorrowers";
//	}
//	
//	@PostMapping(value="/addborrower")
//	public String addborrower(@ModelAttribute("borrower") borrowers b) {
//		repo.save(b);
//		return "borrowed";
//	}
//	
//	@PostMapping(value="/deleteborrower")
//	public String deleteborrower(@RequestParam int borrower_id,Model m) {
//		repo.deleteById(borrower_id);
//		m.addAttribute("result",repo.findAll());
//		return "showBorrowers";
//	}
//	
//}
