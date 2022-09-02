package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/{id}/addIns")
    private String newInstructor(@PathVariable Long id, Model model) {
        model.addAttribute("newInstructor", new Instructor());
        model.addAttribute("comId", id);
        return "instructors/addInstructor";

    }


    @PostMapping("/{id}/save")
    private String saveInstructor(@ModelAttribute("newInstructor") Instructor instructor,
                           @PathVariable Long id) {
        instructorService.saveInstructor(id, instructor);
        return "redirect:/courses/courses/ " + id;
    }

    @GetMapping("/edit/{id}")
    private String editInstructor(@PathVariable("id") Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("ins", instructor);
        model.addAttribute("comId", instructor.getCompany().getId());
        return "instructors/updateInstructor";
    }


    @PostMapping("/{id}/{comId}/update")
    private String updateInstructor(@PathVariable("id") Long id,
                             @PathVariable("comId") Long comId,
                             @ModelAttribute("ins") Instructor instructor) {
        System.out.println("!!!");
        instructorService.updateInstructor(id, instructor);
        System.out.println("~~~~~~~~~Update INSTRUCTOR done~~~~~~~~~~~~");
        return "redirect:/courses/courses/ " + comId;

    }

    @PostMapping("/{id}/{compId}")
    private String deleteInstructor(@PathVariable("id") Long id,
                             @PathVariable("compId") Long compId) {
        instructorService.deleteInstructor(id);
        return "redirect:/courses/courses/ " + compId;
    }
}
