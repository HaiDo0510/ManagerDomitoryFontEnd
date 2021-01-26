package org.o7planning.fontend.controller;

import java.util.List;

import org.o7planning.fontend.model.Room;
import org.o7planning.fontend.model.Student;
import org.o7planning.fontend.model.StudentPage;
import org.o7planning.fontend.service.RoomService;
import org.o7planning.fontend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoomService roomService;


    @RequestMapping("/list-student")
    public String listStudent(Model model) throws JsonMappingException, JsonProcessingException {
        StudentPage studentPage = studentService.getAllStudentPage(new Integer(1), new Integer(4));
        List<Student> students = studentPage.getListResult();
        model.addAttribute("listStudent", students);
        model.addAttribute("currentIndex", studentPage.getPage());
        model.addAttribute("totalPageCount", studentPage.getTotalPage());
        return "Student/list-student";
    }

    @RequestMapping("/list-student-page")
    public String listStudentPage(Model model,
                                  @RequestParam(value = "page") Integer page,
                                  @RequestParam(value = "limit") Integer limit) throws JsonMappingException, JsonProcessingException {
        StudentPage studentPage = studentService.getAllStudentPage(page, limit);
        List<Student> students = studentPage.getListResult();
        model.addAttribute("listStudent", students);
        model.addAttribute("currentIndex", studentPage.getPage());
        model.addAttribute("totalPageCount", studentPage.getTotalPage());
        return "Student/list-student";
    }

    @RequestMapping("/add-student")
    public String linkAddStudent(Model model) throws JsonMappingException, JsonProcessingException {

        List<Room> rooms = roomService.getAllRoom();
        model.addAttribute("listRoom", rooms);
        return "Student/add-student";
    }

    // Thêm mới một sinh viên
    @RequestMapping("/createStudent")
    public String addStudent(Student student) {
        // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // student.setBirth_day(formatter.parse(student.getBirth_day()));
        // Student student = (Student) model.getAttribute("student");
        System.out.println(student);
        studentService.insertStudent(student);
        return "redirect:/list-student";
    }

    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/list-student";
    }

    @RequestMapping("/infoStudent/{id}")
    public String infoStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "Student/info-student";
    }

    @RequestMapping("/pageUpdateStudent/{id}")
    public String pageUpdateStudent(@PathVariable("id") Long id, Model model) throws JsonMappingException, JsonProcessingException {
        model.addAttribute("student", studentService.getStudentById(id));
        List<Room> rooms = roomService.getAllRoom();

        model.addAttribute("listRoom", rooms);
        return "Student/edit-student";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/list-student";
    }

    @RequestMapping("/info-student")
    public String infoStudent() {
        return "Student/info-student";
    }

}
