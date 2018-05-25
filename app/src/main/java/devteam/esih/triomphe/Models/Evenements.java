package devteam.esih.triomphe.Models;

import java.io.Serializable;

public class Evenements implements Serializable {

    private String ev_title;
    private String ev_detail;
    private String ev_price;
    private String ev_date;
    private String ev_hour;
    private String created;
    private String objectId;
    private String ev_room;
    private String ev_img;
    private String ev_fullDetail;

    public Evenements() {

    }

    public Evenements(String ev_title, String ev_detail, String ev_price, String ev_date, String ev_hour) {
        this.ev_title = ev_title;
        this.ev_detail = ev_detail;
        this.ev_price = ev_price;
        this.ev_date = ev_date;
        this.ev_hour = ev_hour;
    }

    public Evenements(String ev_title, String ev_detail, String ev_price, String ev_date, String ev_hour, String objectID) {
        this.ev_title = ev_title;
        this.ev_detail = ev_detail;
        this.ev_price = ev_price;
        this.ev_date = ev_date;
        this.ev_hour = ev_hour;
        this.objectId = objectID;
    }

    public String getEv_title() {
        return ev_title;
    }

    public void setEv_title(String ev_title) {
        this.ev_title = ev_title;
    }

    public String getEv_detail() {
        return ev_detail;
    }

    public void setEv_detail(String ev_detail) {
        this.ev_detail = ev_detail;
    }

    public String getEv_price() {
        return ev_price;
    }

    public void setEv_price(String ev_price) {
        this.ev_price = ev_price;
    }

    public String getEv_date() {
        return ev_date;
    }

    public void setEv_date(String ev_date) {
        this.ev_date = ev_date;
    }

    public String getEv_hour() {
        return ev_hour;
    }

    public void setEv_hour(String ev_hour) {
        this.ev_hour = ev_hour;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEv_room() {
        return ev_room;
    }

    public void setEv_room(String ev_room) {
        this.ev_room = ev_room;
    }

    public String getEv_img() {
        return ev_img;
    }

    public void setEv_img(String ev_img) {
        this.ev_img = ev_img;
    }

    public String getEv_fullDetail() {
        return ev_fullDetail;
    }

    public void setEv_fullDetail(String ev_fullDetail) {
        this.ev_fullDetail = ev_fullDetail;
    }
}
