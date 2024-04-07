package com.goit.sb_mvc.controlers;

import com.goit.sb_mvc.dao.note.NoteServise;
import com.goit.sb_mvc.exception.IllegalDataNoteExeption;
import com.goit.sb_mvc.model.Note;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
@Validated
@RequestMapping("/note")
@Controller
public class NoteController {
    public static final String REDIRECT_NOTE_LIST = "redirect:/note/list";
    @Autowired private NoteServise noteService;

    @GetMapping("/list")
    public ModelAndView getNote(){
        return new ModelAndView("list").addObject("notes",noteService.listAll()).addObject("newNote",new Note());
    }

    @PostMapping("/delete")
    public String delete(@NotNull @RequestParam("id")Long id) {
        noteService.deleteById(id);
        return REDIRECT_NOTE_LIST;
    }
    @GetMapping("/edit")
    public ModelAndView edit(@NotNull @RequestParam("id")Long id){
        return new ModelAndView("edit").addObject("note",noteService.getById(id));
    }
    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note updateNote) {
        try {
            noteService.update(updateNote);
        } catch (IllegalDataNoteExeption e) {
            return REDIRECT_NOTE_LIST;
        }
        return REDIRECT_NOTE_LIST;
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note newNode)  {
        try {
            noteService.add(newNode);
        } catch (IllegalDataNoteExeption e) {
            return REDIRECT_NOTE_LIST;
        }
        return REDIRECT_NOTE_LIST;
    }
}
