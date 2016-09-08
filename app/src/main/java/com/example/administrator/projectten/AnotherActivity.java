package com.example.administrator.projectten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Button button=(Button)findViewById(R.id.buttonReturn);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=getIntent();
                String name=intent.getStringExtra("name");
                Integer age=intent.getIntExtra("age",20);
                intent.putExtra("result","姓名："+name+"年龄："+age);
                setResult(0,intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode==0 && resultCode==1){
            String str=data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
    }
}
