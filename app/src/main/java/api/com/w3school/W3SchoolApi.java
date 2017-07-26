package api.com.w3school;

import retrofit2.Call;
import retrofit2.http.GET;

public interface W3SchoolApi {
    @GET("/xml/note.xml")
    Call<TestNoteResponse> getTestNoteXml();
}
