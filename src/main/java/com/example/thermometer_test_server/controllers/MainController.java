package com.example.thermometer_test_server.controllers;

import com.example.thermometer_test_server.models.Post;
import com.example.thermometer_test_server.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Post> posts = postRepository.findAll();

        if (!postRepository.existsById(1L)) {
            //        Save data as object
            Post post = new Post(1L, "0");
            //        Save to the database
            postRepository.save(post);
        }

        Post post1 = postRepository.findById(1L).get();
        String data = post1.getValue() + " градуса";
        model.addAttribute("temperature", data);

        return "main";
    }
//    @GetMapping("/change")
//    public String changeRedirect(Model model){
//        return "redirect:/";
//    }

    @PostMapping("/")
    public String change(@RequestParam String temp, Model model) {

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(temp);

        if (matcher.matches()) {
            if (!postRepository.existsById(1L)) {
                //        Save data as object
                Post post = new Post(1L, "0");
                //        Save to the database
                postRepository.save(post);
            }
            Post post1 = postRepository.findById(1L).get();
            post1.setValue(temp);
            postRepository.save(post1);
            System.out.println("Input contains only numbers");
            System.out.println("Changed to " + temp);
        } else {
            System.out.println("Input contains non-numeric characters");
        }

        String data = temp + " градуса";
        model.addAttribute("temperature", data);
        return "main";
    }
}
