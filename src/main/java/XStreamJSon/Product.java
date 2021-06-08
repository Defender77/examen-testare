package XStreamJSon;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("product")
public class Product {
    private String name;
    private String id;
    private double price;

    public Product(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

}
