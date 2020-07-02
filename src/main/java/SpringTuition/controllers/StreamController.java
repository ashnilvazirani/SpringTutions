package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import SpringTuition.service.StreamService;
import SpringTuition.models.Stream;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// @RestController
@Controller
public class StreamController {
    @Autowired
    StreamService streamService;

    // public List<Stream> getAllStreams() {
    // return streamService.getAllStreams();
    // }
    @PostMapping(value = "/streams/save")
    public String saveStream(@Validated Stream t, Model model) {

        try {
            streamService.createStream(t);
            List<Stream> s = streamService.getAllStreams();
            model.addAttribute("streams", s);
            return "streams/view-stream";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/streams/addNew")
    public String addNewStream(Model model) {
        return "streams/add-stream";
    }

    @GetMapping("/streams")
    public String getAllStreams(Model model) {
        List<Stream> s = streamService.getAllStreams();
        model.addAttribute("streams", s);
        return "streams/view-stream";
    }

    @GetMapping("/stream/{id}")
    public Stream getStream(@PathVariable String id) {
        try {
            return streamService.getStreamById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/stream/edit/{id}")
    public String getAllStreams(@PathVariable String id, Model model) {
        Stream s = streamService.getStreamById(id);
        model.addAttribute("stream", s);
        return "streams/edit-stream";
    }

    @PostMapping(value = "/stream/edit/{id}")
    public String updateStream(@PathVariable String id, @Validated Stream updatedTopic, Model model) {
        streamService.updateStream(id, updatedTopic);
        return "redirect:../../streams";
    }

    @GetMapping(value = "/stream/delete/{id}")
    public String deleteStreamById(@PathVariable String id, Model model) {
        streamService.deleteStream(id);
        // Stream s = streamService.getStreamById(id);
        // model.addAttribute("stream", s);
        return "redirect:../../streams";
    }

    // @DeleteMapping(value = "/stream/delete/{id}")
    // public Boolean deleteStreamById(@PathVariable String id) {
    // return streamService.deleteStream(id);
    // }
}