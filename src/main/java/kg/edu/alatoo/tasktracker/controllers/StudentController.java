package kg.edu.alatoo.tasktracker.controllers;

import kg.edu.alatoo.tasktracker.entity.Student;
import kg.edu.alatoo.tasktracker.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    // CRUD
    // POST, GET, PUT, DELETE
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    List<Student> getAllStudents() {
        return (List) studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    Optional<Student> getOneStudent(@PathVariable Long id) {
        return  studentRepository.findById(id);
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentRepository.findById(id).map(
                student -> {
                    student.setName(newStudent.getName());
                    student.setGpa(newStudent.getGpa());
                    return studentRepository.save(student);
                }).orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                }
        );
    }

    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}