package pl.sopata.videotaperental.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sopata.videotaperental.dao.VideoCassetteRepo;
import pl.sopata.videotaperental.dao.entity.VideoCassette;

import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id){
        return videoCassetteRepo.findById(id);
    }
}
