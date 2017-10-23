package com.zyx.learnexample;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;
import com.zyx.latte.activies.ProxyActivity;
import com.zyx.latte.app.Latte;
import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte_ui.launcher.ILauncherListener;
import com.zyx.latte_ui.launcher.OnLauncherFinishTag;
import com.zyx.lattee.ec.lanucher.LanucherDelegate;
import com.zyx.lattee.ec.lanucher.LauncherScrollDelegate;
import com.zyx.lattee.ec.main.EcBottomDelegate;
import com.zyx.lattee.ec.main.index.IndexDelegate;
import com.zyx.lattee.ec.sign.ISignListener;
import com.zyx.lattee.ec.sign.SignInDelegate;
import com.zyx.lattee.ec.sign.SignUpDelegate;

import me.yokeyword.fragmentation.*;
import me.yokeyword.fragmentation.BuildConfig;
import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity  implements
        ISignListener ,
        ILauncherListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfiguratior().withActivity(this);
        StatusBarCompat.translucentStatusBar(this,true);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this, "启动结束,用户登录了", Toast.LENGTH_SHORT).show();
                getSupportDelegate().startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束,用户没登录", Toast.LENGTH_SHORT).show();
                getSupportDelegate().startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
