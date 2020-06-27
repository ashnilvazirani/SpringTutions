package SpringTuition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import SpringTuition.repository.StreamRepository;
import SpringTuition.models.Stream;

@Service
public class StreamService {
    @Autowired
    StreamRepository streamRepository;

    public List<Stream> getAllStreams() {
        List<Stream> t = new ArrayList<>();
        streamRepository.findAll().forEach(t::add);
        return t;
    }

    public Stream getStreamById(int id) {
        return ((Stream) streamRepository.findById(id).get());
    }

    public Boolean createStream(Stream t) {
        streamRepository.save(t);
        return true;
    }

    public void updateStream(String id, Stream updatedTopic) {
        streamRepository.save(updatedTopic);
    }

    public Boolean deleteStream(String id) {
        try {
            streamRepository.deleteById(Integer.parseInt(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}