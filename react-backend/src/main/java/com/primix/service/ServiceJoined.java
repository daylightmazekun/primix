package com.primix.service;

import java.util.Optional;
import com.primix.model.exam.EssayExamQuestion;
import com.primix.model.exam.Exam;
import com.primix.model.exam.FillInTheBlankExamQuestion;
import com.primix.model.exam.MultipleChoiceQuestion;
import com.primix.model.exam.TrueFalseQuestion;
import com.primix.respositories.BaseQuestionRepository;
import com.primix.respositories.EssayExamRepositoryJoined;
import com.primix.respositories.ExamRepository;
import com.primix.respositories.FillInTheBlankQuestionRepositoryJoined;
import com.primix.respositories.MultiChoiceRepositoryJoined;
import com.primix.respositories.TrueOrFalseQuestionRepositoryJoined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ServiceJoined {

    @Autowired
    BaseQuestionRepository baseQuestionRepository;

    @Autowired
    FillInTheBlankQuestionRepositoryJoined fillRepo;

    @Autowired
    TrueOrFalseQuestionRepositoryJoined trueRepo;

    @Autowired
    EssayExamRepositoryJoined essayRepo;

    @Autowired
    ExamRepository examRepo;

    @Autowired
    MultiChoiceRepositoryJoined multiRepo;

    @PostMapping("/api/exam/{examId}/essay")
    public EssayExamQuestion addEssay(@PathVariable("examId") int id, @RequestBody EssayExamQuestion essay) {
        Optional<Exam> data = examRepo.findById(id);
        if (data.isPresent()) {
            Exam exam = data.get();
            essay.setExam(exam);
            return essayRepo.save(essay);
        }
        return null;
    }
    @PostMapping("/api/exam/{examId}/blanks")
    public FillInTheBlankExamQuestion addBlanks(@PathVariable("examId") int examId, @RequestBody FillInTheBlankExamQuestion blanks){
        Optional<Exam> data = examRepo.findById(examId);
        if(data.isPresent()){
            Exam exam = data.get();
            blanks.setExam(exam);
            return fillRepo.save(blanks);
        }
        return null;
    }

    @PostMapping("/api/exam/{examId}/choice")
    public MultipleChoiceQuestion addChoice(@PathVariable("examId") int id, @RequestBody MultipleChoiceQuestion multipleChoice){
        Optional<Exam> data = examRepo.findById(id);
        if(data.isPresent()){
            Exam exam = data.get();
            multipleChoice.setExam(exam);
            return multiRepo.save(multipleChoice);
        }
        return null;
    }

	@PostMapping("/api/exam/{examId}/truefalse")
	public TrueFalseQuestion addTrueFalse(@PathVariable("examId") int id, 
			@RequestBody TrueFalseQuestion truefalse) {
		Optional<Exam> data = examRepo.findById(id);
		if(data.isPresent()) {
			Exam exam = data.get();
			truefalse.setExam(exam);
			return trueRepo.save(truefalse);
		}
		return null;
	}
}
