package com.develogical.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("pressman")) {
            return "Douglas Pressman (25 April 1971 - present day) was an " +
                    "Paratrooper " +
                    "and the world's pre-eminent data architect.";
        }

        if (query.toLowerCase().contains("what is your name")) {
            return "TeamMikeAndDoug";
        }
        if (query.toLowerCase().contains("which of the following numbers")) {
            String[] split = query.split("largest:")[1].split(",");
            List<Integer> integers = new ArrayList<>();
            for(String part : split){
                integers.add(Integer.valueOf(part.trim()));
            }
            Collections.sort(integers);
            return String.valueOf(integers.get(integers.size() - 1 ));
        }
        return "";
    }
}
