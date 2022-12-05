package com.example.ma_cnss_spring_mvc.controller;

import com.example.ma_cnss_spring_mvc.DAO.AdminDAO;
import com.example.ma_cnss_spring_mvc.entities.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController {
    final AdminDAO adminDAO;
    @Autowired
    public AdminController(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @GetMapping("/login")
    public String prii() {
        return "Admin/loginAdmin";
    }


    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute("admin") AdminEntity admin) {
        List<AdminEntity> lst = adminDAO.getAll().stream()
                .filter(staff -> staff.getEmail().equals(admin.getEmail()))
                .collect(Collectors.toList());
        if(lst.size()!= 0 && lst.get(0).getPassword().equals((admin.getPassword()))){
//            return lst.get(0);
            return "test";
        }else{
            return "Admin/loginAdmin";
        }
    }

//    @PostMapping("/login")
//    public String loginAdmin(@ModelAttribute("admin") AdminEntity admin) {
//        adminDAO.getAll();
//        List<AdminEntity> lst = adminDAO.getAll().stream()
//                .filter(staff -> staff.getEmail().equals(admin.getEmail()))
//                .collect(Collectors.toList());
//        if(lst.size()!= 0 && lst.get(0).getPassword().equals((admin.getPassword()))){
////            return lst.get(0);
//            return "test";
//        }else{
//            return "loginAdmin";
//        }
//    }

    @GetMapping("/{name}")
    public String pri(@PathVariable String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(name);
        return "test";
    }
}
