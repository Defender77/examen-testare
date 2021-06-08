package com.testing.SerializeXML;
//http://x-stream.github.io/tutorial.html
import com.thoughtworks.xstream.XStream;

public class SerializeXML {
    public static void main(String[] args) {
        XStream xstream = new XStream();
//        XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
//        XStream xstream = new XStream(new StaxDriver()); // does not require XPP3 library starting with Java 6
        xstream.alias("person",Person.class); //pseudonim
        xstream.alias("phonenumber",PhoneNumber.class);

        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));

        String xml = xstream.toXML(joe);
        System.out.println(xml);

        //to Object
        Person newPerson = (Person)xstream.fromXML(xml);
        System.out.println(newPerson);
    }
}
