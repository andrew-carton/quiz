package ie.andrew.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

		@GetMapping("/")
		public String showHome() {
			return "home";
		}
}