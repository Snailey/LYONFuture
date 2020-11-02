package no.jdm.lyonfuture.businesscard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Id {
    @XmlElement
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlElementWrapper(useWrapping = false)
    private String scheme;
    @XmlElement
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlElementWrapper(useWrapping = false)
    private String value;
}
