package com.arafa.JPAdemo.service;

import com.arafa.JPAdemo.model.Student;
import com.arafa.JPAdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
      return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }

    public Student getStudentById(long id){
        return repository.findById(id).orElse(null);
    }

//    public Student getStudentByName(String name){
//        return repository.findByName(name);
//    }

    public String deleteStudent(long id){
        repository.deleteById(id);
        return "Student removed : " + id;
    }

    public Student updateStudent(Student student){
        Student existingStudent = repository.findById(student.getId()).orElse(null);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        return repository.save(existingStudent);
    }
}