package com.example.ma_cnss_spring_mvc.controller;


import com.example.ma_cnss_spring_mvc.DAO.DossierDAO;
import com.example.ma_cnss_spring_mvc.DAO.PatientDAO;
import com.example.ma_cnss_spring_mvc.entities.DossierEntity;
import com.example.ma_cnss_spring_mvc.entities.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@SessionAttributes("userId")
@Controller
@RequestMapping("client")
public class ClientController {

    final PatientDAO patientDAO;
    final DossierDAO dossierDAO;


    @Autowired
    public ClientController(PatientDAO patientDAO, DossierDAO dossierDAO) {
        this.patientDAO = patientDAO;
        this.dossierDAO = dossierDAO;
    }


    @GetMapping("/login")
    public String login() {
        return "Client/loginClient";
    }

    @PostMapping("/login")
    public String loginClient(@ModelAttribute("client") PatientEntity client, Model model) {
        PatientEntity patientEntity = patientDAO.findByEmail(client.getEmail());
        try {
            if( patientEntity.getPassword().equals((client.getPassword()))){

                model.addAttribute("userId", patientEntity.getId());

                return "redirect:/client/dossiers";
            }else{
                return "Client/loginClient";
            }
        }catch (Exception e){
            return "Client/loginClient";
        }

    }

    @GetMapping ("dossiers")
    public String dossier(Model model){
        List<DossierEntity> dossiers = dossierDAO
                .findAll()
                .stream()
                .filter(dossierEntity -> dossierEntity.getPatientId() == (Integer) model.getAttribute("userId"))
                .collect(Collectors.toList());
        System.out.println(model.getAttribute("userId"));
        model.addAttribute("dossiers", dossiers);

        return "Client/dossiersClient";
    }




}
