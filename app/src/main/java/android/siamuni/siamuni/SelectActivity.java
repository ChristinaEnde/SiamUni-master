package android.siamuni.siamuni;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox c1;CheckBox c2;CheckBox c3;CheckBox c4;CheckBox c5;CheckBox c6;CheckBox c7;CheckBox c8;CheckBox c9;
    CheckBox c10;CheckBox c11;CheckBox c12;CheckBox c13;CheckBox c14;CheckBox c15;CheckBox c16;CheckBox c17;
    CheckBox c18;
    SharedPreferences.Editor editor;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

        save = (Button) findViewById(R.id.save);
        initcheckbox();
        editor = getSharedPreferences("subnum", MODE_PRIVATE).edit();
        save.setOnClickListener(this);
    }

    public void onClick(View v) {
        SharedPreferences sp = getSharedPreferences("subnum",MODE_PRIVATE);
        int j = 0;
        for (int i=1;i<=18;i++){
            if (sp.getString("sub"+i,"0").equals("1")){
                Log.i("SelectActivity","第"+i+"门课已经被选");
                j++;
            }
        }
        Log.i("SelectActivity","select course number: "+j);
        //一共选择了几门课
        if(j>0&&j<=6){
            editor.putString("flag","isSelected");
            editor.apply();
            Intent intent = new Intent(SelectActivity.this,MainActivity.class);
            startActivity(intent);
        }else {
            for (int i = 1; i <= 18; i++) {
                editor.putString("sub"+i,"0");
                editor.apply();
            }
            Toast.makeText(SelectActivity.this,"Please select at least one subject and no more than six subjects",Toast.LENGTH_SHORT).show();
        }
    }

    private void initcheckbox(){
        c1 = (CheckBox) findViewById(R.id.c1);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub1","1");
                    editor.apply();
                }else{
                    editor.putString("sub1","0");
                    editor.apply();
                }
            }
        });
        c2 = (CheckBox) findViewById(R.id.c2);
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub2","1");
                    editor.apply();
                }else{
                    editor.putString("sub2","0");
                    editor.apply();
                }
            }
        });
        c3 = (CheckBox) findViewById(R.id.c3);
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub3","1");
                    editor.apply();
                }else{
                    editor.putString("sub3","0");
                    editor.apply();
                }
            }
        });
        c4 = (CheckBox) findViewById(R.id.c4);
        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub4","1");
                    editor.apply();
                }else{
                    editor.putString("sub4","0");
                    editor.apply();
                }
            }
        });
        c5 = (CheckBox) findViewById(R.id.c5);
        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub5","1");
                    editor.apply();
                }else{
                    editor.putString("sub5","0");
                    editor.apply();
                }
            }
        });
        c6 = (CheckBox) findViewById(R.id.c6);
        c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub6","1");
                    editor.apply();
                }else{
                    editor.putString("sub6","0");
                    editor.apply();
                }
            }
        });
        c7 = (CheckBox) findViewById(R.id.c7);
        c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub7","1");
                    editor.apply();
                }else{
                    editor.putString("sub7","0");
                    editor.apply();
                }
            }
        });
        c8 = (CheckBox) findViewById(R.id.c8);
        c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub8","1");
                    editor.apply();
                }else{
                    editor.putString("sub8","0");
                    editor.apply();
                }
            }
        });
        c9 = (CheckBox) findViewById(R.id.c9);
        c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub9","1");
                    editor.apply();
                }else{
                    editor.putString("sub9","0");
                    editor.apply();
                }
            }
        });
        c10 = (CheckBox) findViewById(R.id.c10);
        c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub10","1");
                    editor.apply();
                }else{
                    editor.putString("sub10","0");
                    editor.apply();
                }
            }
        });
        c11 = (CheckBox) findViewById(R.id.c11);
        c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub11","1");
                    editor.apply();
                }else{
                    editor.putString("sub11","0");
                    editor.apply();
                }
            }
        });
        c12 = (CheckBox) findViewById(R.id.c12);
        c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub12","1");
                    editor.apply();
                }else{
                    editor.putString("sub12","0");
                    editor.apply();
                }
            }
        });
        c13 = (CheckBox) findViewById(R.id.c13);
        c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub13","1");
                    editor.apply();
                }else{
                    editor.putString("sub13","0");
                    editor.apply();
                }
            }
        });
        c14 = (CheckBox) findViewById(R.id.c14);
        c14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub14","1");
                    editor.apply();
                }else{
                    editor.putString("sub14","0");
                    editor.apply();
                }
            }
        });
        c15 = (CheckBox) findViewById(R.id.c15);
        c15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub15","1");
                    editor.apply();
                }else{
                    editor.putString("sub15","0");
                    editor.apply();
                }
            }
        });
        c16 = (CheckBox) findViewById(R.id.c16);
        c16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub16","1");
                    editor.apply();
                }else{
                    editor.putString("sub16","0");
                    editor.apply();
                }
            }
        });
        c17 = (CheckBox) findViewById(R.id.c17);
        c17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub17","1");
                    editor.apply();
                }else{
                    editor.putString("sub17","0");
                    editor.apply();
                }
            }
        });
        c18 = (CheckBox) findViewById(R.id.c18);
        c18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("sub18","1");
                    editor.apply();
                }else{
                    editor.putString("sub18","0");
                    editor.apply();
                }
            }
        });
    }
}
