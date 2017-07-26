package api.org.httpbin;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpBinOrgApi {
    @GET("/get")
    Call<GetResponse> getResponse(@Query("test_query_key") String myName);

    @POST("/post")
    Call<PostResponse> postResponse(@Body String postBody);

    @POST("/post")
    Call<PostResponse> postResponse(@Body HashMap<String, String> postBody);

    @POST("/post")
    Call<PostResponse> postResponse(@Body JsonObject jsonObject);
}
