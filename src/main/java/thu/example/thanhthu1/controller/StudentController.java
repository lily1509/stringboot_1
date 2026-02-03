package thu.example.thanhthu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import thu.example.thanhthu1.model.Student;
import thu.example.thanhthu1.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    // Thêm sinh viên
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // Xóa sinh viên
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }

    // Tìm kiếm theo tên
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return service.findByName(name);
    }

    // Xem chi tiết sinh viên
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Lấy danh sách sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // ✅ CẬP NHẬT SINH VIÊN (ĐÃ SỬA)
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return service.updateStudent(id, student);
    }
}
