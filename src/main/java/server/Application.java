package server;
import action.MusicAction;
import beans.MusicEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication

public class Application {
    public static void main(String[] args) {
        MusicAction musicAction = new MusicAction();
        MusicEntity newMusic = new MusicEntity("1", "Money for nothing", "Dire Straits", "Brothers in arms");
        MusicEntity newMusic1 = new MusicEntity("2", "Money", "Pink Floyd", "The Dark Side of The Moon");



        SpringApplication.run(Application.class, args);

    }
}
