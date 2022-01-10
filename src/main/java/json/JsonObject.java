package json;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private HashMap<String, Json> pairs = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        for (int i = 0; i < jsonPairs.length; i++) {
            this.pairs.put(jsonPairs[i].key, jsonPairs[i].value);
        }
    }

    @Override
    public String toJson() {
        // ToDo
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        for (Map.Entry<String, Json> pair : pairs.entrySet()) {
            result.append(pair.getKey());
            result.append(": ");
            result.append(pair.getValue().toJson());
            result.append(", ");
        }
        if (result.toString().equals("{ ")) {
            result.append("}");
            return result.toString();
        }
        result.setLength(result.length() - 2);
        result.append("}");
        return result.toString();
    }

    public void add(JsonPair jsonPair) {
        // ToDo
        this.pairs.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        // ToDo
        Json result = this.pairs.get(name);
        return result;
    }

    public JsonObject projection(String... names) {
        // ToDo
        JsonObject result = new JsonObject();
        for (int i = 0; i < names.length; i++) {
            if (this.pairs.containsKey(names[i])) {
                result.add(new JsonPair(names[i], pairs.get(names[i])));
            }
        }
        return result;
    }
}
