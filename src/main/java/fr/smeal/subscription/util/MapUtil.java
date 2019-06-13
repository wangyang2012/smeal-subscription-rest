package fr.smeal.subscription.util;

import java.util.List;
import java.util.Map;

public class MapUtil {


    public static void displayMap(Map<Object, Object> map, StringBuilder sb, Integer depth) {
        if (map == null) {
            return;
        }

        if (depth == null) {
            depth = 0;
        }
        final Integer depthFinal = depth;

        map.forEach((key, value) -> {
            for (int i=0; i<depthFinal; i++) {
                sb.append("\t");
            }
            sb.append(key);
            sb.append(" : ");
            if (value instanceof Map) {
                sb.append("{\n");
                displayMap((Map<Object, Object>)value, sb, depthFinal+1);
                for (int i=0; i<depthFinal; i++) {
                    sb.append("\t");
                }
                sb.append("}");
            } else {
                sb.append(value);
            }
            sb.append("\n");
        });
    }

    public static Integer getCartIdFromMap(Map<Object, Object> map) {
        Map<String, Object> mapObject = (Map<String, Object>) map.get("object");
        Map<String, Object> lines = (Map<String, Object>) mapObject.get("lines");
        List<Map<String, Object>> data = (List<Map<String, Object>>) lines.get("data");
        Map<String, Object> firstData = data.get(0);
        Map<String, Object> metadata = (Map<String, Object>) firstData.get("metadata");
        Integer cartId = Integer.valueOf((String)metadata.get("cartId"));
        return cartId;
    }
}

