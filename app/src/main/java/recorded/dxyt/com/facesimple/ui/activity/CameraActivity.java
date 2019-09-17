package recorded.dxyt.com.facesimple.ui.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.widget.TextView;

import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import butterknife.BindView;
import butterknife.OnClick;
import recorded.dxyt.com.facesimple.R;
import recorded.dxyt.com.facesimple.base.BaseActivity;

import static recorded.dxyt.com.facesimple.Config.REQUEST_CODE_CHOOSE;

public class CameraActivity extends BaseActivity {
    @BindView(R.id.face_simple_path_text)
    TextView simplePathText;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void updateViews(boolean isRefresh) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_camera;
    }

    @OnClick(R.id.face_simple_btn)
    public void faceSimoleOnclick(){
        Matisse.from(CameraActivity.this)
//                        .choose(MimeType.allOf())
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG, MimeType.BMP, MimeType.WEBP), true)
                .countable(true)
                .capture(true)
                .captureStrategy(
                        new CaptureStrategy(true, getString(R.string.file_provider_authorities)))
                .maxSelectable(9)
//                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_CODE_CHOOSE) {
                if (Matisse.obtainResult(data).size() > 0 && Matisse.obtainResult(data).get(0) != null) {
                    Log.e("MyLog", "图片选择器返回结果Uri>>>：" + Matisse.obtainResult(data));
                    Log.e("MyLog", "图片选择器返回结果Path>>>：" + Matisse.obtainPathResult(data));
                    simplePathText.setText(Matisse.obtainPathResult(data).get(0).toString());
//                    Log.e(TAG, "图片选择器返回结果Patch>>>：" + obtainPathResult(data));
//                    startCropActivity(Matisse.obtainResult(data).get(0));
//            Picasso.with(MakeActivity.this).load(Matisse.obtainResult(data).get(0)).resize(PHOTO_MAX_WIDTH, PHOTO_MAX_HEIGHT).onlyScaleDown().centerInside().into(target);
//            Picasso.with(MakeActivity.this).load(new File(Matisse.obtainPathResult(data).get(0))).error(R.drawable.ic_empty_zhihu).resize(540,960).into(target);
                } else {
                    Log.e("MyLog", "图片选择器返回结果Uri>>>：失败");
                }
            }
        }
    }
}
