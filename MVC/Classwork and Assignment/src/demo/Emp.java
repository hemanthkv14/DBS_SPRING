package demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Emp {
	

	@RequestMapping("/emp/{id1}")
	public String helloWorld(@RequestParam ("name") String name,
							 @RequestParam ("basic") int basic,
							 @RequestParam ("hra") int hra,
							 @RequestParam ("it") int it,
							 @RequestParam ("deductions") int deductions,
							 @PathVariable("id1") int id, 
							 HttpServletRequest req,
							 HttpServletResponse res,
							 Model m) {
		String un = req.getParameter("nm");
		int net, gross;
		if(id==259 && un.equalsIgnoreCase("Hemanth")) {
			gross = basic+hra+it+deductions;
			net = gross-deductions-it-((basic*12)/100);
			m.addAttribute("gross",gross);
			m.addAttribute("net", net);
			return "emp";
		}else {
			return "emp_err";
		}
	
	}
}