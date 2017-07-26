package y3k.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;

import api.org.httpbin.GetResponse;
import api.org.httpbin.PostResponse;
import api.org.httpbin.Response;
import api.org.httpbin.HttpBinOrgApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://httpbin.org/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    HttpBinOrgApi httpBinOrg = retrofit.create(HttpBinOrgApi.class);
                    GetResponse getResponse = httpBinOrg.getResponse("testKeyLord").execute().body();
                    Log.d("HttpOrg", getResponse==null?"null":getResponse.args.toString());
                    Log.d("HttpOrg", getResponse==null?"null":getResponse.headers.host);
                    PostResponse postResponse = httpBinOrg.postResponse(new JsonParser().parse("{y3k:cool}").getAsJsonObject()).execute().body();
                    Log.d("HttpOrg", postResponse==null?"null":postResponse.json.get("y3k").getAsString());
                    Log.d("HttpOrg", postResponse==null?"null":postResponse.data);
                    Log.d("HttpOrg", postResponse==null?"null":postResponse.form.toString());
                    HashMap<String,String> postBody = new HashMap<>();
                    postBody.put("Retrofit","Good");
                    postResponse = httpBinOrg.postResponse(postBody).execute().body();
                    Log.d("HttpOrg", postResponse==null||postResponse.json==null?"null":postResponse.json.toString());
                    Log.d("HttpOrg", postResponse==null?"null":postResponse.data);
                    Log.d("HttpOrg", postResponse==null?"null":postResponse.form.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
