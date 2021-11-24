package edu.studio.issue;

import java.util.Objects;

public class User implements Comparable<User>{
    public User() {}

    private String login;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return id == other.id;
    }

    @Override
    public int compareTo(User other) {
        int issueStatus = 0;
        if( this.id > other.id) {
            issueStatus = 1;
        }
        else if(this.id < other.id) {
            issueStatus = -1;
        }
        return issueStatus;
    }

    @Override
    public String toString() {
        return "{login=" + login + ";id=" + id + ";}";
    }
}
