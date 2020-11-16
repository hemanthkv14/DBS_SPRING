package user.validation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.validation.model.UserData;
import user.validation.repo.UserRepository;

@Service
public class UserDao {

	@Autowired
	UserRepository ur;
	
	public List<UserData> displayAll(){
		List<UserData> ul = (List<UserData>) ur.findAll();
		return ul;
	}
	
}
