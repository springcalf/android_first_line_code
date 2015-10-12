package com.example.administrator.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/9.
 */
public class FirstActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        System.out.println("111111111111111111111 onCreate");
        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"you click button",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                String data ="hello world";
                intent.putExtra("extra_data",data);
               // startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
    }
    protected  void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        System.out.println("111111111111111111111 onActivityResult");
        switch (requestCode)
        {
            case 1:
                System.out.println("111111111111111111111  case 1");
                if (resultCode == RESULT_OK)
                {
                    String returnData;
                    returnData = intent.getStringExtra("data_resturn");
                    System.out.println(returnData);
                }
                break;
            default:
                System.out.println("111111111111111111111  case default");
                break;
        }
    }
}
