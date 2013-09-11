package com.gumtree.tasks.boriero.api.ad;

import com.gumtree.tasks.boriero.api.common.datetime.DateProcessor;

import java.io.Serializable;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long uid;
    private String title;
    private String price;
    private String description;
    private Double lat;
    private Double lon;
    private String location;
    private String image;
    private String postedDate;
    private String displayDate;
    private String emailAddress;
    private String url;
    private String phoneNumber;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setImage(String name) {
        this.image = name;
    }

    public String getImage() {
        return image;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDisplayDate() {
        return new DateProcessor().format( postedDate );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ad ad = (Ad) o;
        if (uid != null ? !uid.equals( ad.uid ) : ad.uid != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return uid != null ? uid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ad{" + "uid=" + uid + ", description=" + description
               + ", lat=" + lat + ", lon=" + lon + ", image=" + getImage() + ", postedDate='" + postedDate + "}";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
