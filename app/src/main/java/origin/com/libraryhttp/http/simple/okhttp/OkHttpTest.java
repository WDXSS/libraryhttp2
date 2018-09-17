package origin.com.libraryhttp.http.simple.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * OkHttp
 */
public class OkHttpTest {


    public static void main(String[] args) {
        OkHttpTest test = new OkHttpTest();
//        test.enqueueHttp();
        test.post();
    }

    //异步请求
    //请求设置头信息
    private void enqueueHttp() {
        OkHttpClient httpClient = new OkHttpClient();
        String url = "http://wwww.baidu.com";
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.get();//get请求
        final Request request = builder.build();//创建Request




        //此处的Call为OkHttp的Call
        Call call = httpClient.newCall(request);
//        call.execute();同步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("response = "+ response.body().string());
            }
        });
    }

    private void post(){
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        String url = "https://api.github.com/markdown/raw";

        OkHttpClient okHttpClient = new OkHttpClient();//创建OkHttpClient
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.post(RequestBody.create(mediaType,requestBody));
        Request request = builder.build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("e = "+ e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               System.out.println("response = "+ response.body().string());
                System.out.println("response = "+  response.protocol() + " " +response.code() + " " + response.message());
            }
        });
    }

}
