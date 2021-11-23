package edu.studio.issue;

import kong.unirest.Unirest;

public class GitHubRestClient {

    protected static final String TEST_AREA_URL = "https://api.github.com/repos/CSC5930-Fall2021-Org/ghi-demos-5930f21/issues?state=all";

    public static void main(String[] args) {
        GitHubRestClient demo = new GitHubRestClient();
        demo.getIssues(args[0]);
    }

    public String getIssues(String token) {
        String responseBody = Unirest.get(TEST_AREA_URL)
                .header("Authorization", "Bearer " + token)
                .asString()
                .getBody();
        //final String CRLF = "\r\n";
        //responseBody = responseBody.replace(CRLF, " ");
        //System.out.println(responseBody);
        return responseBody;
    }

    public int getStatus(String token) {
        int responseStatus = Unirest.get(TEST_AREA_URL)
                .header("Authorization", "Bearer " + token)
                .asString()
                .getStatus();

        //System.out.println(responseStatus);
        return responseStatus;
    }

}
