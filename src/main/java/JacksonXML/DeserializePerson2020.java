package JacksonXML;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class DeserializePerson2020 {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("person21.xml");

        PersonClass person = xmlMapper.readValue(file,PersonClass.class);
        System.out.println(person.toString());
    }
}
