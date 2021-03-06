package com.primix.service;

import java.util.List;
import java.util.Optional;
import com.primix.model.exam.Lesson;
import com.primix.model.exam.Topic;
import com.primix.model.exam.Widget;
import com.primix.respositories.LessonRepository;
import com.primix.respositories.TopicRepository;
import com.primix.respositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository repository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;

	@GetMapping("/api/topic/{topic}/widget")
	public List<Widget> findAllWidgetsForLesson(@PathVariable("topicId") int topicId) {
		Optional<Topic> optionalTopic = topicRepository.findById(topicId);
		if (optionalTopic.isPresent()) {
			Topic topic = optionalTopic.get();
			return topic.getWidgets();
		}
		return null;
	}

	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody List<Widget> widgets) {
		repository.deleteAll();
		for (Widget widget : widgets) {
			repository.save(widget);
		}
	}

	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) repository.findAll();
	}

	@PostMapping("/api/lesson/{lessonId}/widget")
	public Widget createWidgetForLesson(@RequestBody Widget widget, @PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lsn = data.get();
			widget.setLesson(lsn);
			repository.save(widget);
		}

		return null;
	}

}