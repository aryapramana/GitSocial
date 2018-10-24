package com.software.tempe.gitsocial.model;

import java.util.List;

public class UserList {
    private int total_count;
    private List<User> items;

    public UserList() {

    }

    public UserList(int total_count, List<User> items) {
        this.total_count = total_count;
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
