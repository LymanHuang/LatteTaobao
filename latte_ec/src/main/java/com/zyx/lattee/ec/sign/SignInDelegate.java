package com.zyx.lattee.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.net.RestClient;
import com.zyx.latte.net.callback.ISuccess;
import com.zyx.latte.wechat.LatteWeChat;
import com.zyx.latte.wechat.callbacks.IWeChatSignInCallback;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zyx on 2017/8/10.
 */

public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        if (checkForm()){
            RestClient.builder()
                    .url("http://www.ijk.com/RestDataServer/api/user_profile.php")
                    .params("email",mEmail.getText().toString())
                    .params("password",mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            SignHandler.onSignIn(response,mISignListener);
                        }
                    })
                    .build()
                    .post();

            Toast.makeText(getContext(),"验证通过",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.icon_sign_in_we_chat)
    void onClickWeChat(){
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {

            }
        }).signIn();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        getSupportDelegate().start(new SignUpDelegate());
    }

  private boolean checkForm(){
      String email = mEmail.getText().toString();
      String password = mPassword.getText().toString();

      boolean isPass = true;

      if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
          mEmail.setError("错误的邮箱格式");
          isPass = false;
      } else {
          mEmail.setError(null);
      }

      if (password.isEmpty() || password.length() < 6) {
          mPassword.setError("请填写至少6位数密码");
          isPass = false;
      } else {
          mPassword.setError(null);
      }

      return isPass;
  }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
