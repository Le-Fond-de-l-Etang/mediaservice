//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.11.06 à 01:52:35 PM CET 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="musics" type="{http://spring.io/guides/gs-producing-web-service}musicList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "musics"
})
@XmlRootElement(name = "MultipleMusicResponse")
public class MultipleMusicResponse {

    @XmlElement(required = true)
    protected MusicList musics;

    /**
     * Obtient la valeur de la propriété musics.
     * 
     * @return
     *     possible object is
     *     {@link MusicList }
     *     
     */
    public MusicList getMusics() {
        return musics;
    }

    /**
     * Définit la valeur de la propriété musics.
     * 
     * @param value
     *     allowed object is
     *     {@link MusicList }
     *     
     */
    public void setMusics(MusicList value) {
        this.musics = value;
    }

}
