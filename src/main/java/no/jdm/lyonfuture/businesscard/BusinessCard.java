package no.jdm.lyonfuture.businesscard;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BusinessCard {

    @XmlElement
    private List<Participant> participant;
    @XmlElement
    private List<Entity> entity;
    @XmlElement
    private List<String> doctypeid;

//skal ikke være her, får det ikke til å funke i hierarkiet
    private String scheme;
    private String value;
    private String countrycode;
    private String name;
    private String language;
    private String regdate;
    private String displayname;
    private String deprecated;
    private String id;



    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
