package fr.smeal.subscription.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Language {
    private Integer id;
    private String name;
    private String isoCode;
    private String locale;
    private String languageCode;
    private Boolean active;
    private Boolean isRtl;
    private String dateFormatLite;
    private String dateFormatFull;

    public Integer getId() {
        return id;
    }

    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    @XmlElement(name = "iso_code")
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getLocale() {
        return locale;
    }

    @XmlElement
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    @XmlElement(name = "language_code")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Boolean getActive() {
        return active;
    }

    @XmlElement
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getRtl() {
        return isRtl;
    }

    @XmlElement(name = "is_rtl")
    public void setRtl(Boolean rtl) {
        isRtl = rtl;
    }

    public String getDateFormatLite() {
        return dateFormatLite;
    }

    @XmlElement(name = "date_format_lite")
    public void setDateFormatLite(String dateFormatLite) {
        this.dateFormatLite = dateFormatLite;
    }

    public String getDateFormatFull() {
        return dateFormatFull;
    }

    @XmlElement(name = "date_format_full")
    public void setDateFormatFull(String dateFormatFull) {
        this.dateFormatFull = dateFormatFull;
    }
}
