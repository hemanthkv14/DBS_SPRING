package demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Welcome {
	
	@RequestMapping("/welcome/{id1}")
	public String helloWorld(@RequestParam ("id") int id, @RequestParam ("name") String name, @PathVariable("id1") int id1, Model m) {
		
		String msg = "Given data : "+" Name : "+name+" \n Id : "+id+"  Path Variable : "+id1;
		m.addAttribute("message",msg);
		m.addAttribute("test","test");
		return "welcomepage";
		
	}
}
