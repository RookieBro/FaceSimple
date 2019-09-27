package recorded.dxyt.com.facesimple.ui.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;
import recorded.dxyt.com.facesimple.R;
import recorded.dxyt.com.facesimple.base.BaseActivity;
import recorded.dxyt.com.facesimple.utils.UIUtils;
import recorded.dxyt.com.facesimple.weight.FaceSDK;


/**
 * @author admin
 */
public class CameraActivity extends BaseActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.face_simple_btn)
    Button simpleBtn;


    private static final int REQUEST_CODE_CHOOSE = 23;

    private static final int PICK_IMAGE_ALBUM = 0x12;
    private static final int REQUEST_PERMISSION = 0x1000;


    private HandlerThread handlerThread;
    private FaceHandler faceHandler;

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
    public void faceSimoleOnclick() {
//        Matisse.from(CameraActivity.this)
////                        .choose(MimeType.allOf())
//                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG, MimeType.BMP, MimeType.WEBP), true)
//                .countable(true)
//                .capture(true)
//                .captureStrategy(
//                        new CaptureStrategy(true, getString(R.string.file_provider_authorities)))
//                .maxSelectable(9)
////                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
//                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
//                .thumbnailScale(0.85f)
//                .imageEngine(new GlideEngine())
//                .forResult(REQUEST_CODE_CHOOSE);
        openAlbum();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && data != null) {
//            if (requestCode == REQUEST_CODE_CHOOSE) {
//                if (Matisse.obtainResult(data).size() > 0 && Matisse.obtainResult(data).get(0) != null) {
//                    Log.e("MyLog", "图片选择器返回结果Uri>>>：" + Matisse.obtainResult(data));
//                    Log.e("MyLog", "图片选择器返回结果Path>>>：" + Matisse.obtainPathResult(data));
////                    simplePathText.setText(Matisse.obtainPathResult(data).get(0).toString());
//                    path = Matisse.obtainPathResult(data).get(0).toString();
//                } else {
//                    Log.e("MyLog", "图片选择器返回结果Uri>>>：失败");
//                }
//            }
//        }
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == PICK_IMAGE_ALBUM) {
            Uri uri = data.getData();

            if (handlerThread == null) {
                handlerThread = new HandlerThread("face");
                handlerThread.start();
                faceHandler = new FaceHandler(handlerThread.getLooper(), this);
            }
            UIUtils.showProgressDialog(this);
            faceHandler.detect(uri);
            simpleBtn.setEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private static class FaceHandler extends Handler {
        private WeakReference<CameraActivity> viewWeakReference;

        private WeakReference<Uri> uriWeakReference;

        FaceHandler(Looper looper, CameraActivity activity) {
            super(looper);
            this.viewWeakReference = new WeakReference<>(activity);
        }

        void detect(Uri uri) {
            this.uriWeakReference = new WeakReference<>(uri);
            sendEmptyMessage(0);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CameraActivity activity = viewWeakReference.get();
            Uri uri = uriWeakReference.get();
            if (activity == null || uri == null) {
                return;
            }
            // get image path from gallery
            String imagePath = getPath(uri, activity.getContentResolver());
            if (imagePath == null) {
                activity.readGalleryError();
                return;
            }
            activity.beginDetect();
            Log.e("tag", " imagePath :" + imagePath);
            // begin detect
            Bitmap bitmap = new FaceSDK().DetectionBitmap(BitmapFactory.decodeFile(imagePath));
            if (viewWeakReference.get() != null) {
                activity.showResult(bitmap);
            }
        }

        private String getPath(Uri uri, ContentResolver provider) {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = provider.query(uri, projection, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                return null;
            }
            int columnIndex = cursor.getColumnIndex(projection[0]);
            String imagePath = cursor.getString(columnIndex);
            cursor.close();
            return imagePath;
        }

    }

    private void showResult(final Bitmap bitmap) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                UIUtils.closeProgressDialog();
                iv.setImageBitmap(bitmap);
                simpleBtn.setEnabled(true);

            }
        });
    }

    private void readGalleryError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CameraActivity.this, "Something wrong happened when read gallery.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void beginDetect() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    private void openAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_ALBUM);
    }


}
