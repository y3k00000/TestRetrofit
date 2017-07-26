package api.org.httpbin;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetResponse {
    @SerializedName("args")
    @Expose
    public JsonObject args;

    @SerializedName("headers")
    @Expose
    public HttpHeaders headers;

    @SerializedName("origin")
    @Expose
    public String origin;

    @SerializedName("url")
    @Expose
    public String url;

    public static class HttpHeaders {
        @SerializedName("Accept") @Expose public String accept;
        @SerializedName("Accept-Encoding") @Expose public String acceptEncoding;
        @SerializedName("Accept-Language") @Expose public String acceptLanguage;
        @SerializedName("Connection") @Expose public String connection;
        @SerializedName("Cookie") @Expose public String cookie;
        @SerializedName("Host") @Expose public String host;
        @SerializedName("Upgrade-Insecure-Requests") @Expose public String upgradeInsecureRequests;
        @SerializedName("User-Agent") @Expose public String userAgent;
    }
}
