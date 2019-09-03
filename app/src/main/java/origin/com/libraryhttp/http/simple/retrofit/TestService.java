package origin.com.libraryhttp.http.simple.retrofit;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import origin.com.libraryhttp.MainActivity;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TestService {
    @FormUrlEncoded
    @POST("/api/zm/w/account/postLogin")
    Call<RetrofitTest.User> postLogin(@Field("username") String name, @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/zm/w/account/postLogin")
    Call<ResponseBody> postLoginJson(@Field("username") String name, @Field("password") String password);

    @GET("http://www.wanandroid.com/article/list/{page}/json")
    //测试占位符 {page}当做占位符，而实际运行中会通过@PATH("page")所标注的参数进行替换
    Call<ResponseBody> getPlaceholder(@Path("page") int page);



    @GET("http://www.wanandroid.com/article/list/{page}/json")
        //测试占位符 {page}当做占位符，而实际运行中会通过@PATH("page")所标注的参数进行替换
    Observable<Object> getRxjava(@Path("page") int page);

    @GET("xiaohua.json")
    Observable<List<RetrofitTest.Book>> getData();

}
