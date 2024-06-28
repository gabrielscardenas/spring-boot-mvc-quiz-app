package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QuizController {

    @GetMapping("/quiz")
    public String quiz(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam("score") int score, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        session.setAttribute("score", score);
        session.setAttribute("hasTakenQuiz", true);

        Map<String, Integer> grades = (Map<String, Integer>) session.getServletContext().getAttribute("grades");
        if (grades == null) {
            grades = new HashMap<>();
        }
        grades.put(username, score);
        session.getServletContext().setAttribute("grades", grades);

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String grades(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        Map<String, Integer> grades = (Map<String, Integer>) session.getServletContext().getAttribute("grades");
        if (grades == null) {
            grades = new HashMap<>();
        }
        model.addAttribute("grades", grades);

        return "grades";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username, HttpSession session) {
        session.setAttribute("username", username);
        session.setAttribute("hasTakenQuiz", false);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        Boolean hasTakenQuiz = (Boolean) session.getAttribute("hasTakenQuiz");
        if (hasTakenQuiz == null) {
            hasTakenQuiz = false;
        }

        model.addAttribute("username", username);
        model.addAttribute("quizLinkLabel", hasTakenQuiz ? "Retake Quiz" : "Take Quiz");

        return "home";
    }
}
