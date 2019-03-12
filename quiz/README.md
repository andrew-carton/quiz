# Quiz

This is a riddle Quiz project done in html/css/javascript as frontend and Java Spring and Hibernate as backend. It is a project used so I can learn full-stack web development.

## Getting started

I used MySQL as the database backend. The database schema needs to be done in a particular way in order to interface with Spring Security, which is needed for the user accounts and roles. I supplied an SQL script in scripts folder called createdb.sql in order to create the database needed to run the application.

### Building

The project is setup using Maven so you can build the deployment file easily enough from sources. For this project, I am using eclipse, and I had to change eclipse settings in order to source the files from inside the src/main/java as Maven wants. The dependencies are listed in Maven.

## The Project

### Spring and Hibernate

I watched a tutorial on Udemy about Spring and Hibernate. The Spring MVC and Hibernate was easy enough to learn after completing my python web development course, as the concepts were pretty familiar. I configured Spring MVC using pure Java rather than XML, although the tutorial went over both approaches. I configured Hibernate with a configuration file. I also used Spring Security to create a custom login page and authorise the different pages and resources I was using with accounts. The Spring Security section was quite difficult to get setup, especially interfacing with Hibernate to the compound key that I needed to research.

## JSP and JSTL

I used JSP and JSTL as my view components. I also created generic tags to act as a 'template' for my other pages.

## HTML/CSS/Javascript

I used standard HTML / CSS and Javascript with this project. I used an online tutorial using flexbox to create a responsive navbar for the Quiz.










