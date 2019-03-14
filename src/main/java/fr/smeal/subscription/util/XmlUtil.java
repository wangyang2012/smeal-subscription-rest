package fr.smeal.subscription.util;

public class XmlUtil {
    public static Integer getIntValue(String xml, String key) {
        return Integer.valueOf(getValue(xml, key));
    }
    public static String getValue(String xml, String key) {
        Integer indexBegin = xml.indexOf("<" + key);
        xml = xml.substring(indexBegin);
        Integer indexOfChevronEnd = xml.indexOf(">") + 1;
        Integer indexOfClosedKey = xml.indexOf("</" + key);
        String value = xml.substring(indexOfChevronEnd, indexOfClosedKey);
        return value;
    }
}
