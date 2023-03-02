package kg.edu.alatoo.tasktracker.repository;

import kg.edu.alatoo.tasktracker.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}