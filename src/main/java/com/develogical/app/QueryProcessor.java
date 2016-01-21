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
        if (query.toLowerCase().contains("which of the following numbers is both a square and a cube")) {
            String[] split = query.split(":")[2].split(",");
            for (String part : split) {
                int value = Integer.parseInt(part.trim());
                double sqrt = Math.sqrt(value);
                double cbrt = Math.cbrt(value);
                if (sqrt % 1 == 0 && cbrt % 1 == 0) {
                    return String.valueOf(value);
                }
            }
            return "";
        }
        if (query.toLowerCase().contains("which of the following numbers are primes")) {
            String[] split = query.split(":")[2].split(",");
            String result = "";
            for (String part : split) {
                int value = Integer.parseInt(part.trim());
                if (isPrime(value)) {
                   if(result.isEmpty()){
                       result += value +"";
                   }else{
                       result += ", "+value;
                   }
                }
            }
                return result;
        }

        if (query.toLowerCase().contains("which of the following numbers")) {
            String[] split = query.split("largest:")[1].split(",");
            List<Integer> integers = new ArrayList<>();
            for (String part : split) {
                integers.add(Integer.valueOf(part.trim()));
            }
            Collections.sort(integers);
            return String.valueOf(integers.get(integers.size() - 1));
        }


        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            String substring = query.substring(query.indexOf("what is ") + "what is ".length());
            String[] split = substring.trim().split("plus");
            return "" + (Integer.valueOf(split[0].trim()) + Integer.valueOf(split[1].trim()));
        }

        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("multiplied")) {
            String substring = query.substring(query.indexOf("what is ") + "what is ".length());
            String[] split = substring.trim().split("multiplied by");
            return "" + (Integer.valueOf(split[0].trim()) * Integer.valueOf(split[1].trim()));
        }

        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("minus")) {
            String substring = query.substring(query.indexOf("what is ") + "what is ".length());
            String[] split = substring.trim().split("multiplied by");
            return "" + (Integer.valueOf(split[0].trim()) - Integer.valueOf(split[1].trim()));
        }

        if (query.toLowerCase().contains("what colour is a banana")) {
            return "yellow";
        }

        if (query.toLowerCase().contains("who played james bond in the film dr no")) {
            return "Sean Connery";
        }


        if (query.toLowerCase().contains("which city is the eiffel tower in")) {
            return "Paris";
        }

        if (query.toLowerCase().contains("what currency did spain use before the euro")) {
            return "Peseta";
        }

        if (query.toLowerCase().contains("who is the prime minister of great britain")) {
            return "David Cameron";
        }


        return "";
    }

    boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
