package edu.studio.issue;

import kong.unirest.Unirest;

public class GitHubRestClient {

    protected static final String TEST_AREA_URL = "https://api.github.com/repos/CSC5930-Fall2021-Org/ghi-demos-5930f21/issues?state=all";

    public static void main(String[] args) {
        GitHubRestClient demo = new GitHubRestClient();

        demo.requestViaBearerToken(args);
    }

    protected String requestViaBearerToken(String[] args) {
        String responseBody = Unirest.get(TEST_AREA_URL)
                .header("Authorization", "Bearer " + args[0])
                .asString()
                .getBody();

        System.out.println(responseBody);
        return responseBody;
    }

    public String getIssues(String token) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
