package pe.edu.cibertec.t2_daw1_juarez.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.t2_daw1_juarez.entities.User;
import pe.edu.cibertec.t2_daw1_juarez.respository.UserRepository;

@Controller
@AllArgsConstructor
public class UserController {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @GetMapping("signup")
    public String signUpShowForm(Model model) {
        model.addAttribute("usuario", new User());
        return "user/signup";
    }

    @PostMapping("signup")
    public String signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }
}
