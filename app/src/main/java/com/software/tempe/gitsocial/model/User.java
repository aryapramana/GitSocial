package com.software.tempe.gitsocial.model;

public class User {
    private String login;
    private String avatar_url;
    private String html_url;

    public User() {

    }

    public User(String login, String avatar_url, String html_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
