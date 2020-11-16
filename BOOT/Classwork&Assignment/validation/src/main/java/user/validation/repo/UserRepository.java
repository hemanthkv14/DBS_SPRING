package user.validation.repo;

import org.springframework.data.repository.CrudRepository;

import user.validation.model.UserData;

public interface UserRepository extends CrudRepository<UserData, Integer>{
		
}
