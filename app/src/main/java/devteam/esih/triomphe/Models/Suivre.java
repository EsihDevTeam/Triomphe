package devteam.esih.triomphe.Models;

public class Suivre {

    private String objectId;
    private String ev_id;
    private String user_id;

    public Suivre(String objectID, String ev_id, String user_id) {
        this.objectId = objectID;
        this.ev_id = ev_id;
        this.user_id = user_id;
    }

    public Suivre() {
    }

    public String getObjectID() {
        return objectId;
    }

    public void setObjectID(String objectID) {
        this.objectId = objectID;
    }

    public String getEv_id() {
        return ev_id;
    }

    public void setEv_id(String ev_id) {
        this.ev_id = ev_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
