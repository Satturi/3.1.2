package web311.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web311.models.Users;
import web311.service.UsersServiceImpl;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class UsersController {

    private final UsersServiceImpl usersDAO;


    public UsersController(UsersServiceImpl usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", usersDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") Users person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid Users person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        usersDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        usersDAO.update(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersDAO.delete(id);
        return "redirect:/people";
    }
}
