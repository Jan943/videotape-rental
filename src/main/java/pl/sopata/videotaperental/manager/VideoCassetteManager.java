package pl.sopata.videotaperental.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.sopata.videotaperental.dao.VideoCassetteRepo;
import pl.sopata.videotaperental.dao.entity.VideoCassette;

import java.time.LocalDate;
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

    public Iterable<VideoCassette> findAll(){
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette){
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id){
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "Titanic", LocalDate.of(1995,1,1)));
        save(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990,2,2)));
        save(new VideoCassette(3L, "Broadwalk empire", LocalDate.of(2010,3,3)));
        save(new VideoCassette(4L, "Spiderman", LocalDate.of(2015,4,4)));
        save(new VideoCassette(5L, "Batman", LocalDate.of(2011,5,5)));
    }
}
