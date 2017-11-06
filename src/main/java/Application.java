import action.MusicAction;
import beans.MusicEntity;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MusicAction musicAction = new MusicAction();
        MusicEntity newMusic = new MusicEntity("1", "Money for nothing", "Dire Straits", "Brothers in arms");

        String filter = "dire straits";
        List<MusicEntity> musics = musicAction.searchMusics(filter);
        for(MusicEntity music: musics) {
            System.out.println("Music matching filter " + filter + " : " + music.getTitle());
        }

        System.exit(0);
    }
}
