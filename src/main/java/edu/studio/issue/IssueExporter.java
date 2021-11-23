package edu.studio.issue;

// import edu.studio.issue.GitHubRestClient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueExporter {
    public IssueExporter() {
    }

    public String readStdin() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String PAT = "";
        try {
            System.out.println("Please enter your Personal Access Token");
            PAT = br.readLine();
            if (PAT == "") {
                System.out.println("Invalid token. Please try again.");
                return readStdin();
            }
            else if (PAT == "stop") {
                return null;
            }
            else {
                return PAT;
            }
        }
        catch (IOException ioe) {
            System.out.println("Invalid token. IO Exception was thrown");
        }
        return null;
    }

    public String startREST() {
        String PAT = readStdin();
        GitHubRestClient newClient = new GitHubRestClient();
        return newClient.getIssues(PAT);
    }

    public List<Issue> issueLister() {
        String jsonContent = startREST();
        List<Issue> issues = new ArrayList<Issue>();
        if (jsonContent != null && !jsonContent.isEmpty()) {
            Type collectionType = new TypeToken<List<Issue>>() {}.getType();
            final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            Gson gson = new GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            issues = gson.fromJson(jsonContent, collectionType);
        }
        return issues;
    }

    public void issuesToFile() throws IOException {
        List<Issue> issueList = issueLister();
        BufferedWriter issueWriter = new BufferedWriter(new FileWriter("actual-issues.txt"));
        for(int issueCounter = 0; issueCounter < issueList.size(); issueCounter++) {
            issueWriter.write(issueList.get(issueCounter).toString());
            issueWriter.newLine();
        }
        issueWriter.close();
    }

}
