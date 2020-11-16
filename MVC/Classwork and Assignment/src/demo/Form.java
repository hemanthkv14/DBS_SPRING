package demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Form {
	
	@RequestMapping("/form")
	public String helloWorld(HttpServletRequest req, HttpServletResponse res, Model m) {
	
		String msg = req.getParameter("nm");
		m.addAttribute("message",msg);
		return "form";
	
	}
}