package ie.andrew.quiz.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.andrew.quiz.model.User;

@Controller
public class QuizController {

		@Autowired
		SessionFactory hibernateFactory;
	
		@GetMapping("/")
		public void showHome(HttpServletRequest request, HttpServletResponse response) {
			try {
				response.sendRedirect(request.getContextPath() + "/play");
			} catch (IOException e) {
			}
		}
		
		@RequestMapping("/logout")
	    public void logout(HttpServletRequest request, HttpServletResponse response) {
	        new SecurityContextLogoutHandler().logout(request, null, null);
	        
	        try {
				response.sendRedirect(request.getContextPath() + "/login");
			} catch (IOException e) {
			}
	    }
		
		@RequestMapping("/scores")
		public String scores(HttpServletRequest request, HttpServletResponse response, Model model) {
		
			Session session = hibernateFactory.getCurrentSession();
			session.beginTransaction();
			List<User> users = session.createQuery("from User order by score desc").list();
			model.addAttribute("users", users);
			
			session.close();
			return "scores";
		}
		
		@RequestMapping(value = "/play", method = { RequestMethod.GET, RequestMethod.POST })
		public String quiz(HttpServletRequest request, Model model) {
			
			String questionid = request.getParameter("questionid");
			String answer = request.getParameter("answer");
			String user = SecurityContextHolder.getContext().getAuthentication().getName();
			Session session = hibernateFactory.getCurrentSession();
			session.beginTransaction();
			List<User> users = session.createQuery("from User where username='" + user + "'").list();
			User userobj = users.get(0);
			model.addAttribute("user", user);
			model.addAttribute("score", userobj.getScore());
			
			
			
			InputStream is;
			try {
				is = new ClassPathResource("riddles.json").getInputStream();
				JSONTokener tokener = new JSONTokener(is);
				JSONArray riddles = new JSONArray(tokener);
				Random r = new Random();
				int low = 1;
				int high = riddles.length() - 1;
				int result = r.nextInt(high-low) + low;
				
				
				JSONObject object = riddles.getJSONObject((result));
				
				model.addAttribute("question", object.getString("question"));
				model.addAttribute("questionid", result);
				
				if (questionid != null) {
					JSONObject answerj = riddles.getJSONObject(Integer.parseInt(questionid));
					model.addAttribute("answer", answerj.getString("answer"));
					
					
					if (answerj.getString("answer").toLowerCase().equals(answer.toLowerCase())) {
						userobj.setScore(userobj.getScore() + 1);
						session.save(userobj);
						session.getTransaction().commit();
						model.addAttribute("score", userobj.getScore());
						model.addAttribute("correct", true);
					}
					else
						model.addAttribute("correct", false);
						
				}

			} catch (IOException e) {
				throw new NullPointerException("riddles.json not found");
			}
			
			session.close();
			
			return "play";
		}
}
