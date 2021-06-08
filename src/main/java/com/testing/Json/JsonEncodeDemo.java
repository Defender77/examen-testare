package com.testing.Json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonEncodeDemo {
    public static void main(String[] args) {
//     ******vyvod NE po poreadku*******
        JSONObject objG = new JSONObject();
        JSONArray listG = new JSONArray();

        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        JSONObject obj2 = new JSONObject();

        obj2.put("name", "foo1");
        obj2.put("num", 1000);
        obj2.put("balance", 2222.2);
        obj2.put("is_vip", true);

        JSONArray list2 = new JSONArray();
        list2.add("msg 1");
        list2.add("msg 2");
        list2.add("msg 3");

        obj2.put("messages", list2);

        listG.add(obj);
        listG.add(obj2);
        objG.put("clients",listG);


        System.out.println(obj);
        System.out.println(obj2);
        System.out.println("Final");
        System.out.print(objG);
//     ******vyvod  po poreadku*******
//        Map<Object, Object> map = new LinkedHashMap<>();
//        map.put("name", "foo");
//        map.put("is_vip", new Boolean(true));
//        map.put("num", new Integer(100));
//        map.put("balance", 1000.21);
//
//
//        JSONObject obj = new JSONObject();
//        System.out.print(obj.toJSONString(map));


    }
}
