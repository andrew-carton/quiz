package ie.andrew.quiz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ie.andrew.quiz.model.Authority;
import ie.andrew.quiz.model.User;

@Controller
public class RegisterController {

	@Autowired
	SessionFactory hibernateFactory;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/registerUser") 
	public String registerUser(HttpServletRequest request, HttpServletResponse resp, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Got register User " + username + " " + password);
		
		
		Session session = hibernateFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<User> users = session.createQuery("from User where username='" + username + "'").list();
			session.close();
			session = hibernateFactory.getCurrentSession();
			if (users.size() > 0) {
				System.out.println("User found");
				resp.sendRedirect(request.getContextPath() + "/register?error=1");
			} else {
				User user = new User(username, "{noop}" + password);
				Authority auth = new Authority(username, "ROLE_USER");
				session.beginTransaction();
				session.save(user);
				session.save(auth);
				session.getTransaction().commit();
				resp.sendRedirect(request.getContextPath() + "/login");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		return "register";
	}
	
}
