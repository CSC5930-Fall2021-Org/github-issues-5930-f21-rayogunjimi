import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.studio.issue.User;

class UserTest {

    @Test
    void testEqualsIsValueEquality() {
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
        
        assertEquals(userA, userB);
        
        assertEquals(userA.hashCode(), userB.hashCode());
    }

}
