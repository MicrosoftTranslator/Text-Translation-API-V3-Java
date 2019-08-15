import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;

public class BreakSentence {
    /*  Configure the local environment:
    * Set the TRANSLATOR_TEXT_SUBSCRIPTION_KEY and TRANSLATOR_TEXT_ENDPOINT environment
    * variables on your local machine using the appropriate method for your
    * preferred shell (Bash, PowerShell, Command Prompt, etc.). 
    *
    * For TRANSLATOR_TEXT_ENDPOINT, use the same region you used to get your
    * subscription keys.
    *
    * If the environment variable is created after the application is launched
    * in a console or with Visual Studio, the shell (or Visual Studio) needs to be
    * closed and reloaded to take the environment variable into account.
    */
    private static String subscriptionKey = System.getenv("TRANSLATOR_TEXT_SUBSCRIPTION_KEY");
    private static String endpoint = System.getenv("TRANSLATOR_TEXT_ENDPOINT");
    String url = endpoint + "/breaksentence?api-version=3.0&language=en";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\": \"How are you? I am fine. What did you do today?\"\n}]");
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
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
            BreakSentence breakSentenceRequest = new BreakSentence();
            String response = breakSentenceRequest.Post();
            System.out.println(prettify(response));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
