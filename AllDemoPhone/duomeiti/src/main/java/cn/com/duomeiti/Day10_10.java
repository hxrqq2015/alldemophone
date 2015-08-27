package cn.com.duomeiti;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * day10_10surfaceview入门
 * surfaceview是一个比较高级的控件，它可以在单位时间内大量的切换画面、渲染图像显示
 * 可以在子线程里面更新UI的
 * 内部使用了双缓冲机制
 * 线程0：计算数据--更新UI--计算数据
 * 线程1： 更新UI---计算数据 --更新UI
 * Created by admin on 2015/8/24.
 */
public class Day10_10 extends Activity {
    SurfaceView sv ;
    SurfaceHolder holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day10_10layout);
        //视图
        sv = (SurfaceView) findViewById(R.id.sv);
        //surfaceview非常的消耗内存，系统并不是一开始就渲染它，而是等界面完全显示出来之后，才渲染它。
        //它才会被创建出来。
        holder = sv.getHolder();
        //设置一个回调，当surfaceview的状态发生了改变。
        holder.addCallback(new SurfaceHolder.Callback() {
            //当surface创建和完毕 ，当它可见的时候调用。
            @Override
            public void surfaceCreated(final SurfaceHolder holder) {
                System.out.println("surfaceCreated。。。");
                new Thread(){
                    @Override
                    public void run() {
                        //得到surfaceview的控制器
                        SurfaceHolder holder1 = sv.getHolder();
                        for (int i=0;i<100;i++){
                            int radius = 5+i;
                            //锁定surfaceview里面的画布，然后返回。
                            Canvas canvas = holder1.lockCanvas();
                            canvas.drawColor(Color.BLACK);
                            Paint paint = new Paint();
                            paint.setColor(Color.RED);
                            canvas.drawCircle(200, 200, radius, paint);
                            //解锁画布，并且马上更新画布上的图像，显示到界面上
                            holder1.unlockCanvasAndPost(canvas);
                            //休眠100毫秒
                            SystemClock.sleep(10);
                        }
                    }
                }.start();
            }
            //当surface大小值发生改变
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                System.out.println("surfaceChanged。。。");
            }
            //当surfaceView销毁 ,当surfaceView看不见的时候，就会调用onDesotry方法
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                System.out.println("surfaceDestroyed。。。");
            }
        });
    }



    public void start(View v){
    }
}
