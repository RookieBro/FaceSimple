package recorded.dxyt.com.facesimple.base;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import recorded.dxyt.com.facesimple.R;
import recorded.dxyt.com.facesimple.utils.SwipeRefreshHelper;
import recorded.dxyt.com.facesimple.weight.EmptyLayout;

public abstract class BaseFragment extends Fragment {
    Unbinder unbinder;
    @Nullable
    @BindView(R.id.empty_layout)
    public EmptyLayout mEmptyLayout;
    /**
     * 刷新控件，注意，资源的ID一定要一样
     */
    @Nullable
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutId(),null);
        unbinder= ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();
    /**
     * 更新视图控件
     */
    public abstract void updateViews(boolean isRefresh);

    @LayoutRes
    public abstract int getLayoutID();

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showToast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showToast(int id){
        Toast.makeText(getContext(),id,Toast.LENGTH_SHORT).show();
    }
    public void showLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
        }
    }
    public void hideLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.hide();
        }
    }
    public void showNetError(final EmptyLayout.OnRetryListener onRetryListener) {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
            mEmptyLayout.setRetryListener(onRetryListener);
        }
    }
    public void finishRefresh() {
        if (mSwipeRefresh != null) {
            mSwipeRefresh.setRefreshing(false);
        }
    }
    /**
     * 初始化下拉刷新
     */
    private void initSwipeRefresh() {
        if (mSwipeRefresh != null) {
            SwipeRefreshHelper.init(mSwipeRefresh, new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    updateViews(true);
                }
            });
        }
    }
    /**
     * 初始化 Toolbar
     *
     * @param toolbar
     * @param homeAsUpEnabled
     * @param title
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        ((BaseActivity)getActivity()).setSupportActionBar(toolbar);
        ((BaseActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, int resTitle) {
        initToolBar(toolbar, homeAsUpEnabled, getString(resTitle));
    }

//    /**
//     * 添加 Fragment
//     *
//     * @param containerViewId
//     * @param fragment
//     */
//    public void addFragment(int containerViewId, android.support.v4.app.Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(containerViewId, fragment);
//        fragmentTransaction.commit();
//    }
//
//    /**
//     * 添加 Fragment
//     *
//     * @param containerViewId
//     * @param fragment
//     */
//    public void addFragment(int containerViewId, android.support.v4.app.Fragment fragment, String tag) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        // 设置tag，不然下面 findFragmentByTag(tag)找不到
//        fragmentTransaction.add(containerViewId, fragment, tag);
//        fragmentTransaction.addToBackStack(tag);
//        fragmentTransaction.commit();
//    }
//
//    /**
//     * 替换 Fragment
//     *
//     * @param containerViewId
//     * @param fragment
//     */
//    public void replaceFragment(int containerViewId, android.support.v4.app.Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(containerViewId, fragment);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
//
//    /**
//     * 替换 Fragment
//     *
//     * @param containerViewId
//     * @param fragment
//     */
//    public void replaceFragment(int containerViewId, android.support.v4.app.Fragment fragment, String tag) {
//        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            // 设置tag
//            fragmentTransaction.replace(containerViewId, fragment, tag);
//            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//            // 这里要设置tag，上面也要设置tag
//            fragmentTransaction.addToBackStack(tag);
//            fragmentTransaction.commit();
//        } else {
//            // 存在则弹出在它上面的所有fragment，并显示对应fragment
//            getSupportFragmentManager().popBackStack(tag, 0);
//        }
//    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
