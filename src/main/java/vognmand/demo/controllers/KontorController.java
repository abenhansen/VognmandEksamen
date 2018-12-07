package vognmand.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vognmand.demo.model.Bruger;
import vognmand.demo.model.BrugerRepository;

import java.util.ArrayList;


@Controller
public class KontorController {

    @Autowired
    private BrugerRepository brugerrepo;


    @GetMapping("/kontorInfo")
    public String kontorInfo (Model model){
        ArrayList<Bruger> all = (ArrayList<Bruger>) brugerrepo.findAll();
        model.addAttribute("brugere", all);
        return "kontorInfo";
    }

    @GetMapping("/kontorInfo/ansatSlet/{id}")
    public String kontorSlet(@PathVariable("id") long id) {
        brugerrepo.deleteById(id);
        return "redirect:/kontorInfo";
    }

}
