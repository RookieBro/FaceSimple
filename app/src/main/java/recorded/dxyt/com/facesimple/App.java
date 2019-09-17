package recorded.dxyt.com.facesimple;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import recorded.dxyt.com.facesimple.ApiService;
import recorded.dxyt.com.facesimple.BuildConfig;
import recorded.dxyt.com.facesimple.Config;
import recorded.dxyt.com.facesimple.log.LogInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext=getApplicationContext();

        initRetrofit();
    }
        public static Retrofit initRetrofit(){
            OkHttpClient.Builder builder=new OkHttpClient.Builder();

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(new LogInterceptor());
                builder.addInterceptor(logging);
                builder.connectTimeout(20, TimeUnit.SECONDS);//连接 超时时间
                builder.writeTimeout(20,TimeUnit.SECONDS);//写操作 超时时间
                builder.readTimeout(20,TimeUnit.SECONDS);//读操作 超时时间
                builder.retryOnConnectionFailure(true);//错误重连

//                // 添加公共参数拦截器
//                BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
//                        .addHeaderParam("userName","")//添加公共参数
//                        .addHeaderParam("device","")
//                        .build();
//
//                builder.addInterceptor(basicParamsInterceptor);

            }
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();//使用 gson coverter，统一日期请求格式
            return new Retrofit.Builder()
                    .baseUrl(Config.MAIN_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(builder.build())
                    .build();
        }

        /**
         * 创建 RetrofitManage 服务
         *
         * @return ApiService
         */
        public static ApiService createApiService() {
            return initRetrofit().create(ApiService.class);
        }
}
