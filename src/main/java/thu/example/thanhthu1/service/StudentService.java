package thu.example.thanhthu1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thu.example.thanhthu1.model.Student;
import thu.example.thanhthu1.repository.StudentRepository;

@Service
@Transactional   // <<< QUAN TRỌNG NHẤT
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public List<Student> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    // ✅ UPDATE CHẮC CHẮN GHI DB
    public Student updateStudent(int id, Student student) {
        Student existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setImage(student.getImage());

        return repository.save(existing); // commit DB
    }
}
