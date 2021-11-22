package edu.studio.issue;

import java.util.Date;
import java.util.Objects;

public class Issue {

    public Issue() {}

    private long number;
    private long id;
    private String title;
    private String body;
    private Date createdAt;
    private Date sclosedAt;
    private User user;
    private User assignee;

    private String state;
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSclosedAt() {
        return sclosedAt;
    }

    public void setSclosedAt(Date sclosedAt) {
        this.sclosedAt = sclosedAt;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date now) {
        this.createdAt = now;
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
        return id == other.getId();
    }

    @Override
    public int compareTo(Issue o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
