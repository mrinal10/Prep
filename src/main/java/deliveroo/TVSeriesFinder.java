package deliveroo;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class TvSeries {
    private static final String REST_URL = "https://jsonmock.hackerrank.com/api/tvseries?page=";
    private static double bestSeriesRatingTillNow = 0.0;
    private static String bestSeriesName = "";

    public static String bestInGenre(String genre) {
        int page = 0;
        try {
            return getSeries(genre, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NA";
    }

    public static String getSeries(String genre, int page) throws Exception {
        genre = genre.toLowerCase();
        String response = getResponse(page);
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(response);

        int totalPages = Math.toIntExact((Long)jsonResponse.get("total_pages"));
        JSONArray data = (JSONArray) jsonResponse.get("data");
//        System.out.println("page >>>> " + page);
        for (Object datum : data) {
            JSONObject element = (JSONObject) datum;
//            System.out.println( bestSeriesRatingTillNow + "::" + element);
            String[] itsGenre = ((String) element.get("genre")).split(",");
            Set<String> seriesGenre = new HashSet<>();
            for (String gen : itsGenre) {
                seriesGenre.add(gen.trim().toLowerCase());
            }

            Object obj = element.get("imdb_rating");
            double imdbRating;

            if (obj instanceof Long) imdbRating = Math.toIntExact((Long) obj);
            else imdbRating = (double) (obj);

//            if (seriesGenre.contains(genre)) {
//                System.out.println(bestSeriesRatingTillNow + "::" + element);
//            }

            if (seriesGenre.contains(genre)) {
                String currentSeriesName = (String) element.get("name");
                if (imdbRating > bestSeriesRatingTillNow) {
                    bestSeriesName = currentSeriesName;
                    bestSeriesRatingTillNow = imdbRating;
                } else if (imdbRating == bestSeriesRatingTillNow) {
                    int result = currentSeriesName.compareTo(bestSeriesName);
                    if (result < 0) {
                        bestSeriesName = currentSeriesName;
                    }
                }
            }
        }
        return totalPages==page? bestSeriesName : getSeries(genre, page+1);
    }

    private static String getResponse(int pageNo) throws IOException {

        String newUrl = REST_URL + pageNo;
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

class SolutionTVSeries {
    public static void main(String[] args) throws Exception {
        String result = TvSeries.bestInGenre("History");
        System.out.println(">>>>" + result);
    }
}