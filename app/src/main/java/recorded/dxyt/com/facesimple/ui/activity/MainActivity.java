package recorded.dxyt.com.facesimple.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ihongqiqu.util.LogUtils;

import butterknife.OnClick;
import recorded.dxyt.com.facesimple.R;
import recorded.dxyt.com.facesimple.base.BaseActivity;
import recorded.dxyt.com.facesimple.bean.TestContacts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static recorded.dxyt.com.facesimple.App.createApiService;

public class MainActivity extends BaseActivity {
    public String TAG="sfsadf";

    private final int GET_PERMISSION_REQUEST = 100; //权限申请自定义码
    private boolean granted = false;
    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        getPermissions();
        initContacts("");
    }

    @Override
    public void updateViews(boolean isRefresh) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.face_btn)
    public void faceOnClick(){
        startActivity(new Intent(this,CameraActivity.class));
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
    /**
     * 获取权限
     */
    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                //具有权限
                granted = true;
            } else {
                //不具有获取权限，需要进行权限申请
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA}, GET_PERMISSION_REQUEST);
                granted = false;
            }
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_PERMISSION_REQUEST) {
            int size = 0;
            if (grantResults.length >= 1) {
                int writeResult = grantResults[0];
                //读写内存权限
                boolean writeGranted = writeResult == PackageManager.PERMISSION_GRANTED;//读写内存权限
                if (!writeGranted) {
                    size++;
                }
                //录音权限
                int recordPermissionResult = grantResults[1];
                boolean recordPermissionGranted = recordPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!recordPermissionGranted) {
                    size++;
                }
                //相机权限
                int cameraPermissionResult = grantResults[2];
                boolean cameraPermissionGranted = cameraPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!cameraPermissionGranted) {
                    size++;
                }
                if (size == 0) {
                    granted = true;
                } else {
                    Toast.makeText(this, "请到设置-权限管理中开启", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

}
