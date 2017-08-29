package io.github.adsuper.androido;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支持画中画 的 Activity
 */
public class PIPActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.btn)
    public void onViewClicked() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            enterPictureInPictureMode();
        }
    }


    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }
}
