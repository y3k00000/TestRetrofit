package y3k.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import api.org.httpbin.GetResponse;
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
                    GetResponse httpBinOrgGetTestResponse = httpBinOrg.getResponse("testKeyLord").execute().body();
                    Log.d("HttpOrg", httpBinOrgGetTestResponse==null?"null":httpBinOrgGetTestResponse.args.toString());
                    Log.d("HttpOrg", httpBinOrgGetTestResponse==null?"null":httpBinOrgGetTestResponse.headers.host);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
