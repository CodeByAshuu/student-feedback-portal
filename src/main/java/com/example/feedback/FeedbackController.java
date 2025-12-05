package com.example.feedback;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {

    List<Feedback> feedbackList = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("feedbackList", feedbackList);
        return "index";
    }

    @PostMapping("/submit")
    public String submitFeedback(@RequestParam String name, @RequestParam String message) {
        feedbackList.add(new Feedback(name, message));
        return "redirect:/";
    }
}
