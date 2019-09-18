package com.tuto.animatedfab;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tuto.animatedfab.ui.FabMenuItem;
import com.tuto.animatedfab.utils.LayoutUtil;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;

    private LinearLayout layoutFabMenuItem;

    private Animation fabMenuItemOpen;
    private Animation fabMenuItemClose;
    private Animation fabRotateOpen;
    private Animation fabRotateClose;

    private int bottomMargin;

    private boolean isFabMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initAnimation();

        layoutFabMenuItem = findViewById(R.id.layout_fab_menu_item);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });

        bottomMargin = (int) LayoutUtil.getDip(getApplicationContext(), 12);

        addFabMenuItem("Show List", R.drawable.ic_format_list_bulleted_white_24dp, bottomMargin, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();

                Toast.makeText(getApplicationContext(), "Show List Clicked", Toast.LENGTH_LONG).show();

                // todo : do something
            }
        });
        addFabMenuItem("Upload To Server", R.drawable.upload_to_cloud_white_48dp, 0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();

                Toast.makeText(getApplicationContext(), "Upload To Server Clicked", Toast.LENGTH_LONG).show();

                // todo : do something
            }
        });
    }

    private void initAnimation() {
        fabMenuItemOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabMenuItemClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fabRotateOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_close);
        fabRotateClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_ratate_close);
    }

    private void addFabMenuItem(String title, int imgSrc, int marginBottom, View.OnClickListener listener) {
        FabMenuItem item = new FabMenuItem(getApplicationContext());

        item.setTextTitle(title);
        item.setImgBtnImage(imgSrc);
        item.setOnImgBtnClickListener(listener);

        if(marginBottom > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomMargin = marginBottom;

            item.setLayoutParams(layoutParams);
        }

        layoutFabMenuItem.addView(item);
    }

    private void animateFab() {
        if(isFabMenuOpen) {
            layoutFabMenuItem.setVisibility(View.GONE);
            layoutFabMenuItem.startAnimation(fabMenuItemClose);
            fab.startAnimation(fabRotateClose);
        } else {
            layoutFabMenuItem.setVisibility(View.VISIBLE);
            layoutFabMenuItem.startAnimation(fabMenuItemOpen);
            fab.startAnimation(fabRotateOpen);
        }

        isFabMenuOpen = !isFabMenuOpen;
    }
}
