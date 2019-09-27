package recorded.dxyt.com.facesimple.weight;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

import static recorded.dxyt.com.facesimple.weight.FaceCj.cutFace;

/**
 * @author admin
 */
public class FaceSDK {
    private static final String TAG = "FaceIdentify";

    public Bitmap DetectionBitmap(Bitmap b) {
        Bitmap bitmap = null;
        Bitmap bitmap1 = null;
        // 检测前必须转化为RGB_565格式。文末有详述连接
        bitmap = b.copy(Bitmap.Config.RGB_565, true);
        b.recycle();
        // 设置你想检测的数量，数值越大错误率越高，所以需要置信度来判断,但有时候置信度也会出问题
        int MAX_FACES = 1;// I found it can detect number of face at least 27,
        FaceDetector faceDet = new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), MAX_FACES);
        // 将人脸数据存储到faceArray中
        FaceDetector.Face[] faceArray = new FaceDetector.Face[MAX_FACES];
        // 返回找到图片中人脸的数量，同时把返回的脸部位置信息放到faceArray中，过程耗时,图片越大耗时越久
        int findFaceNum = faceDet.findFaces(bitmap, faceArray);
        Log.e("tag", "找到脸部数量:" + findFaceNum);
        // 获取传回的第一张脸信息
        FaceDetector.Face face1 = faceArray[0];
        // 获取双眼的中心点，用一个PointF来接收其x、y坐标
        PointF point = new PointF();
        face1.getMidPoint(point);
        // 获取该部位为人脸的可信度，0~1
        float confidence = face1.confidence();
        // 获取双眼的间距
        float eyesDistance = face1.eyesDistance();
        // 传入X则获取到x方向上的角度，传入Y则获取到y方向上的角度，传入Z则获取到z方向上的角度
        float angle = face1.pose(FaceDetector.Face.EULER_X);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(5);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.GREEN);
        Canvas canvas = new Canvas(bitmap);
        PointF pf = new PointF();
        RectF r = new RectF();
        for (FaceDetector.Face face : faceArray) {
            if (face == null) {
                continue;
            }
            face.getMidPoint(pf);
            Log.e("tag", "FaceSDK : DetectionBitmap + " + face.confidence());
            // 这里的框，参数分别是：左上角的X,Y 右下角的X,Y
            // 也就是左上角（r.left,r.top），右下角( r.right,r.bottom)。
            // 该宽度是两眼珠黑色外边距

            float eyesDistance1 = face.eyesDistance();
            r.left = pf.x - eyesDistance1 / 1.2f;
            r.right = pf.x + eyesDistance1 / 1.2f;
            r.top = pf.y - eyesDistance1;
            r.bottom = pf.y + eyesDistance1 * 1.5f;
            Log.d(TAG, r.toString());
            // 画框
//            canvas.drawRect(r, p);

//            bitmap1 = Bitmap.createBitmap(bitmap,  (int)r.left,  (int)r.right-350,  (int)r.left-290,  (int)r.right-590);

            //存储路径
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + "/" + System.currentTimeMillis() + "_xuanzhuan.jpg");
                cutFace(bitmap).compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                System.out.println("saveBmp is here");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cutFace(bitmap);
    }


    public static Bitmap detectionFace(Bitmap b) {
        // 检测前必须转化为RGB_565格式。文末有详述连接
        Bitmap bitmap = b.copy(Bitmap.Config.RGB_565, true);
        b.recycle();
        // 设定最大可查的人脸数量
        int MAX_FACES = 5;
        FaceDetector faceDet = new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), MAX_FACES);
        // 将人脸数据存储到faceArray 中
        FaceDetector.Face[] faceArray = new FaceDetector.Face[MAX_FACES];
        // 返回找到图片中人脸的数量，同时把返回的脸部位置信息放到faceArray中，过程耗时
        int findFaceCount = faceDet.findFaces(bitmap, faceArray);
        // 获取传回的脸部数组中的第一张脸的信息
        FaceDetector.Face face1 = faceArray[0];
        // 获取双眼的中心点，用一个PointF来接收其x、y坐标
        PointF point = new PointF();
        face1.getMidPoint(point);
        // 获取该部位为人脸的可信度，0~1
        float confidence = face1.confidence();
        // 获取双眼间距
        float eyesDistance = face1.eyesDistance();
        // 获取面部姿势
        // 传入X则获取到x方向上的角度，传入Y则获取到y方向上的角度，传入Z则获取到z方向上的角度
        float angle = face1.pose(FaceDetector.Face.EULER_X);

        // todo 在bitmap上绘制一个Rect框住脸，因为返回的是眼睛位置，所以还要做一些处理

        return bitmap;

    }

    /**
     * 根据控件比例剪裁bitmap成一个固定大小的图片
     *
     * @param bitmap     需要裁剪的源图
     * @param num1       宽比例
     * @param num2       高比例
     * @param isRecycled 是否回收
     * @return 裁剪之后的bitmap
     */
    public static Bitmap imageCrop(Bitmap bitmap, float num1, float num2, boolean isRecycled) {
        if (bitmap == null) {
            return null;
        }
//得到bitmap的宽，高

        int w = bitmap.getWidth();

        int h = bitmap.getHeight();

        int retX, retY;//裁剪的起始点

        int nw, nh;//裁剪下来newBitmap的宽和高

        if (w > h) {//宽大于高

            if (h > w * num2 / num1) {//如果跟比例走的话，高符合条件，则保存宽度，截取高

                nw = w;
                nh = (int) (w * num2 / num1);


                retX = 0;
                retY = (h - nh) / 2;
            } else {//如果高达不到比例要求的，则保持高截取宽

                nw = (int) (h * num1 / num2);
                nh = h;
                retX = (w - nw) / 2;
                retY = 0;
            }
        } else {//高大于宽，根据比例宽高比大于1，高肯定符合条件，所以直接截取
            nw = w;
            nh = (int) (w * num2 / num1);
            retX = 0;
            retY = (h - nh) / 2;
        }
        Bitmap bmp = Bitmap.createBitmap(bitmap, retX, retY, nw, nh, null, false);
        if (isRecycled && bitmap != null && !bitmap.equals(bmp) && !bitmap.isRecycled()) {
            bitmap.recycle();//回收原图片
            bitmap = null;
        }
        return bmp;
    }

}
