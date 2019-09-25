package com.primix.service;

import java.util.List;
import java.util.Optional;
import com.primix.model.exam.Exam;
import com.primix.model.exam.Lesson;
import com.primix.model.exam.Question;
import com.primix.respositories.ExamRepository;
import com.primix.respositories.LessonRepository;
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
public class ExamService {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    LessonRepository lessonRepository;
    
    @GetMapping("/api/exam")
    public List<Exam> findAllExams(){
       return (List<Exam>) examRepository.findAll();
    }

    @GetMapping("/api/exam/{examId}")
    public Exam findExamById(@PathVariable("examId") int examId){
        Optional<Exam> data = examRepository.findExamById(examId);
        if(data.isPresent()){
            return data.get();
        }
        else{
            return null;
        }
   }

   @GetMapping("/api/lesson/{lesson}/exam")
   public List<Exam> findAllExamForLesson(@PathVariable("lessonId") int lessonId){
       Optional<Lesson> optional = lessonRepository.findById(lessonId);
       if(optional.isPresent()){
           Lesson lesson = optional.get();
           return lesson.getExams();
       }
       return null;
   }

   @GetMapping("/api/lesson/{lessonId}/exam/{examId}/questions")
   public List<Question> findAllQuestionForExam(@PathVariable("lessonId")int lessonId,
    @PathVariable("examId") int examId){

        Optional<Exam> data = examRepository.findById(examId);
        if(data.isPresent()){
            Exam e = data.get();
            return e.getQuestions();
        }
        return null;
    }

    @GetMapping("/api/lesson/{lessonId}/exam/{examId}/essays")
    public List<Question> findAllEssaysForExam(@PathVariable("lessonId") int lessonId,
    @PathVariable("examId") int examId){
        Optional<Exam> data = examRepository.findById(examId);
        if(data.isPresent()){
            Exam e = data.get();
            return e.getQuestions();
        }
        return null;
    }

    @PostMapping("/api/lesson/{lessonId}/exam")
    public Exam createExam(@PathVariable("lessonId") int lessonId,
    @RequestBody Exam newExam){
        Optional<Lesson> data = lessonRepository.findById(lessonId);
        if(data.isPresent()){
            Lesson lesson = data.get();
            newExam.setLesson(lesson);
            return examRepository.save(newExam);
        }
        return null;
    }

    @DeleteMapping("/api/exam/{examId}")
    public void deleteExam(@PathVariable("examId")int examId){
        examRepository.deleteById(examId);
    }
}