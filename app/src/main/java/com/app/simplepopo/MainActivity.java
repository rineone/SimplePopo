package com.app.simplepopo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.app.simplepopowin.HorizontalPosition;
import com.app.simplepopowin.SimplePopupWindow;
import com.app.simplepopowin.VerticalPosition;

public class MainActivity extends Activity {

    private RadioGroup rgVer;
    private RadioGroup rgHor;
    private TextView tvDialog;
    private TextView tvView;
    private TextView tvView2;
    private View mContentView;
    private Context mContext ;
    private int mVer = VerticalPosition.CENTER;
    private int mHor = HorizontalPosition.CENTER;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgVer = findViewById(R.id.rg_ver);
        rgHor = findViewById(R.id.rg_hor);

        tvDialog = findViewById(R.id.tv_dialog);
        tvView = findViewById(R.id.tv_view);
        mContentView = getLayoutInflater().inflate(R.layout.dialog_pop_1, null);
        tvView2 = mContentView.findViewById(R.id.tv_pop_view);
        mContext = this;
        tvView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击",Toast.LENGTH_LONG).show();
            }
        });
        tvDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toDialog();
            }
        });
        rgVer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rb_ver_center:
                        mVer = VerticalPosition.CENTER;
                        break;
                    case R.id.rb_top:
                        mVer = VerticalPosition.ABOVE;
                        break;
                    case R.id.rb_bottom:
                        mVer = VerticalPosition.BELOW;
                        break;
                    case R.id.rb_align_top:
                        mVer = VerticalPosition.ALIGN_TOP;
                        break;
                    case R.id.rb_align_bottom:
                        mVer = VerticalPosition.ALIGN_BOTTOM;
                        break;
                }
            }
        });
        rgHor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rb_center:
                        mHor = HorizontalPosition.CENTER;
                        break;
                    case R.id.rb_left:
                        mHor = HorizontalPosition.LEFT;
                        break;
                    case R.id.rb_right:
                        mHor = HorizontalPosition.RIGHT;
                        break;
                    case R.id.rb_align_left:
                        mHor = HorizontalPosition.ALIGN_LEFT;
                        break;
                    case R.id.rb_align_right:
                        mHor = HorizontalPosition.ALIGN_RIGHT;
                        break;
                }
            }
        });
    }



    private void toDialog(){
        SimplePopupWindow popupWindow = SimplePopupWindow.Builder
                .build( this, mContentView)      //此处mContentView为显示dialog View
                .setAlpha(0.6f)                   //默认全透明    背景灰度
                .setOutsideTouchDismiss(true)    //默认true  点击外部消失
                .createPopupWindow();
        popupWindow.showAtAnchorView(tvView   //此处tvView为显示dialog根本此tvView来进行显示的位置
                , VerticalPosition.CENTER, HorizontalPosition.CENTER);
        popupWindow.showAtAnchorView(tvView, mVer, mHor);
    }
}
