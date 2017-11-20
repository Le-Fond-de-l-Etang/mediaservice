package data.converter;

import data.beans.MusicEntity;
import io.spring.guides.gs_producing_web_service.Music;

public class MusicConverter {
    /**
     * Convert a music entity to a SOAP music bean
     * @param musicEntity Entity to convert
     * @return SOAP ready object
     */
    public static Music convertEntityToSoap(MusicEntity musicEntity) {
        Music music = new Music();
        music.setId(musicEntity.getId());
        music.setIsmn(musicEntity.getIsmn());
        music.setTitle(musicEntity.getTitle());
        music.setAuthor(musicEntity.getAuthor());
        music.setAlbum(musicEntity.getAlbum());
        music.setBorrowed(musicEntity.isBorrowed());
        music.setBorrower(musicEntity.getBorrower());
        return music;
    }

    /**
     * Convert a SOAP music bean to a entity used for persistence
     * @param musicSoap Soap object to convert
     * @return Entity to persist
     */
    public static MusicEntity convertSoapToEntity(Music musicSoap) {
        MusicEntity music = new MusicEntity();
        music.setId(musicSoap.getId());
        music.setIsmn(musicSoap.getIsmn());
        music.setTitle(musicSoap.getTitle());
        music.setAuthor(musicSoap.getAuthor());
        music.setAlbum(musicSoap.getAlbum());
        music.setBorrowed(musicSoap.isBorrowed());
        music.setBorrower(musicSoap.getBorrower());
        return music;
    }
}
