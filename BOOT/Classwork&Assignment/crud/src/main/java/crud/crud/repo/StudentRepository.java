package crud.crud.repo;

import org.springframework.data.repository.CrudRepository;

import crud.crud.model.StudentData;

public interface StudentRepository extends CrudRepository<StudentData, Integer>{
		
}
