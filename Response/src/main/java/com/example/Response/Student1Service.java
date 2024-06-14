package com.example.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student1Service {
    @Autowired
    private Student1Repository student1Repository;

    public EntityResponse addNewStudent(Student1 student1) {
        EntityResponse response = new EntityResponse<>();

        try {
            if (student1Repository.findByStudentName(student1.getStudentName()).isPresent()
            ) {
                response.setEntity(null);
                response.setMessage("Student already present");
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            } else {
                student1Repository.save(student1);
                response.setEntity(student1);
                response.setMessage("Student added successfully");
                response.setStatusCode(HttpStatus.OK.value());
            }

        } catch (Exception e) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An error occurred" + e.getMessage());
        }
        return response;
    }

    public EntityResponse getStudents() {
        EntityResponse response = new EntityResponse<>();
        List<Student1> student1 = student1Repository.findAll();
        try {
            if (!student1.isEmpty()) {
                response.setEntity(student1);
                response.setMessage("Students are found");
                response.setStatusCode(HttpStatus.OK.value());
            } else {
                response.setEntity(null);
                response.setMessage("List not found");
                response.setStatusCode(HttpStatus.NO_CONTENT.value());
            }
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("an error occurred" + e.getMessage());
        }
        return response;
    }
    public EntityResponse getStudentById(Long id) {
        EntityResponse response = new EntityResponse<>();
        Optional<Student1> student1 = student1Repository.findById(id);
        try {
            if (!student1.isEmpty()) {
                response.setEntity(student1);
                response.setMessage("Student is found");
                response.setStatusCode(HttpStatus.OK.value());
            } else {
                response.setEntity(null);
                response.setMessage("student not found");
                response.setStatusCode(HttpStatus.NO_CONTENT.value());
            }
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("an error occurred" + e.getMessage());
        }
        return response;
    }

    public EntityResponse updateStudent(Student1 request, Long id) {
        EntityResponse response = new EntityResponse<>();
        try {
            Optional<Student1> student1 = student1Repository.findById(id);
            if (student1.isPresent()) {
                Student1 student1Data = student1.get();
                if (request.getStudentName() != null) {
                    student1Data.setStudentName(request.getStudentName());
                }
                if (request.getRegistrationNumber() != null) {
                    student1Data.setRegistrationNumber(request.getRegistrationNumber());
                }
                if (request.getStudentEmailAddress() != null) {
                    student1Data.setRegistrationNumber(request.getRegistrationNumber());
                }
                Student1 updateStudent = student1Repository.save(student1Data);
                response.setEntity(student1);
                response.setMessage("student is updated successfully");
                response.setStatusCode(HttpStatus.ACCEPTED.value());
            } else {
                response.setEntity(null);
                response.setMessage("student is not available");
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            }
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("an error occurred" + e.getMessage());
        }
        return response;
    }

    public EntityResponse deleteStudent(Long id) {
        EntityResponse response = new EntityResponse<>();
        try {
            Optional<Student1> student1 = student1Repository.findById(id);
            if (student1.isPresent()) {
                student1Repository.deleteById(id);
                response.setEntity(student1);
                response.setMessage("deleted successfully");
                response.setStatusCode(HttpStatus.OK.value());
            } else {
                response.setEntity(null);
                response.setMessage("not deleted");
                response.setStatusCode(HttpStatus.NO_CONTENT.value());
            }
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("an error occurred" + e.getMessage());
        }
        return response;
    }



}





