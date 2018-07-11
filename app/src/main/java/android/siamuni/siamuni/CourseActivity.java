package android.siamuni.siamuni;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity {

    private static String TAG="CourseActivity";

    private GridView bookShelf;
    private int[] data = {
            R.drawable.cover_txt,R.drawable.cover_txt,R.drawable.cover_txt,R.drawable.cover_txt
    };
    private String[] name={
            "PPT","Handout","Quiz","Video"
    };

    TextView course;
    int courseNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }


        Intent intent=getIntent();
        String courseName=intent.getStringExtra("courseName");
        courseNo=intent.getIntExtra("courseNo",0);
        Log.i(TAG, "onCreate: courseNo="+courseNo);

        course=findViewById(R.id.tv_head);
        course.setText(courseName);
        course.setTextSize(10);

        bookShelf = findViewById(R.id.bookShelf);
        ShelfAdapter adapter=new ShelfAdapter();
        bookShelf.setAdapter(adapter);
        bookShelf.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if(arg2>=data.length){

                }else{
                    Toast.makeText(CourseActivity.this, ""+name[arg2], Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(CourseActivity.this,ContentActivity.class);
                    intent.putExtra("courseNo",courseNo);
                    intent.putExtra("docType",name[arg2]);
                    intent.putExtra("docTypeNo",arg2);
                    Log.i(TAG, "onItemClick: docType="+name[arg2]);
                    Log.i(TAG, "onItemClick: courseNo="+courseNo);
                    Log.i(TAG, "onItemClick: docTypeNo="+arg2);

                    startActivity(intent);

                }
            }
        });
    }

    public void onClick(View v){
        super.onBackPressed();
    }

    class ShelfAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.length+5;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int position, View contentView, ViewGroup arg2) {
            // TODO Auto-generated method stub

            contentView= LayoutInflater.from(CourseActivity.this).inflate(R.layout.bookitem, null);

            TextView view=(TextView) contentView.findViewById(R.id.imageView1);
            if(data.length>position){
                if(position<name.length){
                    view.setText(name[position]);
                }
                view.setBackgroundResource(data[position]);
            }else{
                view.setBackgroundResource(data[0]);
                view.setClickable(false);
                view.setVisibility(View.INVISIBLE);
            }
            return contentView;
        }
    }

}
