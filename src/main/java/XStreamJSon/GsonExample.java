package XStreamJSon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonExample {
    public static void main(String[] args) {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader("staff.json")) {
//            Staff staff = gson.fromJson(reader, Staff.class);
//            System.out.println(staff.toString());
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

            String jsonToString = gson.toJson(jsonElement);
            System.out.println(jsonToString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
