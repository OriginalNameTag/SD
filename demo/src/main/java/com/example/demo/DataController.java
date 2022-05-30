package com.example.demo;

import java.util.List;
import java.util.Optional;

import com.example.data.Login;
import com.example.data.User;
import com.example.data.Team;
import com.example.data.Player;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class DataController {

    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/landing";
    }

    @GetMapping("/landing")
    public String landing(Model model){
        return "landing";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("log", new Login());
        return "login";
    }
    
    @PostMapping("/greeting")
    public String greeting(@ModelAttribute Login login, Model model){
        String email = login.getEmail();
        String password = login.getPassword();

        User user = this.userService.getUser(email, password);
        
        
        if (user == null)
            return "landing";

        String name = user.getName();
        model.addAttribute("name", name);
        
        if (user.getAdmin()){
            return "admin_page";
        }
        else if(!user.getAdmin())
            return "user_page";
        
        return "landing";
    }

    @GetMapping("/adminPage")
    public String adminPage(Model model){
        return "admin_page";
    }

    @GetMapping("/registerUser")
    public String games(Model model){
        model.addAttribute("user", new User());
        return "register_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user){
        //works but im tired of adding to database
        //this.userService.addUser(user);
        
        return "save_user";
    }
    
    @GetMapping("/createTeam")
    public String createTeam(Model model){
        model.addAttribute("team", new Team());
        return "create_team";
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@ModelAttribute Team team){
        this.teamService.addTeam(team);
        return "save_team";
    }

    @GetMapping("/createPlayer")
    public String createPlayer(Model model){
        model.addAttribute("player", new Player());
        return "create_player";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player){
        this.playerService.addPlayer(player);
        return "save_team";
    }
}
