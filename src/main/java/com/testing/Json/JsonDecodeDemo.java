package com.testing.Json;

//import jdk.nashorn.internal.ir.WhileNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class JsonDecodeDemo {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String s = "[0," +
                "{\"1\":" +
                        "{\"2\":" +
                                "{\"3\":" +
                                            "{\"4\":[5,{\"6\":7}]" +
                "}}}}]";

          try{
              Object obj = parser.parse(s);
              JSONArray array = (JSONArray) obj;

              System.out.println("The 2nd element of array");
              System.out.println(array.get(1));
              System.out.println();

              JSONObject obj2 = (JSONObject) array.get(1);
              System.out.println("Field \"1\"");
              System.out.println(obj2.get("1"));
////
              JSONObject objN = (JSONObject) obj2.get("1");
              System.out.println("Field \"2\"");
              System.out.println(objN.get("2"));
//
              JSONObject obj3 = (JSONObject) objN.get("2");
              System.out.println("Field \"3\"");
              System.out.println(obj3.get("3"));


              JSONObject obj4 = (JSONObject) obj3.get("3");
              System.out.println("Field \"4\"");
              System.out.println(obj4.get("4"));


//            s = "{}";
//            obj = parser.parse(s);
//            System.out.println(obj);
//
//            s = "[5,]";
//            obj = parser.parse(s);
//            System.out.println(obj);
//
//            s = "[5,,2]";
//            obj = parser.parse(s);
//            System.out.println(obj);
        }catch(ParseException pe) {

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
}
}
