package com.example.ma_cnss_spring_mvc.controller;


import com.example.ma_cnss_spring_mvc.DAO.AgentDAO;
import com.example.ma_cnss_spring_mvc.DAO.DossierDAO;
import com.example.ma_cnss_spring_mvc.entities.AgentEntity;
import com.example.ma_cnss_spring_mvc.entities.DossierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("agent")
public class AgentController {

    final AgentDAO agentDAO;
    @Autowired
    public AgentController(AgentDAO agentDAO, DossierDAO dossierDAO) {
        this.agentDAO = agentDAO;
        this.dossierDAO = dossierDAO;
    }
    final
    DossierDAO dossierDAO;

    @GetMapping("/login")
    public String login() {
        return "Agent/loginAgent";
    }

    @PostMapping("/login")
    public String loginAgent(@ModelAttribute("agent") AgentEntity agent) {
        AgentEntity agentEntity = agentDAO.findByEmail(agent.getEmail());
        if( agentEntity.getPassword().equals((agent.getPassword()))){
            return "test";
        }else{
            return "Agent/loginAgent";
        }
    }

    @GetMapping ("dossiers")
    public String dossier(Model model){
        List <DossierEntity> dossiers = dossierDAO.findAll();
        
        model.addAttribute("dossiers", dossiers);

        return "Agent/dossiersAgent";
    }
//    @GetMapping("/list")
//    public String listCustomers(Model theModel) {
//        List < Customer > theCustomers = customerService.getCustomers();
//        theModel.addAttribute("customers", theCustomers);
//        return "list-customers";
//    }





}
