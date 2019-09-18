package com.tuto.animatedfab.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuto.animatedfab.R;
import com.tuto.animatedfab.utils.LayoutUtil;

public class FabMenuItem extends LinearLayout {
    private TextView tvTitle;

    private ImageButton imgBtn;

    public FabMenuItem(Context context) {
        super(context);
        init(context);
    }

    public FabMenuItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutUtil.inflate(context, this, R.layout.fab_menu_item);

        tvTitle = findViewById(R.id.tv_title);

        imgBtn = findViewById(R.id.img_btn);
    }

    public void setTextTitle(String title) {
        tvTitle.setText(title);
    }

    public void setImgBtnImage(int imageRes) {
        imgBtn.setImageResource(imageRes);
    }

    public void setOnImgBtnClickListener(OnClickListener listener) {
        imgBtn.setOnClickListener(listener);
    }
}
