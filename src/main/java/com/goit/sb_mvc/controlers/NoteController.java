package com.goit.sb_mvc.controlers;

import com.goit.sb_mvc.model.Note;
import com.goit.sb_mvc.services.NoteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
@Validated
@RequestMapping("/note")
@Controller
public class NoteController {
    @Autowired private NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNote(){
        return new ModelAndView("list").addObject("notes",noteService.listAll()).addObject("newNote",new Note());
    }

    @PostMapping("/delete")
    public RedirectView delete(@NotNull @RequestParam("id")Long id) throws FileNotFoundException {
        noteService.deleteById(id);
        return new RedirectView("list") ;
    }
    @GetMapping("/edit")
    public ModelAndView edit(@NotNull @RequestParam("id")Long id) throws FileNotFoundException {
        return new ModelAndView("edit").addObject("note",noteService.getById(id));
    }
    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note updateNote) throws FileNotFoundException {
        noteService.update(updateNote);
        return "redirect:/note/list";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note newNode) throws FileNotFoundException {
        noteService.add(newNode);
        return "redirect:/note/list";
    }
}
