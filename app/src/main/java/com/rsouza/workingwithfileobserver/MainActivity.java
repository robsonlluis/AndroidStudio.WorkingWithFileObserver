package com.rsouza.workingwithfileobserver;

import android.content.Context;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FileListener fileObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartFileListener = (Button) findViewById(R.id.btnStartFileListener);
        btnStartFileListener.setOnClickListener(this);
        fileObserver = new FileListener(getExternalFilesDir(null).toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartFileListener:
                fileObserver.startWatching();
                break;
        }
    }

    class FileListener extends FileObserver {
        private String mAbsolutePath;

        public FileListener(String path){
            super(path);
            mAbsolutePath = path;
            Log.d("FileObserver",path);
        }

        @Override
        public void onEvent(int event, String path){

            switch(event){
                case FileObserver.CREATE:
                    Log.d("FileObserver", "CREATE");
                    break;
                case FileObserver.DELETE:
                    Log.d("FileObserver", "DELETE");
                    break;
                case FileObserver.DELETE_SELF:
                    Log.d("FileObserver", "DELETE_SELF");
                    break;
                case FileObserver.MODIFY:
                    Log.d("FileObserver", "MODIFY");
                    break;
                case FileObserver.MOVED_FROM:
                    Log.d("FileObserver", "MOVED_FROM");
                    break;
                case FileObserver.MOVED_TO:
                    Log.d("FileObserver", "MOVED_TO");
                    break;
                case FileObserver.MOVE_SELF:
                    Log.d("FileObserver", "MOVE_SELF");
                    break;
            }
        }
    }
}
