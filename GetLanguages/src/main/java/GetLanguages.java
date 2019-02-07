import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;

public class GetLanguages {
    String url = "https://api.cognitive.microsofttranslator.com/languages?api-version=3.0";

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
