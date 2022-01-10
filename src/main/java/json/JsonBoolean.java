package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private Boolean bool_value;

    public JsonBoolean(Boolean bool) {
        // ToDo
        this.bool_value = bool;
    }

    @Override
    public String toJson() {
        // ToDo
        if (this.bool_value) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
