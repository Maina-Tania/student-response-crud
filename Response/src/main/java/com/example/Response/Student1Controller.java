package com.example.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student1")
public class Student1Controller {
    @Autowired
    private Student1Service student1Service;

    @PostMapping("add")
    public ResponseEntity<EntityResponse>addNewStudent(@RequestBody Student1 student1){
        EntityResponse response = student1Service.addNewStudent(student1);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @GetMapping("get-all")
    public ResponseEntity<EntityResponse>getStudents(){
        EntityResponse response = student1Service.getStudents();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @GetMapping("get-by/{id}")
    public ResponseEntity<EntityResponse>getStudentById(Long id){
        EntityResponse response = student1Service.getStudentById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<EntityResponse>updateStudent(@RequestBody Student1 request,@PathVariable Long id){
        EntityResponse response = student1Service.updateStudent(request, id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @DeleteMapping("delete")
    public ResponseEntity<EntityResponse>deleteStudent(@RequestParam Long id){
        EntityResponse response = student1Service.deleteStudent(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);}
    }

