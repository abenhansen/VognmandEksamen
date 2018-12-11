package vognmand.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vognmand.demo.model.Bruger;
import vognmand.demo.model.BrugerRepository;
import vognmand.demo.model.Opgave;
import vognmand.demo.model.OpgaveRepository;

import java.util.ArrayList;

@Controller
public class OpgaveController {

    @Autowired
    OpgaveRepository opgaverepo;

    @Autowired
    BrugerRepository brugerrepo;

    @GetMapping("/opgaveList")
    public String opgaveList (Model model){
        ArrayList<Opgave> all = (ArrayList<Opgave>) opgaverepo.findAll();
        model.addAttribute("opgaver", all);
        return "opgaveList";
    }

    @GetMapping("/opgaveList/opretOpgave")
    public String courseCreate(Model model) {
        model.addAttribute("opgave", new Opgave());
        model.addAttribute("brugere", brugerrepo.findAll());
        return "opretOpgave";
    }

    @PostMapping("/opgaveList/opretOpgave")
    public String courseCreate(@ModelAttribute Opgave opgave) {
        opgaverepo.save(opgave);
        return "redirect:/opgaveList";
    }



}
