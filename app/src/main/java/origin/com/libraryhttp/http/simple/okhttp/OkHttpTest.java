package origin.com.libraryhttp.http.simple.okhttp;

import android.support.annotation.Nullable;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

/**
 * OkHttp
 */
public class OkHttpTest {


    public static void main(String[] args) {
        OkHttpTest test = new OkHttpTest();
//        test.getHttp();
//        test.post1();
//        test.post2();
//        test.post3();
        test.post4();
//        test.interceptor();
    }

    //异步请求
    //请求设置头信息
    private void getHttp() {
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
                System.out.println("response = " + response.body().string());
            }
        });
    }

    /**
     * post 1 提交String
     */
    private void post1() {
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        String url = "https://api.github.com/markdown/raw";

        OkHttpClient okHttpClient = new OkHttpClient();//创建OkHttpClient
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.post(RequestBody.create(mediaType, requestBody));
        Request request = builder.build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("e = " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("response = " + response.body().string());
                System.out.println("response = " + response.protocol() + " " + response.code() + " " + response.message());
            }
        });
    }

    /**
     * post2 提交流
     */
    private void post2() {
        RequestBody requestBody = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown; charset=utf-8");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("I am Jdqm.");
            }
        };

        final Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("request = " + request.body());
                System.out.println("返回 response = " + response.body().string());
            }
        });

    }

    /**
     * 提交文件
     */
    private void post3() {
        final MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        File file = new File("H:/360downloads/test.txt");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(mediaType, file);
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, file))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.protocol() + " " + response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ":" + headers.value(i));
                }
                System.out.println("onResponse: " + response.body().string());
            }
        });
    }

    /**
     * 提交表单
     */
    private void post4() {
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();
        final Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("request url = " + request.url());

                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    System.out.println("request  body ="+ (body.encodedName(i) + ":" + body.encodedValue(i) + ","));
                }


                System.out.println("message = " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ":" + headers.value(i));
                }
                System.out.println();
                System.out.println("onResponse: " + response.body().string());
            }
        });
    }

    /**
     * POST方式提交分块请求
     */
    private void post5() {

    }

    /**
     * 添加拦截器
     */
    private void interceptor() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(new LoggingInterceptor());//添加连接器

        OkHttpClient okHttpClient = clientBuilder.build();
        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                ResponseBody body = response.body();
//                if (body != null) {
//                    System.out.println("onResponse: " + response.body().string());
//                    body.close();
//                }
            }
        });
    }

    //OkHttpClient 拦截器
    class LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long startTime = System.nanoTime();
            System.out.println( String.format("Sending request %s on %s %n %s ",
                    request.url(), chain.connection(), request.headers()));

            Response response =  chain.proceed(request);
            long endTime = System.nanoTime();
            System.out.println(String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (endTime - startTime) / 1e6d, response.headers()));

            return response;
        }
    }
}
