package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

import java.util.List;

    @Controller
    @RequestMapping("/companies")

    public class CompanyController {

        private final CompanyService service;

        @Autowired
        public CompanyController(CompanyService companyService) {
            this.service = companyService;
        }

        @GetMapping()
        private String getAllCompanies(Model model,Long id) {
            List<Company> companies = service.getAllCompanies(id);
            model.addAttribute("companies", companies);
            return "company/companies";
        }


        @GetMapping("/addCompany")
        private String addCompany(Model model) {
            model.addAttribute( "company", new Company());
            return "company/addCompany";
        }

        @PostMapping("/saveCompany")
        private String saveCompany(@ModelAttribute("company") Company company) {
            service.saveCompany(company);
            return "redirect:/companies";
        }


        @GetMapping("/getCompany/{companyId}")
        private String getCompanyById(@PathVariable("companyId") Long id, Model model) {
            model.addAttribute("company", service.getCompanyById(id));
            System.out.println(service.getCompanyById(id));
            return "/innerPage";
        }


        @GetMapping("/edit/{id}")
        private String updateCompany(@PathVariable("id") Long id, Model model) {
            model.addAttribute("company", service.getCompanyById(id));
            return "company/updateCompany";
        }


        @PostMapping("/{id}/update")
        private String saveUpdateCompany(@ModelAttribute("company") Company company) {
            service.updateCompany(company);
            return "redirect:/companies";
        }


        @PostMapping("/{id}")
        private String deleteCompany(@PathVariable("id") Long id) {
            service.deleteCompany(id);
            return "redirect:/companies";
        }
    }
