package thu.example.thanhthu1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thu.example.thanhthu1.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingIgnoreCase(String name);
}
