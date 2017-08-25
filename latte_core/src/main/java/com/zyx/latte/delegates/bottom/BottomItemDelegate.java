package com.zyx.latte.delegates.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyx.latte.R;
import com.zyx.latte.delegates.LatteDelegate;

/**
 * Created by zyx on 2017/8/10.
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener{
    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View rootview = getView();
        if (rootview != null){
            rootview.setFocusableInTouchMode(true);
            rootview.requestFocus();
            rootview.setOnKeyListener(this);
        }
    }
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode ==KeyEvent.KEYCODE_BACK&&event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis()-mExitTime)>EXIT_TIME){
                Toast.makeText(getContext(),"双击退出" + getString(R.string.app_name),Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            }else {
                _mActivity.finish();
                if (mExitTime != 0){
                    mExitTime = 0;
                }
            }
            return true;
        }
        return true;
    }
}
