package edu.studio.issue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    Gson gson;


    public IssueParser() {
        gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public List<Issue> parseIssues(String jsonContent) {
        //System.out.println(jsonContent);
        if (jsonContent != null && !jsonContent.isEmpty()) {
            List<Issue> issues = new ArrayList<Issue>();
            Type collectionType = new TypeToken<List<Issue>>(){}.getType();
            // issues = 
            System.out.print(gson.fromJson(jsonContent, collectionType).toString());
            return issues;
        }
        return null;
    }
}