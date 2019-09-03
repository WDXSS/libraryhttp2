package origin.com.libraryhttp.http.simple.retrofit;

import android.util.Log;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit 学习，最基础的<br/>
 * 测试接口可以在 “玩android” 中找 <br/>
 * <img  src="https://upload-images.jianshu.io/upload_images/944365-ee747d1e331ed5a4.png?imageMogr2/auto-orient/" ></img> <br/>
 * Created by zc on 2018/9/14
 */
public class RetrofitTest {
    private static final String TAG = "RetrofitTest";
    private Retrofit mRetrofit;

    private void initRetrofit() {
        // 根据返回数据的格式和数据解析方式（Json、XML等）定义
        String url = "https://zm.gaiay.net.cn/";
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url);//设置baseUrl
        builder.addConverterFactory(GsonConverterFactory.create());//添加解析 Gson，最终实现自定义
        mRetrofit = builder.build();
    }

    public static void main(String[] args) {
        RetrofitTest test = new RetrofitTest();
        test.initRetrofit();

//        test.test();
//        test.testJson();
//        test.placeholder();
//        test.rxjavaTest();
        test.testRxjava();
    }

    public void test() {
        String name = "13699167136";
        String password = MD5.md5Lower("123456");
        System.out.println("password = " + password);
        TestService service = mRetrofit.create(TestService.class);
        //此处的call 为OkHttpCall
        Call<User> call = service.postLogin(name, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                assert user != null;
                System.out.println("onResponse: " + user.userName);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }

    private void testJson() {
        //自己定义解析类
        TestService service = mRetrofit.create(TestService.class);
        String name = "13699167136";
        String password = MD5.md5Lower("123456");
        System.out.println("password = " + password);
        Call<ResponseBody> call = service.postLoginJson(name, password);
        //Retrofit默认的Call 为ExecutorCallAdapterFactory 的 ExecutorCallbackCall
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //得到的json
                    System.out.println("onResponse ----json : " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    jsonObject.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    /**
     * 占位符测试
     */
    private void placeholder() {
        TestService service = mRetrofit.create(TestService.class);
        Call<ResponseBody> call = service.getPlaceholder(0);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println("response = " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    class User {
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String userName;
    }
    public class Book{
        String title;
        String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


//    private void rxjavaTest(){
//
//        String url = "https://zm.gaiay.net.cn/";
//        Retrofit.Builder builder = new Retrofit.Builder();
//        builder.baseUrl(url);//设置baseUrl
//        builder.addConverterFactory(GsonConverterFactory.create());//添加解析 Gson，最终实现自定义
//        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//
//        Retrofit retrofit  = builder.build();
//
//        TestService service = retrofit.create(TestService.class);
//
//        service.getRxjava(0).subscribeOn(Schedulers.io())
////                .observeOn()
//                .subscribe(new io.reactivex.Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        System.out.println("onSubscribe");
//                    }
//                    @Override
//                    public void onNext(Object o) {
//                        System.out.println("onNext");
//                        System.out.println(o.toString());
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("onComplete");
//                    }
//                });
//    }


    private void testRxjava(){
        String url ="http://api.laifudao.com/open/";
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit = builder.build();
        TestService service = retrofit.create(TestService.class);
        service.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Book>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Book> books) {
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println("book = "+books.get(i).getTitle());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<Book>>() {
//                    @Override
//                    public void accept(List<Book> books) throws Exception {
//                        for (int i = 0; i < books.size(); i++) {
//                            System.out.println("book = "+books.get(i).getTitle());
//                        }
//                    }
//                });


    }
}
