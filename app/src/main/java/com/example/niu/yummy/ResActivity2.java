package com.example.niu.yummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button main_button=(Button)findViewById(R.id.main_btn);
        main_button.setOnClickListener(back_main);
        Button cuisine_button=(Button)findViewById(R.id.cuisine_btn);
        cuisine_button.setOnClickListener(cuisine);
    }
    private View.OnClickListener back_main=new View.OnClickListener() {
        @Override
        public void onClick(View view) {Intent intent=new Intent();
            intent.setClass( ResActivity2.this,
                    MainActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener cuisine=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(ResActivity2.this,
                    CuisineActivity2.class);
            startActivity(intent);
        }
    };
}
