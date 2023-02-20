package kg.edu.alatoo.tasktracker.repository;

import kg.edu.alatoo.tasktracker.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
