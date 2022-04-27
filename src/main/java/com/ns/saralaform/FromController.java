package com.ns.saralaform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class FromController {
    @Autowired
    RegistrationRepo repo;
    @RequestMapping("/")
    public String details(){
        return "registration";
    }

    @RequestMapping("/details")
    public String details(Registeration registeration){
        repo.save(registeration);
        return "registration";
    }
    @RequestMapping("/getdetails")
    public String getDetails(){
        return "customerDetail ";
    }


    @PostMapping("/getdetails")
    public ModelAndView viewDetails(@RequestParam int id){
        ModelAndView mv = new ModelAndView("retriew");

        Registeration registeration = repo.findById(id).orElse(null);
        mv.addObject(registeration);
        return mv;

    }
    // GET
    @RequestMapping("/customers")
    @ResponseBody
    public List<Registeration> getCustomers(){
       return (List<Registeration>) repo.findAll();
    }

    @RequestMapping("/customers/{id}")
    @ResponseBody
    public Optional<Registeration> getCustomeri(@PathVariable("id") int id){
        return repo.findById(id);
    }

    //POST
    @PostMapping("/customers")
    public Registeration getCustomers3(@RequestBody Registeration registeration){
        repo.save(registeration);
        return registeration;
    }

    //DELETE
    @DeleteMapping("/customers/{id}")
    public void getCustomers4(@PathVariable("id") int id){
        repo.deleteById(id);
    }

    //UPDATE
    @PutMapping(path = "/customers", consumes = {"application/json"})
    public void getCustomers4(@RequestBody Registeration registeration){
        repo.save(registeration);
    }


}
