package com.example.ma_cnss_spring_mvc.controller;


import com.example.ma_cnss_spring_mvc.DAO.*;
import com.example.ma_cnss_spring_mvc.entities.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("agent")
public class AgentController {

    final AgentDAO agentDAO;
    final SpecialityDAO specialityDAO;
    final DossierDAO dossierDAO;
    final MedicationDAO medicationDAO;
    final RadioDAO radioDAO;
    final AnalysisDAO analysisDAO;
    final PatientDAO patientDAO;
    @Autowired
    public AgentController(AgentDAO agentDAO, SpecialityDAO specialityDAO, DossierDAO dossierDAO, MedicationDAO medicationDAO, RadioDAO radioDAO, AnalysisDAO analysisDAO, PatientDAO patientDAO) {
        this.agentDAO = agentDAO;
        this.specialityDAO = specialityDAO;
        this.dossierDAO = dossierDAO;
        this.medicationDAO = medicationDAO;
        this.radioDAO = radioDAO;
        this.analysisDAO = analysisDAO;
        this.patientDAO = patientDAO;
    }

    @GetMapping("/login")
    public String login() {
        return "Agent/loginAgent";
    }

    @PostMapping("/login")
    public String loginAgent(@ModelAttribute("agent") AgentEntity agent) {
        AgentEntity agentEntity = agentDAO.findByEmail(agent.getEmail());
        if( agentEntity.getPassword().equals((agent.getPassword()))){

            return "redirect:/agent/dossiers";
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

    @GetMapping("/AddDossier")
    public String getDossier(Model model) {
        List<MedicationEntity> medications = medicationDAO.findAll();
        model.addAttribute("medications", medications);
        List<SpecialityEntity> specialities = specialityDAO.findAll();
        model.addAttribute("specialities", specialities);
        List<RadioEntity> radios = radioDAO.findAll();
        model.addAttribute("radios", radios);
        List<AnalysisEntity> analysis = analysisDAO.findAll();
        model.addAttribute("analysis", analysis);



//        dossierDAO.save(new DossierEntity(1,"waiting",345,s));


        return "Agent/AddDossierAgent";
    }

    @PostMapping("/AddDossier")
    public String AddDossier(@ModelAttribute("dossier") DossierEntity dossier , HttpServletRequest req) {

        double remboursement = 0;

        int mat = Integer.parseInt(req.getParameter("patientId"));
        int spec_number = Integer.parseInt(req.getParameter("spec_number"));
        int med_number = Integer.parseInt(req.getParameter("med_number"));
        int rad_number = Integer.parseInt(req.getParameter("rad_number"));
        int analy_number = Integer.parseInt(req.getParameter("analy_number"));


        //        int speciality = Integer.parseInt(req.getParameter("'speciality'+i"));

        DossierEntity d = new DossierEntity(patientDAO.getByMat(mat).getId(),"waiting",999);


        List<SpecialityEntity> s = new ArrayList<>();
        for (int i=1;i<= spec_number; i++){
            s.add(specialityDAO.findById(Integer.parseInt(req.getParameter("speciality"+i))));
            remboursement+= specialityDAO.findById(Integer.parseInt(req.getParameter("speciality"+i))).getRepayment();
        }
        d.setSpecialities(s);

        if (med_number != 0){
        List<MedicationEntity> medications = new ArrayList<>();
        for (int i=1;i<= med_number; i++){
            medications.add(medicationDAO.findById(Integer.parseInt(req.getParameter("medication"+i))));
            remboursement+= medicationDAO.findById(Integer.parseInt(req.getParameter("medication"+i))).getRepayment();
        }
        d.setMedications(medications);
        }

        if (rad_number != 0){
            List<RadioEntity> radios = new ArrayList<>();
            for (int i=1;i<= rad_number; i++){
                radios.add(radioDAO.findById(Integer.parseInt(req.getParameter("radio"+i))));
            }
            d.setRadios(radios);
        }

        if (analy_number != 0){
            List<AnalysisEntity> analyses = new ArrayList<>();
            for (int i=1;i<= analy_number; i++){
                analyses.add(analysisDAO.findById(Integer.parseInt(req.getParameter("analysis"+i))));
            }
            d.setAnalyses(analyses);
        }
        d.setRepayment(remboursement);

        dossierDAO.save(d);
        return "redirect:/agent/dossiers";
    }

    /*@GetMapping("/{name}")
    public String pri(@PathVariable String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(name);
        return "test";
    }*/


}
