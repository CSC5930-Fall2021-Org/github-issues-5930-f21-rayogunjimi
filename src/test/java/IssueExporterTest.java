import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import edu.studio.issue.IssueExporter;

class IssueExporterTest {

    @Test
    void issueExporterTest() throws IOException {
        IssueExporter issueExport = new IssueExporter();
        issueExport.issuesToFile();
        String sampleOutput = Files.readString(Paths.get("src/test/resources/sample-output.txt"));
        String actualOutput = Files.readString(Paths.get("src/test/resources/actual-issues.txt"));
        assertEquals(sampleOutput, actualOutput);
    }
}
