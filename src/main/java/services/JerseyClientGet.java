package services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class JerseyClientGet {
    public static void main(String[] args) {
        try {
//
//            Proxy proxy;
//            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress());
            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://dummy.restapiexample.com/api/v1/employees");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}

