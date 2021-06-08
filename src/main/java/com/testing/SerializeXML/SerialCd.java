package com.testing.SerializeXML;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

public class SerialCd {
    public static void main(String[] args) {

        Cd bj = new Cd("basement_jaxx_singles");

        List order = new ArrayList();
        // adds the same cd twice (two references to the same object)
        order.add(bj);
        order.add(bj);

        // adds itself (cycle)
        order.add(order);

        XStream xstream = new XStream();
        xstream.alias("cd", Cd.class);
        System.out.println(xstream.toXML(order));
    }
}
