package com.example.administrator.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public  static final  String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        if (savedInstanceState !=  null)
        {
            String tmpData = savedInstanceState.getString("data_key");
            Log.d(TAG,tmpData);
        }
        setContentView(R.layout.activity_main);
        final Button startNormalActivity = (Button)findViewById(R.id.start_normal_activity);
        final Button dialogDialogActivity = (Button)findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        dialogDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected  void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected  void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected  void onPause()
    {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected  void onStop()
    {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected  void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected  void onRestart()
    {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected  void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        String tmpData = "something you just typed";
        outState.putString("data_key",tmpData);
    }
}
