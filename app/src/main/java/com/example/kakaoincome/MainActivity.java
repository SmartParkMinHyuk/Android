package com.example.kakaoincome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_musinsa;
    private Button btn_mutnam;
    private Button btn_kkonam;

    private Button btn_send;

    private String url_musinsa;
    private String url_mutnam;
    private String url_kkonam;

    private String musinsa;
    private String mutnam;
    private String kkonam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_musinsa = findViewById(R.id.btn_musinsa);
        btn_mutnam = findViewById(R.id.btn_mutnam);
        btn_kkonam = findViewById(R.id.btn_kkonam);

        btn_send = findViewById(R.id.btn_send);

        //버튼 첫줄 시작////////////////////////////////////////////////////////////////////////////
        //무신사로 이동하기
        btn_musinsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musinsa = "무신사";
                url_musinsa = "https://www.musinsa.com/";
                Intent intent = new Intent(MainActivity.this , WebViewActivity.class);
                intent.putExtra("url", url_musinsa);
                intent.putExtra("pageName", musinsa);
                startActivity(intent);
            }
        });

        //멋남으로 이동하기
        btn_mutnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mutnam = "멋남";
                url_mutnam = "https://www.mutnam.com/";
                Intent intent = new Intent(MainActivity.this , WebViewActivity.class);
                intent.putExtra("url", url_mutnam);
                intent.putExtra("pageName", mutnam);
                startActivity(intent);
            }
        });

        //꽃남으로 이동하기
        btn_kkonam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kkonam = "꽃남";
                url_kkonam = "https://www.musinsa.com/";
                Intent intent = new Intent(MainActivity.this , WebViewActivity.class);
                intent.putExtra("url", url_kkonam);
                intent.putExtra("pageName", kkonam);
                startActivity(intent);
            }
        });
        //버튼 첫줄 끝 //////////////////////////////////////////////////////////////////////////////

        //버튼 두번째 줄
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendActivity.class);
                startActivity(intent);
            }
        });

    }


}