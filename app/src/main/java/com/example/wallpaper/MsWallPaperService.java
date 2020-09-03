package com.example.wallpaper;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import com.example.wallpapermanager.R;

import static android.app.Service.START_STICKY;

public class MsWallPaperService  extends Service {
    private int current=0;
    private int[] papers=new int[]{R.drawable.w_1,R.drawable.w_2,R.drawable.w_3,R.drawable.w_4};
    private WallpaperManager wl=null;

    @Override
    public void onCreate() {
        super.onCreate();
        wl= WallpaperManager.getInstance(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(current >= 4)
            current = 0;

        try{
            wl.setResource(papers[current++]);
        }catch(Exception e){e.printStackTrace();}
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
