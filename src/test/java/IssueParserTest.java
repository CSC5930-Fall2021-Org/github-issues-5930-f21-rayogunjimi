import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.studio.issue.GitHubRestClient;
import edu.studio.issue.Issue;
import edu.studio.issue.IssueParser;

class IssueParserTest {
    @Test
    void testParseIssueWithNullJson() {
        String json = null;
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(json);
        List<Issue> issuesAssert = new ArrayList<Issue>();
        assertEquals(issues,issuesAssert);
    }

    @Test
    void testParseIssueWithValidJson() {
        String PAT = System.getProperty("bearer.token");
        GitHubRestClient newClient = new GitHubRestClient();
        String json = newClient.getIssues(PAT);
        //System.out.println(PAT);
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(json);
        assertNotNull(issues);
        assertEquals(4, issues.size());
        Issue issue0 = issues.get(0);
        assertEquals(1044979109, issue0.getId());
    }
}
