package com.goit.sb_mvc.controlers;

import com.goit.sb_mvc.model.Note;
import com.goit.sb_mvc.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class TestController {
    @RequestMapping("/test")
    public ModelAndView getTest(){
        NoteService noteService = new NoteService();
        List<Note> notes = noteService.listAll();
        log.info(String.valueOf(notes.isEmpty()));
        return new ModelAndView("test").addObject("notes", notes);
}
}
