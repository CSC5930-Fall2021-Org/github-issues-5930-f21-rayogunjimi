import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.studio.issue.*;

import java.io.IOException;
import java.nio.file.*;

class GitHubRestClientTest {

    @Test
    void testGetIssues() throws IOException {
        GitHubRestClient client = new GitHubRestClient();
        String token = System.getProperty("Bearer.token");
        String actualJson = client.getIssues(token);
        
        String expectedJson = Files.readString(Paths.get("src/test/resources/sample-output.txt"));
        
                assertEquals(expectedJson, actualJson);
    }

}
