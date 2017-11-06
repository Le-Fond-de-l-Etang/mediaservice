package server;

import action.MusicAction;
import beans.MusicEntity;
import converter.MusicConverter;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Endpoint
public class MusicEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private MusicAction musicAction;

    @Autowired
    public MusicEndpoint() {
        this.musicAction = new MusicAction();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchMusicRequest")
    @ResponsePayload
    public SearchMusicResponse getMusic(@RequestPayload SearchMusicRequest request) {
        SearchMusicResponse response = new SearchMusicResponse();
        List<MusicEntity> musicEntityList = musicAction.searchMusics(request.getFilter());
        MusicList musicList1 = new MusicList();
        List<Music> musicList = musicList1.getMusic();

        for (MusicEntity musicEntity : musicEntityList) {
            Music music = MusicConverter.convertEntityToSoap(musicEntity);
            musicList.add(music);
        }


        response.setMusics(musicList1);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMusicRequest")
    @ResponsePayload
    public GetMusicResponse addMusic(@RequestPayload AddMusicRequest request) {
        GetMusicResponse getMusicResponse = new GetMusicResponse();
        MusicEntity musicEntity = new MusicEntity();

        musicEntity.setAuthor(request.getMusic().getAuthor());
        musicEntity.setTitle(request.getMusic().getTitle());
        musicEntity.setAlbum(request.getMusic().getAlbum());
        musicEntity.setIsmn(request.getMusic().getIsmn());

        Music music = new Music();

        Optional<Integer> id = musicAction.addMusic(musicEntity);
        if (id.isPresent()) {
            musicEntity = musicAction.getMusic(id.get()).get();

            music.setAlbum(musicEntity.getAlbum());
            music.setIsmn(musicEntity.getIsmn());
            music.setAuthor(musicEntity.getAuthor());
            music.setTitle(musicEntity.getTitle());

        }
        getMusicResponse.setMusic(music);
        return getMusicResponse;
    }

}
