package origin.com.libraryhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.annotations.BindView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import origin.com.libraryhttp.http.simple.retrofit.RetrofitTest;
import origin.com.libraryhttp.http.simple.retrofit.TestService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text)
    private TextView textviewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRxjava();

    }

    private void testRxjava() {
        String url = "http://api.laifudao.com/open/";
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url);
        builder.addConverterFactory(GsonConverterFactory.create());
        //RxJava2CallAdapterFactory 生产出来 RxJava2CallAdapter---
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit = builder.build();

        //此时 retrofit.create()中的serviceMethod.adapt为 RxJava2CallAdapter，
        TestService service = retrofit.create(TestService.class);
        System.out.println("service = " + service.getClass().getSimpleName());
        //observable 为BodyObservable ; RxJava2CallAdapter 中adapt() 返回 BodyObservable，在CallObservable(call),call 实现调用 call.execute();
        Observable<List<RetrofitTest.Book>> observable = service.getData();
        System.out.println("observable = " + observable.getClass().getSimpleName());

        observable.subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<List<RetrofitTest.Book>>() {
                    @Override
                    public void accept(List<RetrofitTest.Book> books) throws Exception {
                        System.out.println("thread = " + Thread.currentThread().getName());
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println("do next = book = " + books.get(i).getTitle());
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RetrofitTest.Book>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RetrofitTest.Book> books) {
                        System.out.println("onNext thread  = " + Thread.currentThread().getName());
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println("book = " + books.get(i).getTitle());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        getContentResolver();
    }
}
