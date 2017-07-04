package com.example.xdf.testdrawpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  private  int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("","");
        final MyView2 view_2= (MyView2) findViewById(R.id.view_2);
        view_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress=0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress<100){
                            if(progress+7>100){
                                progress=100;
                            }else{
                                progress+=7;
                            }
                            view_2.setProgress(progress);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            }
        });
    }
}
