package recorded.dxyt.com.facesimple.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;

public class GlideUtils {
    /**
     * 默认加载
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageView(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);
    }


    /**
     * 加载指定大小
     * @param mContext
     * @param path
     * @param width
     * @param height
     * @param mImageView
     */
    public static void loadImageViewSize(Context mContext, String path, int width, int height, ImageView mImageView) {
        Glide.with(mContext).load(path).override(width, height).into(mImageView);
    }

    /**
     * 设置加载中以及加载失败图片
     * @param mContext
     * @param path
     * @param mImageView
     * @param lodingImage
     * @param errorImageView
     */
    public static void loadImageViewLoding(Context mContext, String path, ImageView mImageView, int lodingImage, int errorImageView) {
        Glide.with(mContext).load(path).placeholder(lodingImage).error(errorImageView).into(mImageView);
    }

    /**
     * 设置加载中以及加载失败图片并且指定大小
     * @param mContext
     * @param path
     * @param width
     * @param height
     * @param mImageView
     * @param lodingImage
     * @param errorImageView
     */
    public static void loadImageViewLodingSize(Context mContext, String path, int width, int height, ImageView mImageView, int lodingImage, int errorImageView) {
        Glide.with(mContext).load(path).override(width, height).placeholder(lodingImage).error(errorImageView).into(mImageView);
    }

    /**
     * 设置跳过内存缓存
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewCache(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).skipMemoryCache(true).into(mImageView);
    }

    /**
     * 设置下载优先级
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewPriority(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).priority(Priority.NORMAL).into(mImageView);
    }

    /**
     * 设置缓存策略
     * 策略分为：
     *
     * all:缓存源资源和转换后的资源
     * none:不作任何磁盘缓存
     * source:缓存源资源
     * result：缓存转换后的资源
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewDiskCache(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).into(mImageView);
    }

    /**
     * 设置加载动画
     * api也提供了几个常用的动画：比如crossFade()
     * @param mContext
     * @param path
     * @param anim
     * @param mImageView
     */
    public static void loadImageViewAnim(Context mContext, String path, int anim, ImageView mImageView) {
        Glide.with(mContext).load(path).animate(anim).into(mImageView);
    }

    /**
     * 设置缩略图支持
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewThumbnail(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).thumbnail(0.1f).into(mImageView);
    }

    /**
     * 设置动态转换
     * api提供了比如：centerCrop()、fitCenter()等
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewCrop(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).centerCrop().into(mImageView);
    }

    /**
     * 设置动态GIF加载方式
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewDynamicGif(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).asGif().into(mImageView);
    }

    /**
     * 设置静态GIF加载方式
     * @param mContext
     * @param path
     * @param mImageView
     */
    public static void loadImageViewStaticGif(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).asBitmap().into(mImageView);
    }

    /**
     * 设置监听请求接口
     * @param mContext
     * @param path
     * @param mImageView
     * @param requstlistener
     */
    public static void loadImageViewListener(Context mContext, String path, ImageView mImageView, RequestListener<String, GlideDrawable> requstlistener) {
        Glide.with(mContext).load(path).listener(requstlistener).into(mImageView);
    }

    /**
     * 设置要加载的内容
     * 项目中有很多需要先下载图片然后再做一些合成的功能，比如项目中出现的图文混排
     * @param mContext
     * @param path
     * @param simpleTarget
     */
    public static void loadImageViewContent(Context mContext, String path, SimpleTarget<GlideDrawable> simpleTarget) {
        Glide.with(mContext).load(path).centerCrop().into(simpleTarget);
    }

    /**
     * 清理磁盘缓存
     * @param mContext
     */
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }

    /**
     * 清理内存缓存
     * @param mContext
     */
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }
}
