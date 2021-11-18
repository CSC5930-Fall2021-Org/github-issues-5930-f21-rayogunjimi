import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import edu.studio.issue.Issue;
import edu.studio.issue.User;

class IssueTest {

    @Test
    void testProperties() {
        Issue issue = new Issue();
        issue.setId(99L);
        assertEquals(99, issue.getId());
        
        Date now = new Date();
        issue.setCreatedAt(now);
        assertEquals(now, issue.getCreatedAt());
    }

    @Test
    void testUserForCreator() {
        Issue issue = new Issue();
        issue.setId(99L);
        
        User user = new User();
        user.setId(42);
        
        issue.setUser(user);
        
        assertEquals(user, issue.getUser());
    }
}