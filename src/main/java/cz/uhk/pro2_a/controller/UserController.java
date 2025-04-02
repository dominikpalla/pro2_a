package cz.uhk.pro2_a.controller;

import cz.uhk.pro2_a.model.User;
import cz.uhk.pro2_a.repository.UserRepository;
import cz.uhk.pro2_a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.getUser(id));
        return "users_detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.getUser(id));
        return "users_delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteConfirm(Model model, @PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/users/";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "users_add";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }

}
