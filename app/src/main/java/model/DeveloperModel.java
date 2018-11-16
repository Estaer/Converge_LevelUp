package model;

public class DeveloperModel {

    public String username;
    public int profile_pic;
    public String url;

    public DeveloperModel(String username, int profile_pic, String url) {
        this.username = username;
        this.profile_pic = profile_pic;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(int profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
