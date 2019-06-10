package fr.smeal.subscription.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilTest {
    @Test
    public void displayMapTest() {
        StringBuilder sb = new StringBuilder();
         Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("name", "client1");
        map.put("age", "18");
        Map<String, Object> mapAddress = new HashMap<String, Object>();
        mapAddress.put("street", "Champs Elyses");
        mapAddress.put("number", "108");
        Map<String, String> mapCity = new HashMap<>();
        mapCity.put("zipcode", "75001");
        mapCity.put("name", "Paris");
        mapAddress.put("city", mapCity);
        map.put("address", mapAddress);
        MapUtil.displayMap(map, sb, null);
        System.out.println(sb.toString());
        }
        }

