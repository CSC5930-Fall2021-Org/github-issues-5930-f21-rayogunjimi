import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import edu.studio.issue.User;
import edu.studio.issue.Issue;

class IssueTest {

    @Test
    void testGetAndSetNumber() {
        Issue issueA = new Issue();
        issueA.setNumber(99);

        assertEquals(issueA.getNumber(), 99);
    }

    @Test
    void testGetAndSetState() {
        Issue issueA = new Issue();
        issueA.setState("closed");
        assertEquals(issueA.getState(), "closed");
    }

    @Test
    void testGetAndSetTitle() {
        Issue issueA = new Issue();
        issueA.setTitle("Example issue title");

        assertEquals(issueA.getTitle(), "Example issue title");
    }

    @Test
    void testGetAndSetBody() {
        Issue issueA = new Issue();
        issueA.setBody("Example issue body");

        assertEquals(issueA.getBody(), "Example issue body");
    }

    @Test
    void testGetAndSetAssignee() {
        Issue issueA = new Issue();
        User testUser = new User();
        issueA.setAssignee(testUser);

        assertEquals(issueA.getAssignee(), testUser);
    }

    @Test
    void testGetAndSetUser() {
        Issue issueA = new Issue();
        User testUser = new User();
        issueA.setUser(testUser);

        assertEquals(issueA.getUser(), testUser);
    }

    @Test
    void testGetAndSetClosedAt() {
        Issue issueA = new Issue();
        Date today = new Date();

        issueA.setClosedAt(today);

        assertEquals(issueA.getClosedAt(), today);
    }

    @Test
    void testGetAndSetCreatedAt() {
        Issue issueA = new Issue();
        Date today = new Date();

        issueA.setCreatedAt(today);

        assertEquals(issueA.getCreatedAt(), today);
    }

    @Test
    void testHashCode() {
        Issue issueA = new Issue();
        issueA.setId(55);

        Issue issueB = new Issue();
        issueB.setId(55);

        assertEquals(issueA, issueB);
        assertEquals(issueA.hashCode(), issueB.hashCode());
    }

    @Test
    void testIssueForCreator() {
        Issue issueA = new Issue();
        issueA.setId(99L);

        User userA = new User();
        userA.setId(42);

        issueA.setUser(userA);

        assertEquals(userA, issueA.getUser());
    }

    @Test
    void testEqualsIsValueEquality() {
        User userA = new User();
        userA.setId(55);

        Issue issueA = new Issue();
        issueA.setId(55);

        assertEquals(issueA.equals(userA), false);
    }

    @Test
    void testEqualsIsValueNotEquality() {
        Issue issueA = new Issue();
        issueA.setId(55);

        assertEquals(issueA.equals(issueA), true);
    }

    @Test
    void testEqualsIsValueNull() {
        Issue issueA = new Issue();
        issueA.setId(55);

        assertEquals(issueA.equals(null), false);
    }

    @Test
    void testCompareToWhenFirstIsBigger() {
        Issue issueA = new Issue();
        issueA.setId(90);

        Issue issueB = new Issue();
        issueB.setId(55);

        assertEquals(issueA.compareTo(issueB), 1);
    }

    @Test
    void testCompareToWhenSecondIsBigger() {
        Issue issueA = new Issue();
        issueA.setId(55);

        Issue issueB = new Issue();
        issueB.setId(90);

        assertEquals(issueA.compareTo(issueB), -1);
    }

    @Test
    void testCompareToWhenEqual() {
        Issue issueA = new Issue();
        issueA.setId(10);

        Issue issueB = new Issue();
        issueB.setId(10);

        assertEquals(issueA.compareTo(issueB), 0);
        // assertEquals(userA, userB);
        assertEquals(issueA.hashCode(), issueB.hashCode());
    }

    @Test
    void testToString() {
        Issue issueA = new Issue();
        Date dateA = new Date();
        User userA = new User();
        issueA.setNumber(99);
        issueA.setId(55);
        issueA.setTitle("Issue title");
        issueA.setBody("Issue body");
        issueA.setCreatedAt(dateA);
        issueA.setClosedAt(dateA);
        issueA.setUser(userA);
        issueA.setAssignee(userA);
        issueA.setState("closed");

        assertEquals(issueA.toString(),
                "{number=" + 99 + ";id=" + 55 + ";title=" + "Issue title" + ";body=" + "Issue body" + ";createdAt="
                        + dateA.toString() + ";closedAt=" + dateA.toString() + ";user=" + userA.toString()
                        + ";assignee=" + userA.toString() + ";state=" + "closed" + ";}");
    }
}
