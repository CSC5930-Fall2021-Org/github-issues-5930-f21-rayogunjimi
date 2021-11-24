package edu.studio.issue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueExporter {
    final Gson gson;
    final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static String argPAT;

    public static void main(String[] args) {
        argPAT = args[0];
    }

    public IssueExporter() {
        this.gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
/*
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
*/

    public String startREST() {
        String PAT = null;
        if(argPAT == null) {
            PAT = System.getProperty("bearer.token");
        }
        else {
            PAT = argPAT;
        }
        GitHubRestClient newClient = new GitHubRestClient();
        return newClient.getIssues(PAT);
    }

    public List<Issue> issueLister() {
        String jsonContent = startREST();
        IssueParser myIssueParser = new IssueParser();
        List<Issue> issues = myIssueParser.parseIssues(jsonContent);
        return issues;
    }

    public void issuesToFile() throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);

        List<Issue> issueList = issueLister();
        File new_file = new File("actual-issues.txt");
        BufferedWriter issueWriter = new BufferedWriter(new FileWriter("actual-issues.txt"));
        //if(issueList != null)
        if(issueList.size() != 0) {
            for(int issueCounter = 0; issueCounter < issueList.size(); issueCounter++) {
                issueWriter.write(issueList.get(issueCounter).toString());
                issueWriter.newLine();
            }
        }
        else {
            issueWriter.write("");
        }
        issueWriter.close();
    }

}
