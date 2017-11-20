//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.11.20 à 02:22:00 PM CET 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.spring.guides.gs_producing_web_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.spring.guides.gs_producing_web_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMusicsRequest }
     * 
     */
    public GetMusicsRequest createGetMusicsRequest() {
        return new GetMusicsRequest();
    }

    /**
     * Create an instance of {@link ReturnMusicRequest }
     * 
     */
    public ReturnMusicRequest createReturnMusicRequest() {
        return new ReturnMusicRequest();
    }

    /**
     * Create an instance of {@link SingleMusicResponse }
     * 
     */
    public SingleMusicResponse createSingleMusicResponse() {
        return new SingleMusicResponse();
    }

    /**
     * Create an instance of {@link Music }
     * 
     */
    public Music createMusic() {
        return new Music();
    }

    /**
     * Create an instance of {@link BorrowMusicRequest }
     * 
     */
    public BorrowMusicRequest createBorrowMusicRequest() {
        return new BorrowMusicRequest();
    }

    /**
     * Create an instance of {@link SearchMusicRequest }
     * 
     */
    public SearchMusicRequest createSearchMusicRequest() {
        return new SearchMusicRequest();
    }

    /**
     * Create an instance of {@link GetMusicRequest }
     * 
     */
    public GetMusicRequest createGetMusicRequest() {
        return new GetMusicRequest();
    }

    /**
     * Create an instance of {@link MultipleMusicResponse }
     * 
     */
    public MultipleMusicResponse createMultipleMusicResponse() {
        return new MultipleMusicResponse();
    }

    /**
     * Create an instance of {@link MusicList }
     * 
     */
    public MusicList createMusicList() {
        return new MusicList();
    }

    /**
     * Create an instance of {@link AddMusicRequest }
     * 
     */
    public AddMusicRequest createAddMusicRequest() {
        return new AddMusicRequest();
    }

}
