package edu.studio.issue;

import java.util.Objects;

public class User implements Comparable<Issue>{
    public User() {}

    private long login;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLogin() {
        return login;
    }

    public void setLogin(long login) {
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
    public int compareTo(Issue o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
