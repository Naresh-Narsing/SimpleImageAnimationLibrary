package com.nstech.simpleimageanimationlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nstech.simpleimageanimation.CustomImage;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    CustomImage image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (CustomImage) findViewById(R.id.imageView);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                Toast.makeText(this, "Simple Image Library Demo", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
