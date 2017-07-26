package api.org.httpbin;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetResponse extends Response {
    @SerializedName("args")
    @Expose
    public JsonObject args;
}
