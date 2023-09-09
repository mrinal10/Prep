package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

class Transaction {
    int id;
    int userId;
    String userName;
    String timestamp;
    String txnType;
    String amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

class TransactionResponse {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Transaction> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
        this.data = data;
    }
}

class Result {

    /*
     * Complete the 'getUserTransaction' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER uid
     *  2. STRING txnType
     *  3. STRING monthYear
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
return null;
    }

    private static List<Transaction> getUserTransaction(int uid, String txnType) throws IOException {

        URL obj = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId="+uid);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            String jsonString = response.toString();

            jsonString = jsonString.substring(jsonString.indexOf("data")+3, jsonString.length() -1);
        } else {
            System.out.println("GET request not worked");
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        getUserTransaction(0, null);
    }

}

