package mothi.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mothi.it.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

}
