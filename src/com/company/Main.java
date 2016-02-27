package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        UserPreference userPreference = new UserPreference();
        String location = "C:\\IdeaProjects\\DATASCIENCE1-PART1\\src\\com\\company\\userItem.data";
        Map readFile = userPreference.readFile(location);
        System.out.printf("File: %s %n", readFile);
    }
}
