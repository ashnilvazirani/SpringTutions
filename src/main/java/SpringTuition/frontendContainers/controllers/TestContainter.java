package SpringTuition.frontendContainers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringTuition.service.StreamService;
import SpringTuition.models.Stream;

import java.util.List;

@Controller
public class TestContainter {
    @Autowired
    StreamService streamService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("title", "TEST CONTROLLER");
        model.addAttribute("name", name);
        List<Stream> s = streamService.getAllStreams();
        model.addAttribute("streams", s);
        return "streams/add-stream";
        // return "greeting";
    }
}