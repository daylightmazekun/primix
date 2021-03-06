package com.primix.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.primix.model.exam.Course;
import com.primix.model.exam.Module;
import com.primix.respositories.CourseRepository;
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
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;
    
    @PostMapping("/api/course/{courseId}/module")
    public Module createModule(
        @PathVariable("courseId") int courseId,
        @RequestBody Module newModule
    ){
        Optional<Course> data = courseRepository.findById(courseId);
        if(data.isPresent()){
            Optional<Course> courseData = courseRepository.findById(courseId);
            if(courseData.isPresent()){
                Course course = courseData.get();
                Date date = new Date(System.currentTimeMillis());
                course.setModified(date);
            }
            Course course = data.get();
            newModule.setCourse(course);
            return moduleRepository.save(newModule);
        }
        return null;
    }
    @GetMapping("/api/course/{courseId}/module")
    public List<Module> findAllModulesForCourse(@PathVariable("courseId") int courseId){
        Optional<Course> data = courseRepository.findCourseById(courseId);
        if(data.isPresent()){
            Course course = data.get();
            return course.getModules();
        }
        return null;
    }

    @DeleteMapping("/api/module/{moduleId}")
    public void deleteModule(@PathVariable("moduleId") int moduleId){
        moduleRepository.deleteById(moduleId);
    }

    @GetMapping("/api/module")
    public Iterable<Module> findAllModules(){
        return moduleRepository.findAll();
    }
    
 	@GetMapping("/api/module/{moduleId}")
	public Module findModuleByID(
			@PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId); 
		if (data.isPresent()) {
			return data.get();
		}
		else {
			return null;
		}
	}  
}