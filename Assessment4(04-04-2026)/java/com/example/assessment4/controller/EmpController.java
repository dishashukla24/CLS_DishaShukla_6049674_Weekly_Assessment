package com.example.assessment4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assessment4.dto.EmployeeDTO;
import com.example.assessment4.service.EmpService;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "viewall";
    }

    @GetMapping("/edit/{eid}")
    public String editForm(@PathVariable int eid, Model model) {
        EmployeeDTO dto = service.getById(eid);

        model.addAttribute("emp", dto);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveEdit(@Valid @ModelAttribute("emp") EmployeeDTO dto,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        
        service.update(dto);

        model.addAttribute("msg", "Employee Edited Successfully");
        model.addAttribute("emps", service.getAll());

        return "redirect:/viewall";
    }

    @GetMapping("/delete/{eid}")
    public String delete(@PathVariable int eid, Model model) {

        service.delete(eid);

        model.addAttribute("msg", "Employee Deleted Successfully");
        model.addAttribute("emps", service.getAll());

        return "redirect:/viewall";
    }
}