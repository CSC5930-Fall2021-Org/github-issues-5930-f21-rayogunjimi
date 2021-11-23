import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.studio.issue.Issue;
import edu.studio.issue.User;

class UserTest {

    @Test
    void testGetAndSetId() {
        User userA = new User();
        userA.setId(55);

        assertEquals(userA.getId(), 55);
    }

    @Test
    void testGetAndSetLogin() {
        User userA = new User();
        userA.setLogin(99);

        assertEquals(userA.getLogin(), 99);
    }

    @Test
    void testToString() {
        User userA = new User();
        userA.setLogin(99);
        userA.setId(55);

        assertEquals(userA.toString(), "{login=99;id=55;}");
    }

    @Test
    void testEqualsIsValueEquality() {
        User userA = new User();
        userA.setId(55);

        Issue issueA = new Issue();
        issueA.setId(55);

        assertEquals(userA.equals(issueA), false);
    }

    @Test
    void testEqualsIsValueNotEquality() {
        User userA = new User();
        userA.setId(55);

        assertEquals(userA.equals(userA), true);
    }

    @Test
    void testEqualsIsValueNull() {
        User userA = new User();
        userA.setId(55);

        assertEquals(userA.equals(null), false);
    }

    @Test
    void testHashCode() {
        User userA = new User();
        userA.setId(55);

        User userB = new User();
        userB.setId(55);

        assertEquals(userA, userB);
        assertEquals(userA.hashCode(), userB.hashCode());
    }

    @Test
    void testCompareToWhenFirstIsBigger() {
        User userA = new User();
        userA.setId(90);

        User userB = new User();
        userB.setId(55);

        assertEquals(userA.compareTo(userB), 1);
    }

    @Test
    void testCompareToWhenSecondIsBigger() {
        User userA = new User();
        userA.setId(55);

        User userB = new User();
        userB.setId(90);

        assertEquals(userA.compareTo(userB), -1);
    }

    @Test
    void testCompareToWhenEqual() {
        User userA = new User();
        userA.setId(10);

        User userB = new User();
        userB.setId(10);

        assertEquals(userA.compareTo(userB), 0);
        // assertEquals(userA, userB);
        assertEquals(userA.hashCode(), userB.hashCode());
    }
}
