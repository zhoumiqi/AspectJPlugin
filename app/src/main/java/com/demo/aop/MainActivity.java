package com.demo.aop;

import android.Manifest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aop.aspectj.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Permission({Manifest.permission.READ_EXTERNAL_STORAGE})
    public void readSdCard(View view) {
        Toast.makeText(this, "获取到权限", Toast.LENGTH_SHORT).show();
    }
}
