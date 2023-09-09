package deliveroo;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Result {
    private static final String RESTURL = "https://jsonmock.hackerrank.com/api/food_outlets";
    private static double bestRestaurantRatingTillNow = 0.0;
    private static String answer = "";
    public static String getRelevantFoodOutlets(String city, int maxCost) {
        int page = 0;
        try {
            return getRestaurant(city, page, maxCost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NA";
    }

    public static String getRestaurant(String city, int page, int maxCost) throws Exception {

        String response = getResponsePerPage(RESTURL, page);
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(response);

        int totalPages = Math.toIntExact((Long)jsonResponse.get("total_pages"));
        JSONArray data = (JSONArray) jsonResponse.get("data");
//        System.out.println(data);
        for (int i=0; i<data.size(); i++) {
            JSONObject element = (JSONObject) data.get(i);
            System.out.println( bestRestaurantRatingTillNow + "::" + element);
            int restaurantPrice = Math.toIntExact((Long)element.get("estimated_cost"));
            String restaurantCityName = (String) element.get("city");
            JSONObject rating = (JSONObject) element.get("user_rating");
            Object obj = rating.get("average_rating");
            double restaurantRating = 0.0;

            if(obj instanceof Long) restaurantRating = Math.toIntExact((Long)obj);
            else restaurantRating = (double) (obj);

            if(restaurantPrice <= maxCost && city.equalsIgnoreCase(restaurantCityName)
                    && restaurantRating >= bestRestaurantRatingTillNow) {
                System.out.println( "::" + element);
                answer = (String) element.get("name");
                bestRestaurantRatingTillNow = restaurantRating;
            }
        }
        return totalPages==page? answer : getRestaurant(city, page+1, maxCost);
    }

    public static String getResponsePerPage(String endpoint, int page)
            throws IOException {

        String newUrl = endpoint+"?page="+page;
        URL url = new URL(newUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");

        int status = con.getResponseCode();
        if(status<200 || status>=300) {
            throw new IOException("Error in reading data with status:"+status);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();
        while((response = br.readLine())!=null) {
            sb.append(response);
        }

        br.close();
        con.disconnect();

        return sb.toString();
    }
}

class Solution {
    public static void main(String[] args) throws Exception {
        String result = Result.getRelevantFoodOutlets("Houston", 10);
        System.out.println(">>>>" + result);
    }
}

