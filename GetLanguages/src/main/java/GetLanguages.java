import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;

public class GetLanguages {
    /*  Configure the local environment:
    * Set the TRANSLATOR_TEXT_ENDPOINT environment variable on your local
    * machine using the appropriate method for your preferred shell (Bash,
    * PowerShell, Command Prompt, etc.). 
    *
    * If the environment variable is created after the application is launched
    * in a console or with Visual Studio, the shell (or Visual Studio) needs to be
    * closed and reloaded to take the environment variable into account.
    */
    private static String subscriptionKey = System.getenv("TRANSLATOR_TEXT_SUBSCRIPTION_KEY");
    private static String endpoint = System.getenv("TRANSLATOR_TEXT_ENDPOINT");
    String url = endpoint + "/languages?api-version=3.0";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a GET request.
    public String Get() throws IOException {
        Request request = new Request.Builder()
                .url(url).get()
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // This function prettifies the json response.
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }
    public static void main(String[] args) {
        try {
            GetLanguages getLanguagesRequest = new GetLanguages();
            String response = getLanguagesRequest.Get();
            System.out.println(prettify(response));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
