package XStreamJSon;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import java.io.Writer;

public class SerialProd {
    public static void main(String[] args) {
        Product product = new Product("Banana", "123", 23.00);
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
//        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
//        XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
//            public HierarchicalStreamWriter createWriter(Writer writer) {
//                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
//            }
//        });
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("Product", Product.class);

        System.out.println(xstream.toXML(product));

//        String json = "{\"product\":{\"name\":\"Banana\",\"id\":123"
//                + ",\"price\":23.0}}";
//
//        XStream xstream = new XStream(new JettisonMappedXmlDriver());
//        xstream.alias("product", Product.class);
//        Product product = (Product)xstream.fromXML(json);
//        System.out.println(product.getPrice());
    }

}
