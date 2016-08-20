package raspopova.diana.sunshineapplication.utils;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Diana on 14.08.2016.
 */
public class JsonToUrlencodedConverter {

    public static String convertToUrlEncoded(JsonObject json, String baseURL) {
        StringBuilder result = new StringBuilder();
        result.append(baseURL);
        result.append('?');

        Set<Map.Entry<String, JsonElement>> entries = json.entrySet();
        List<String> keys = new ArrayList<>(entries.size());

        for (Map.Entry<String, JsonElement> entry : entries) {
            keys.add(entry.getKey());
        }

        Collections.sort(keys);
        try {
            boolean first = true;
            for (String key : keys) {
                if (!first) {
                    result.append('&');
                }
                result.append(key);
                result.append('=');
                String value = json.get(key).getAsString();
                result.append(URLEncoder.encode(value, "UTF-8"));
                first = false;
            }
        } catch (Exception ignore) {
        }
        return result.toString();
    }

}