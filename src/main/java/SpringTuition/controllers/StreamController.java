package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import SpringTuition.service.StreamService;
import SpringTuition.models.Stream;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StreamController {
    @Autowired
    StreamService streamService;

    @GetMapping("/streams")
    public List<Stream> getAllStreams() {
        return streamService.getAllStreams();
    }

    @GetMapping("/stream/{id}")
    public Stream getStream(@PathVariable int id) {
        try {
            return streamService.getStreamById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/streams")
    public void saveStream(@RequestBody Stream t) {
        // generate a id for the collection
        streamService.createStream(t);
    }

    @PutMapping(value = "/stream/{id}")
    public void updateStream(@PathVariable String id, @RequestBody Stream updatedTopic) {
        streamService.updateStream(id, updatedTopic);
    }

    @DeleteMapping(value = "/stream/{id}")
    public Boolean deleteStreamById(@PathVariable String id) {
        return streamService.deleteStream(id);
    }
}