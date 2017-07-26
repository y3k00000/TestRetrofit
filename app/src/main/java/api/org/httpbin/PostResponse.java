package api.org.httpbin;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class PostResponse extends Response {
    @SerializedName("data")
    @Expose
    public String data;

    @SerializedName("form")
    @Expose
    public HashMap<String,String> form = new HashMap<>();

    @SerializedName("json")
    @Expose
    public JsonObject json;
}
