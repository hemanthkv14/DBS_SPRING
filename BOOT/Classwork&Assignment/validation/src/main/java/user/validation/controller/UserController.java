package user.validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import user.validation.model.UserData;
import user.validation.dao.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao usr;
	
	@RequestMapping("/display")
	public List<UserData> getData(){
		List<UserData> usrList = usr.displayAll();
		return usrList;
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResponseEntity<String> validateData(@RequestBody String cred){
		String[] str = cred.split(" ");
		boolean b = false;
		for(UserData t : getData()) {
			if(t.getName().equals(str[0]) && t.getPassword().equals(str[1])) {
				b=true;
				break;
			}
		}
		System.out.println(b ? "Valid User" : "Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}
