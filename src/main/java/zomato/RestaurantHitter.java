package zomato;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class RestaurantHitter {
    private static final String REST_URL = "https://www.zomato.com/uluberia/uluberia-locality-restaurants";
    //"https://www.zomato.com/uluberia/blue-moon-1-uluberia-locality/order";

    public static String getRestaurantResponse() throws IOException {

        try {
            URL url = new URL(REST_URL);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

class SolutionRestaurant {
    public static void main(String[] args) throws Exception {
        String result = RestaurantHitter.getRestaurantResponse();
        System.out.println(">>>>" + result);
    }
}
