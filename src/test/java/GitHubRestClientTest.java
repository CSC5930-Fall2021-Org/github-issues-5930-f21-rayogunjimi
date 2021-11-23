import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.studio.issue.*;

import java.io.IOException;
import java.nio.file.*;

class GitHubRestClientTest {

    @Test
    void testGetIssues() throws IOException {
        GitHubRestClient client = new GitHubRestClient();
        String token = System.getProperty("bearer.token");
        //System.out.println(token);
        String actualJson = client.getIssues(token);
        String expectedJson = Files.readString(Paths.get("src/test/resources/sample-output.txt"));
        System.out.println(actualJson);
        System.out.println(expectedJson);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testGetStatus200() {
    GitHubRestClient client = new GitHubRestClient();
    String token = System.getProperty("bearer.token");
    int responseStatus = client.getStatus(token);
    assertEquals(responseStatus, 200);
    }

    @Test
    void testGetStatus401() {
    GitHubRestClient client = new GitHubRestClient();
    int responseStatus = client.getStatus(null);
    assertEquals(responseStatus, 401);
    }
}
