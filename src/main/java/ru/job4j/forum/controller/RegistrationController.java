package ru.job4j.forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        User userInDb = userRepository.findByUsername(user.getUsername());
        if (userInDb != null) {
            model.addAttribute("errorMessage", "Это имя уже занято!");
            return "auth/register";
        }
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}
