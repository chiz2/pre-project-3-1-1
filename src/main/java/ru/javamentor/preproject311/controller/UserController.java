package ru.javamentor.preproject311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject311.model.User;
import ru.javamentor.preproject311.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user")User user) {
        service.addUser(user);
    return "redirect:users";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") Integer id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") @Valid User user, @PathVariable("id") Integer id)  {
        service.updateUser(id, user);
        return "redirect:/users";
    }
}
