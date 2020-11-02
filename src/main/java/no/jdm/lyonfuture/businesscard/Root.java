package no.jdm.lyonfuture.businesscard;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "root")
public class Root {
    @XmlElement
    private List<BusinessCard> businesscard;
    @XmlElement
    private String version;
    @XmlElement
    private String creationdt;
}
