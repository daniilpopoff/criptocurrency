import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {
    public static void main(String[] args) throws IOException {
        // Define the URL for the API request
        String apiUrl = "https://api.polygon.io/v1/open-close/crypto/BTC/USD/2024-02-25?adjusted=true&apiKey=YIgHd1CETmA0ci_vKgNZPh5N7HFPx7ja";

        // Create a URL object with the API URL
        URL url = new URL(apiUrl);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // Print the response
        System.out.println("Response: " + response.toString());

        // Close the connection
        connection.disconnect();
    }
}
