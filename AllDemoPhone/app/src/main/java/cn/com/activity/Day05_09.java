package cn.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cn.com.alldemophone.R;

/**
 * 多线程断点续传
 * Created by admin on 2015/8/19.
 */
public class Day05_09 extends Activity {
    private static final int THREAD_COUNT = 3; //线程个数是3个
    EditText day05_edi_01;
    String path;
    ProgressBar pb1 , pb2 , pb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day05_09layout);
        day05_edi_01= (EditText) findViewById(R.id.day05_edi_01);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        pb3 = (ProgressBar) findViewById(R.id.pb3);

    }

    /**
     * 下载
     * @param v
     */
    public void dowload(View v){
         path =day05_edi_01.getText().toString();
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    int length = conn.getContentLength();

                    //在本地生成与之大小一样的文件
                  RandomAccessFile raf = new RandomAccessFile(getFileName(path),"rw");

                    //设置文件的长度
                    raf.setLength(length);
                    //开始划分每一个线程从什么位置下载到什么位置
                    int blockSize = length/THREAD_COUNT;
                    for(int theadId =0;theadId<THREAD_COUNT;theadId++){
                        int startIndex = theadId*blockSize;//每个线程的下载开始位置
                        int endIndex = (theadId+1)*blockSize-1;
                        if(theadId ==THREAD_COUNT-1){//如果是最后一个线程，那么比较辛苦，它的结束为止，文件的末尾-1
                            endIndex =length-1;
                        }
                        //开始线程去下载，并且传递进去每一个线程下载的起始位置以及结束位置
                        new Downloader(theadId,startIndex,endIndex).start();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    class Downloader extends Thread{
        private int threadId ;   //线程ID
        private int startIndex ;  //线程下载的理论开始位置
        private int endIndex ; //线程下载的结束位置
        int currentPosition ;   //记录当前的下载位置

        public Downloader(int threadId, int startIndex, int endIndex) {
            this.threadId = threadId;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            currentPosition = startIndex ;

        }

        @Override
        public void run() {
            try {
                //先找到之前记录好的位置信息
                File file = new File( Environment.getExternalStorageDirectory().toString()+"/"+threadId+".position");
                if(file.exists() && file.length()>0){//代表以前曾经下载过文件，这个时候必须读取里面的位置信息
                    FileInputStream fis = new FileInputStream(file);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    currentPosition = Integer.parseInt(br.readLine());
                   // System.out.println("以前有下载过文件 ---"+threadId+"--从"+currentPosition+"开始下载");
                }else {
                   // System.out.println("以前没有下载过文件，从头开始下载 ---");
                }

                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //conn.getInputStream()//获取这个资源对应的所有输入流
                //为了实现每个线程下载的东西都有固定的位置，所以必须告诉服务器，每一个线程从什么位置
//				下载到什么位置
                conn.setRequestProperty("Range", "bytes:"+currentPosition+"-"+endIndex);
                int code = conn.getResponseCode();
                if(206==code){
                    //写文件的时候要尤其注意，因为已经规定了每一个线程从什么位置开始下载，所以
//					写数据的时候也必须从指定位置开始写入
                    RandomAccessFile raf = new RandomAccessFile(getFileName(path),"rw");
                    raf.seek(currentPosition);
                    InputStream is = conn.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len =0;
                    while ((len=is.read(buffer))!=-1){
                        currentPosition +=len; //记录当前的下载位置
                        raf.write(buffer,0,len);
                        RandomAccessFile fos = new RandomAccessFile( Environment.getExternalStorageDirectory().toString()+"/"+threadId+".position", "rwd");
                        fos.write((currentPosition+"").getBytes());
                        fos.close();
                        if(threadId == 0 ){ //第0个线程
                            pb1.setMax(endIndex - startIndex) ;
                            pb1.setProgress(currentPosition - startIndex);
                        }else if(threadId == 1 ){ //第0个线程
                            pb2.setMax(endIndex - startIndex) ;
                            pb2.setProgress(currentPosition - startIndex);
                        }else if(threadId == 2 ){ //第0个线程
                            pb3.setMax(endIndex - startIndex) ;
                            pb3.setProgress(currentPosition - startIndex);
                        }
                    }
                    raf.close();
                    //每一个线程下载完毕之后，删除掉对应的position文件
                    File positionFile = new File( Environment.getExternalStorageDirectory().toString()+"/"+threadId+".position");
                    boolean flag = positionFile.delete();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件的名字
     * @param path
     * @return
     */
    public  String getFileName(String path){
        int index = path.lastIndexOf("/")+1;

      //  Environment.getExternalStorageDirectory().toString()+"/" 等于  /storage/sdcard/
       return  Environment.getExternalStorageDirectory().toString()+"/"+path.substring(index);
    }
}
