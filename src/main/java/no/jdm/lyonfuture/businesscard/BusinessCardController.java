package no.jdm.lyonfuture.businesscard;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class BusinessCardController {
    List<BusinessCard> businessCards = new ArrayList<BusinessCard>();

        Root root() throws XMLStreamException, IOException {
        InputStream xmlRessource = BusinessCardController.class.getClassLoader().getResourceAsStream("directory-export-business-cards.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlRessource);

        XmlMapper mapper = new XmlMapper();
        Root root = mapper.readValue(xmlStreamReader, Root.class);

        return root;
        // må få root over til businessCards Lista...
        }


    @RequestMapping(value = "/getById/{value}")
    public BusinessCard getBusinessCard(@PathVariable(value = "value") String value) {

        return businessCards.stream().filter(x -> x.getValue().equalsIgnoreCase(value)).collect(Collectors.toList()).get(0);
    }


    @RequestMapping(value = "/searchByName/{name}")
    public List<BusinessCard> searchByName(@PathVariable(value = "name") String name) {

        return businessCards.stream().filter(x -> x.getName().contains(name))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/getByName/{name}")
    public BusinessCard getByName(@PathVariable(value = "name") String name) {

        return businessCards.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }
}
