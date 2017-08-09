package com.android.seelpatel.easylogin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class EasyLogin {

    private Context mainContext;
    private AppCompatActivity mainActivity;

    private Button mLoginButton;
    private EditText mUsernameField;
    private EditText mPasswordField;
    private ImageView mLogoImageView;
    private CheckBox mRememberPasswordCheckBox;

    private boolean logoVisible  = true;
    private boolean rememberPasswordVisible = true;

    private int currentTheme = 0;

    private LoginEventListener loginListener = new LoginEventListener() {
        @Override
        public void loginButtonPressed() {

        }
    };

    public interface LoginEventListener {
        void loginButtonPressed();
    }

    public static class Style {
        public static final int LIGHT = 0;
        public static final int DARK = 1;
    }


    public EasyLogin(Context context, AppCompatActivity activity) {
        mainActivity = activity;
        mainContext = context;
    }

    public void initializeLoginScreen() {
        initializeView();
    }

    private void initializeView() {

        switch (currentTheme) {
            case Style.LIGHT:
                mainActivity.setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                break;
            case Style.DARK:
                mainActivity.setTheme(R.style.Theme_AppCompat_NoActionBar);
                break;
        }

        mainActivity.setContentView(R.layout.easy_login);

        mLoginButton = ((Button) mainActivity.findViewById(R.id.login_button));
        mUsernameField = ((EditText) mainActivity.findViewById(R.id.username_textfield));
        mPasswordField = ((EditText) mainActivity.findViewById(R.id.password_textfield));
        mLogoImageView = ((ImageView) mainActivity.findViewById(R.id.logo_imageview));
        mRememberPasswordCheckBox = ((CheckBox) mainActivity.findViewById(R.id.remember_passowrd_checkbox));


        if (logoVisible) {
            mLogoImageView.setVisibility(View.VISIBLE);
        }
        else {
            mLogoImageView.setVisibility(View.INVISIBLE);
        }

        if (rememberPasswordVisible) {
            mRememberPasswordCheckBox.setVisibility(View.VISIBLE);
        }
        else {
            mRememberPasswordCheckBox.setVisibility(View.GONE);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.loginButtonPressed();
            }
        });
    }


    public void setTheme(int themeId) {
        if (themeId == Style.DARK || themeId == Style.LIGHT) {
            currentTheme = themeId;
        }
    }

    public void setLogoImage(int resId) {
        mLogoImageView.setImageResource(resId);
    }

    public void setlogoVisible(boolean visible) {
        this.logoVisible = visible;
    }

    public void setRememberPasswordVisible(boolean visible) {
        this.rememberPasswordVisible = visible;
    }

    public void setOnLoginListener(LoginEventListener listener) {
        this.loginListener = listener;
    }

    public String getUsername() {
        return mUsernameField.getText().toString();
    }

    public boolean getRememberPasswordValue() {
        return mRememberPasswordCheckBox.isChecked();
    }

    public String getPassword() {
        return mPasswordField.getText().toString();
    }


}
