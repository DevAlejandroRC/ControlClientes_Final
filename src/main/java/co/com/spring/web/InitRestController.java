package co.com.spring.web;

import co.com.spring.domain.Person;
import co.com.spring.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InitRestController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String init(Model model, @AuthenticationPrincipal User user){
        
        var persons = personService.listPersons();
        
        log.info("ejecutando controlador Spring MVC");
        log.info("Perfil que hizo login: "+user);        
        model.addAttribute("persons", persons);
        return "index";
    }
    
    @GetMapping("/add")
    public String addPerson(Person person){
        return "modify";
    }
    
    @PostMapping("/save")
    public String save(@Validated Person person, Errors errors){
        if(errors.hasErrors())
            return "modify";
        personService.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{idperson}")
    public String edit(Person person, Model model){
        person = personService.searchByPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/remove")
    public String remove(Person person){
        personService.delete(person);
        return "redirect:/";
    }
    
}
