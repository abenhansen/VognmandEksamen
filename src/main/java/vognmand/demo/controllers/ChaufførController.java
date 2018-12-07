package vognmand.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vognmand.demo.model.Bruger;
import vognmand.demo.model.BrugerRepository;

import java.util.ArrayList;

@Controller
public class ChaufførController {

    @Autowired
    private BrugerRepository brugerrepo;


    @GetMapping("/ansatInfo")
    public String ansatInfo (Model model){
        ArrayList<Bruger> all = (ArrayList<Bruger>) brugerrepo.findAll();
        model.addAttribute("brugere", all);
        return "ansatInfo";
    }

    @GetMapping("/ansatInfo/opretAnsat")
    public String opretAnsat(Model model) {
        model.addAttribute("bruger", new Bruger());
        return "opretAnsat";
    }

    @PostMapping("/ansatInfo/opretAnsat")
    public String opretAnsat(@ModelAttribute Bruger bruger) {
        brugerrepo.save(bruger);
        return "redirect:../";
    }

    @GetMapping("/ansatInfo/redigerAnsat/{id}")
    public String redigerAnsat(@PathVariable long id, Model model){
        Bruger bruger = brugerrepo.findById(id);
        model.addAttribute("bruger", bruger);
        return "redigerAnsat";

    }

    @PostMapping("/ansatInfo/redigerAnsat")
    public String redigerAnsat(@ModelAttribute Bruger bruger ){
        brugerrepo.save(bruger);
        return "redirect:../";

    }

    @GetMapping("/ansatInfo/ansatSlet/{id}")
    public String ansatSlet(@PathVariable("id") long id) {
        brugerrepo.deleteById(id);
        return "redirect:/ansatInfo";
    }

}
