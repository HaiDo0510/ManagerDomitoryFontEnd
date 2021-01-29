package org.o7planning.fontend.service;


import java.util.List;

import org.o7planning.fontend.model.Student;
import org.o7planning.fontend.model.StudentPage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentService {
    public static final String REST_SERVICE_URI = "https://dothanhhai.herokuapp.com/student/";
    RestTemplate restTemplate = new RestTemplate();

    public List<Student> getAllStudent() throws JsonMappingException, JsonProcessingException {
        String students = restTemplate.getForObject(REST_SERVICE_URI, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(students, new TypeReference<List<Student>>() {
        });
    }

    public StudentPage getAllStudentPage(Integer page, Integer limit) {
        StudentPage studentPage = restTemplate.getForObject("https://dothanhhai.herokuapp.com/student" + "?page=" + page + "&limit=" + limit, StudentPage.class);
        return studentPage;
    }

    public void insertStudent(Student student) {
        restTemplate.postForObject(REST_SERVICE_URI, student, Student.class);
    }

    public void updateStudent(Student student) {
        Long id = student.getId();
        restTemplate.put(REST_SERVICE_URI + id, student);
    }


    public void deleteStudent(Long id) {
        restTemplate.delete(REST_SERVICE_URI + id);
    }

    public Student getStudentById(Long id) {
        Student student = restTemplate.getForObject(REST_SERVICE_URI + id, Student.class);
        return student;
    }


//    public static void main(String[] args) {
//        StudentService s = new StudentService();
//        System.out.println("yep");
//        StudentPage a = new StudentPage();
//        a = s.getAllStudentPage(1,3);
//        //a = s.getAllStudentPage(new Integer(1), new Integer(3));
//
//        System.out.println(a.toString());
//
//    }
}
