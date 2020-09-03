package com.example.wallpapermanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.wallpaper.MsWallPaperService;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btn_on;
    private Button btn_off;
    private Button btn_clean;
    private AlarmManager am;
    private PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen);

        // 获得 AlarmManager 对象
        am = (AlarmManager) getSystemService(ALARM_SERVICE);

        // 指定要启动的 Service,并指明动作是 Servce
        Intent intent = new Intent(MainActivity.this, MsWallPaperService.class);
        pi = PendingIntent.getService(MainActivity.this, 0, intent, 0);
        bindViews();
    }

    private void bindViews() {
        btn_on = (Button) findViewById(R.id.btn_on);
        btn_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
                startActivity(Intent.createChooser(intent,"选择壁纸"));
            }
        });

//        btn_off = (Button) findViewById(R.id.btn_off);
//        btn_clean = (Button) findViewById(R.id.btn_clean);
//        btn_on.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.btn_on:
//                        am.setRepeating(AlarmManager.RTC_WAKEUP, 0, 2000, pi);
//                        btn_on.setEnabled(false);
//                        btn_off.setEnabled(true);
//                        Toast.makeText(MainActivity.this, "自动更换壁纸设置成功", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.btn_off:
//                        btn_on.setEnabled(true);
//                        btn_off.setEnabled(false);
//                        am.cancel(pi);
//                        break;
//                    case R.id.btn_clean:
//                        try {
//                            WallpaperManager.getInstance(getApplicationContext()).clear();
//                            Toast.makeText(MainActivity.this, "清除壁纸成功~", Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        break;
//                }
//            }
//        });
    }
}