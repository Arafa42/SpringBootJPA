package com.arafa.JPAdemo.controller;

import com.arafa.JPAdemo.model.Student;
import com.arafa.JPAdemo.repository.StudentRepository;
import com.arafa.JPAdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.saveStudents(students);
    }

    @GetMapping("/getstudents")
    public List<Student> findAllStudents(){
        return service.getStudents();
    }

    @GetMapping("/getstudentbyid/{id}")
    public Student findStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }

//    @GetMapping("/getstudentbyname/{name}")
//    public Student findStudenyByName(@PathVariable String name){
//        return service.getStudentByName(name);
//    }

    @PutMapping("/updatestudent")
    public Student updateStudentById(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Long Studentid,
                                                  @Valid @RequestBody Student studentDetails) throws ConfigDataResourceNotFoundException {
        Student student = service.getStudentById(Studentid);
        student.setEmail(studentDetails.getEmail());
        student.setLastName(studentDetails.getLastName());
        student.setFirstName(studentDetails.getFirstName());
        final Student updatedStudent = service.saveStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudentById (@PathVariable Long id){
       return service.deleteStudent(id);
    }

}
