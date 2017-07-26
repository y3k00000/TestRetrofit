package api.org.httpbin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpBinOrgApi {
    @GET("/get")
    Call<GetResponse> getResponse(@Query("test_query_key") String myName);
}
