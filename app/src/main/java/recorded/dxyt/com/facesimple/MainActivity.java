package recorded.dxyt.com.facesimple;

import android.util.Log;

import com.google.gson.Gson;
import com.ihongqiqu.util.LogUtils;

import recorded.dxyt.com.facesimple.R;
import recorded.dxyt.com.facesimple.base.BaseActivity;
import recorded.dxyt.com.facesimple.bean.TestContacts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static recorded.dxyt.com.facesimple.App.createApiService;

public class MainActivity extends BaseActivity {
    public String TAG="sfsadf";


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initContacts("");
    }

    @Override
    public void updateViews(boolean isRefresh) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }
    public void initContacts(String superCode){
        Call<TestContacts> contactsCall=createApiService().getContacts(superCode);
        contactsCall.enqueue(new Callback<TestContacts>() {
            @Override
            public void onResponse(Call<TestContacts> call, Response<TestContacts> response) {
                TestContacts  testContacts=response.body();
                LogUtils.e(TAG, "onResponse: "+ new Gson().toJson(testContacts));

            }

            @Override
            public void onFailure(Call<TestContacts> call, Throwable t) {

                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });



    }
}
