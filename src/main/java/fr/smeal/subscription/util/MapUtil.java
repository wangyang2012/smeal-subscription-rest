package fr.smeal.subscription.util;

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

}

