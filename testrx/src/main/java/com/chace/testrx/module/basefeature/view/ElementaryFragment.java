package com.chace.testrx.module.basefeature.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.chace.testrx.BaseFragment;
import com.chace.testrx.R;
import com.chace.testrx.model.ZBImageInfo;
import com.chace.testrx.module.basefeature.presenter.ElementryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * Created by chacewang on 16/9/23.
 */
public class ElementaryFragment extends BaseFragment implements ElementryViewInterface {

    @BindView(R.id.swipeRefreshLayout)  SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.gridRecyleView)      RecyclerView mRecyclerView;

    private static final String TAG = "ElementaryFragment";

    private ElementryAdapter mAdapter;
    private ElementryPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ElementryAdapter();
        mPresenter = new ElementryPresenter(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_elementary;
    }

    @Override
    protected void initView(View ContentVeiw) {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateStart() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void updateImageView(List<ZBImageInfo> zbImageInfos) {
        Log.i(TAG, "updateImageView: " + zbImageInfos);
        mAdapter.setZBImageInfos(zbImageInfos);
    }

    @Override
    public void updateEnd() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @OnCheckedChanged({R.id.searchRb1, R.id.searchRb2, R.id.searchRb3, R.id.searchRb4})
    void onTagChecked(RadioButton searchRb, boolean checked) {
        if (checked) {
            mPresenter.unSubscribe();
            mAdapter.setZBImageInfos(null);
            mPresenter.updateImageInfos(searchRb.getText().toString());
        }
    }
}
