package com.testing.SaxSTaxXPath;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
public class StAXQueryDemo {public static void main(String[] args) {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;
    boolean isRequestRollNo = false;

    try {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
                factory.createXMLEventReader(new FileReader("students.xml"));

        String requestedRollNo = "393";

        while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

             switch(event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();

                    if (qName.equalsIgnoreCase("student")) {
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        String rollNo = attributes.next().getValue();

                        if(rollNo.equalsIgnoreCase(requestedRollNo)) {
                            System.out.println("Start Element : student");
                            System.out.println("Roll No : " + rollNo);
                            isRequestRollNo = true;
                        }
                    } else if (qName.equalsIgnoreCase("firstname")) {
                        bFirstName = true;
                    } else if (qName.equalsIgnoreCase("lastname")) {
                        bLastName = true;
                    } else if (qName.equalsIgnoreCase("nickname")) {
                        bNickName = true;
                    }
                    else if (qName.equalsIgnoreCase("marks")) {
                        bMarks = true;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();

                    if(bFirstName && isRequestRollNo) {
                        System.out.println("First Name: " + characters.getData());
                        bFirstName = false;
                    }
                    if(bLastName && isRequestRollNo) {
                        System.out.println("Last Name: " + characters.getData());
                        bLastName = false;
                    }
                    if(bNickName && isRequestRollNo) {
                        System.out.println("Nick Name: " + characters.getData());
                        bNickName = false;
                    }
                    if(bMarks && isRequestRollNo) {
                        System.out.println("Marks: " + characters.getData());
                        bMarks = false;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();

                    if(endElement.getName().getLocalPart().equalsIgnoreCase(
                            "student") && isRequestRollNo) {
                        System.out.println("End Element : student");
                        System.out.println();
                        isRequestRollNo = false;
                    }
                    break;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (XMLStreamException e) {
        e.printStackTrace();
    }
}
}
