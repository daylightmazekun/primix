package com.primix.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.primix.model.exam.Course;
import com.primix.model.exam.Lesson;
import com.primix.model.exam.Module;
import com.primix.respositories.CourseRepository;
import com.primix.respositories.LessonRepository;
import com.primix.respositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/lesson")
    public List<Lesson> findAllLessons(){
        return (List<Lesson>) lessonRepository.findAll();
    }

    @GetMapping("/api/course/{cid}/module/{mid}/lesson")
    public List<Lesson> findForModule(@PathVariable(name="mid") int moduleId){
        Optional<Module> optionalModule = moduleRepository.findById(moduleId);
        if(optionalModule.isPresent()){
            Module module = optionalModule.get();
            return (List<Lesson>) module.getLessons();
        }
        return  null;
    }

    @PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
    public Lesson createLesson(
        @PathVariable("courseId") int courseId,
        @PathVariable("moduleId") int moduleId,
        @RequestBody Lesson newLesson
    ){
        Optional<Course> data = courseRepository.findCourseById(courseId);
        Optional<Module> mod = moduleRepository.findModuleById(moduleId);
        if(data.isPresent() && mod.isPresent()){
            Module moddata = mod.get();
            newLesson.setModule(moddata);
            return lessonRepository.save(newLesson);
        }
        return null;
    }
    @DeleteMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}")
    public void deleteLesson(
        @PathVariable("courseId") int courseId,
        @PathVariable("moudleId") int moudleId,
        @PathVariable("lessonId") int lessonId
    ){
        Optional<Lesson> data = lessonRepository.findById(lessonId);
        if(data.isPresent()){
            Optional<Course> courseData = courseRepository.findById(courseId);
            if(courseData.isPresent()){
                Course course = courseData.get();
                Date date = new Date(System.currentTimeMillis());
                course.setModified(date);
            }
            lessonRepository.deleteById(lessonId);
        }
    }

}