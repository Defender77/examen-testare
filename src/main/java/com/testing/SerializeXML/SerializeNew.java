//https://www.baeldung.com/xstream-serialize-object-to-xml
package com.testing.SerializeXML;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SerializeNew {
    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.processAnnotations(Customer.class); // trigger annotation for class Customer, for more alias
        xstream.addImplicitCollection(Customer.class, "contactDetailsList");//no level ContactsDetails
        xstream.registerConverter(new DateConverter("dd-MM-yyyy", null)); // convertor
//        xstream.aliasField("fn", Customer.class, "firstName");
//        xstream.aliasField("LN", Customer.class, "lastName");
        Customer customer = new Customer("John", "Doe", new Date());

        List<ContactDetails> list = new ArrayList<>();
        list.add(new ContactDetails("212121", "46456"));
        list.add(new ContactDetails("5656", "46447474"));
        customer.setContactDetailsList(list);
        String dataXml = xstream.toXML(customer);

        System.out.println(dataXml);

    }

}
