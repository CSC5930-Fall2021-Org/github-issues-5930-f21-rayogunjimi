import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import edu.studio.issue.IssueExporter;

class IssueExporterTest {

    @Test
    void issueExporterTest() throws IOException {
        IssueExporter issueExport = new IssueExporter();
        //String PAT = System.getProperty("bearer.token");
        //System.setIn(new ByteArrayInputStream(PAT.getBytes()));
        issueExport.issuesToFile();
        String actualOutput = Files.readString(Paths.get("actual-issues.txt"));
        assertNotNull(actualOutput);
    }
}
