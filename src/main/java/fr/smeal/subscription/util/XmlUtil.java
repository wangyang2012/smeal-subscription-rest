package fr.smeal.subscription.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {

    public static Integer getIntValue(String xml, String key) {
        return Integer.valueOf(getValue(xml, key));
    }

    public static BigDecimal getBigDecimalValue(String xml, String key) {
        return new BigDecimal(getValue(xml, key));
    }

    public static String getValue(String xml, String key) {
        Integer indexBegin = xml.indexOf("<" + key);
        if (indexBegin < 0) {
            return "";
        }
        xml = xml.substring(indexBegin);
        Integer indexOfChevronEnd = xml.indexOf(">") + 1;
        Integer indexOfClosedKey = xml.indexOf("</" + key);
        if (indexOfChevronEnd < 0 || indexOfClosedKey < 0 || indexOfChevronEnd >= indexOfClosedKey) {
            return "";
        }
        return xml.substring(indexOfChevronEnd, indexOfClosedKey);
    }

    public static List<String> getMultiValues(String xml, String key) {
        List<String> values = new ArrayList<String>();
        while(xml.indexOf("<"+key) >= 0) {
            Integer indexBegin = xml.indexOf("<" + key);
            xml = xml.substring(indexBegin);
            Integer indexOfChevronEnd = xml.indexOf(">") + 1;
            Integer indexOfClosedKey = xml.indexOf("</" + key);
            String value = xml.substring(indexOfChevronEnd, indexOfClosedKey);
            values.add(value);
            xml = xml.substring(indexOfClosedKey+1);
        }
        return values;
    }
}
