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

public class ContentActivity extends AppCompatActivity {
    private static String TAG="CourseActivity";

    private GridView bookShelf;
    private int[] data;
    private String[] name;
    private int[][][] a=new int[18][4][16];
    TextView title;
    int courseNo;
    int docTypeNo;
    int weekNo;
    int classNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }


        setA();

        Intent intent=getIntent();
        String docType=intent.getStringExtra("docType");
        courseNo=intent.getIntExtra("courseNo",0);
        docTypeNo=intent.getIntExtra("docTypeNo",0);

        //设置书本数量
        int num=0;
        for(int i=0;i<16;i++){
            Log.i(TAG, "onCreate: a["+courseNo+"]["+docTypeNo+"]["+i+"]="+a[courseNo][docTypeNo][i]);
            num=num+a[courseNo][docTypeNo][i];
        }
        Log.i(TAG, "onCreate: num="+num);
        data=new int[num];
        name=new String[num];
        for(int i=0;i<num;i++){
            data[i]=R.drawable.cover_txt;
        }
        int j=0;
        for(int i=1;i<=16;i++){
            int n=a[courseNo][docTypeNo][i-1];
            if(n==1){
                name[j]="Week "+i+"_1";
                Log.i(TAG, "onCreate: name["+j+"]="+name[j]);
                j++;
            }else if(n>1){
                for(int k=1;k<=n;k++){
                    name[j]="Week "+i+"_"+k;
                    Log.i(TAG, "onCreate: name["+j+"]="+name[j]);
                    j++;
                }

            }

        }


        title=findViewById(R.id.tv_head);
        title.setText(docType);

        bookShelf = findViewById(R.id.bookShelf);
        ShelfAdapter adapter=new ShelfAdapter();
        bookShelf.setAdapter(adapter);
        bookShelf.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if(arg2<data.length){
                    Toast.makeText(ContentActivity.this, ""+name[arg2], Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "onItemClick: name["+arg2+"]="+name[arg2]);
                    weekNo=Integer.parseInt(name[arg2].substring(5,6));
                    classNum=Integer.parseInt(name[arg2].substring(name[arg2].length()-1,name[arg2].length()));
                    Intent intent=new Intent(ContentActivity.this,WebViewActivity.class);
                    intent.putExtra("courseNo",courseNo);
                    intent.putExtra("docTypeNo",docTypeNo);
                    intent.putExtra("weekNo",weekNo);
                    intent.putExtra("classNum",classNum);
                    Log.i(TAG, "onItemClick: courseNo="+courseNo);
                    Log.i(TAG, "onItemClick: docTypeNo="+docTypeNo);
                    Log.i(TAG, "onItemClick: weekNo="+weekNo);
                    Log.i(TAG, "onItemClick: classNum="+classNum);
                    startActivity(intent);
                }
            }
        });

    }


    public void setA(){
        int k;
        for(int i=0;i<18;i++){
            for(int j=0;j<4;j++){
                for(k=0;k<16;k++){
                    a[i][j][k]=1;
                }
            }
        }
        a[0][2][15]=0;a[0][0][7]=0;a[0][1][7]=0;a[0][2][7]=0;a[0][3][0]=0;a[0][3][1]=0;a[0][3][2]=0;
        a[0][3][3]=0;a[0][3][4]=0;a[0][3][5]=0;a[0][3][7]=0;a[0][3][8]=3;a[0][3][11]=6;a[0][3][12]=0;
        a[0][3][13]=0;a[0][3][14]=0;a[0][3][15]=0;

        a[1][3][0]=3;a[1][3][1]=6;a[1][3][2]=5;a[1][3][3]=0;a[1][3][4]=2;a[1][3][5]=0;a[1][3][6]=3;
        a[1][3][7]=0;a[1][3][8]=3;a[1][3][9]=2;a[1][3][10]=2;a[1][3][11]=8;a[1][3][12]=3;a[1][3][13]=7;
        a[1][3][14]=0;a[1][3][15]=0;a[1][0][6]=0;a[1][0][7]=0;a[1][1][6]=0;a[1][1][7]=0;a[1][2][7]=0;
        a[1][0][14]=0;a[1][0][15]=0;a[1][1][15]=0;

        a[2][3][3]=2;a[2][3][4]=3;a[2][0][7]=0;a[2][1][7]=0;a[2][2][7]=0;a[2][3][7]=0;a[2][3][8]=2;
        a[2][3][10]=2;a[2][2][15]=0;a[2][3][15]=0;

        a[3][0][0]=2;a[3][2][0]=0;a[3][3][0]=0;a[3][2][1]=0;a[3][3][1]=0;a[3][2][2]=0;a[3][3][2]=0;
        a[3][2][3]=0;a[3][3][3]=0;a[3][2][4]=0;a[3][3][4]=0;a[3][2][5]=0;a[3][3][5]=0;a[3][0][5]=3;
        a[3][2][6]=0;a[3][3][6]=0;a[3][0][7]=0;a[3][1][7]=0;a[3][2][7]=0;a[3][3][7]=0;a[3][2][8]=0;
        a[3][3][8]=0;a[3][2][9]=0;a[3][3][9]=0;a[3][2][10]=0;a[3][3][10]=0;a[3][2][11]=0;a[3][3][11]=0;
        a[3][2][12]=0;a[3][3][12]=0;a[3][2][13]=0;a[3][3][13]=0;a[3][1][13]=0;a[3][1][14]=0;a[3][1][15]=0;
        a[3][2][14]=0;a[3][3][14]=0;a[3][2][15]=0;a[3][3][15]=0;

        a[4][3][0]=0;a[4][3][1]=0;a[4][3][2]=0;a[4][3][3]=0;a[4][3][4]=0;a[4][3][5]=0;a[4][3][6]=0;
        a[4][3][7]=0;a[4][3][8]=0;a[4][3][9]=0;a[4][3][10]=0;a[4][3][11]=0;a[4][3][12]=0;a[4][3][13]=0;
        a[4][3][14]=0;a[4][3][15]=0;

        a[5][0][6]=0;a[5][0][12]=0;a[5][0][13]=0;a[5][0][14]=0;a[5][0][15]=0;a[5][1][6]=0;a[5][1][12]=0;
        a[5][1][13]=0;a[5][1][14]=0;a[5][1][15]=0;a[5][2][6]=0;a[5][2][7]=0;a[5][2][12]=0;a[5][2][13]=0;
        a[5][2][14]=0;a[5][2][15]=0;a[5][3][0]=0;a[5][3][1]=0;a[5][3][2]=0;a[5][3][3]=0;a[5][3][4]=0;
        a[5][3][5]=0;a[5][3][6]=0;a[5][3][7]=0;a[5][3][8]=0;a[5][3][9]=0;a[5][3][10]=0;a[5][3][11]=0;
        a[5][3][12]=0;a[5][3][13]=0;a[5][3][14]=0;a[5][3][15]=0;

        a[6][0][0]=2;a[6][0][1]=2;a[6][0][9]=0;a[6][0][10]=0;a[6][0][11]=0;a[6][0][12]=0;a[6][0][13]=0;
        a[6][0][14]=0;a[6][0][15]=0;a[6][1][1]=0;a[6][1][2]=0;a[6][1][3]=0;a[6][1][4]=0;a[6][1][5]=0;
        a[6][1][6]=0;a[6][1][9]=0;a[6][1][10]=0;a[6][1][11]=0;a[6][1][12]=0;a[6][1][13]=0;a[6][1][14]=0;
        a[6][1][15]=0;a[6][2][0]=0;a[6][2][1]=0;a[6][2][2]=0;a[6][2][3]=0;a[6][2][4]=0;a[6][2][5]=0;
        a[6][2][6]=0;a[6][2][7]=0;a[6][2][8]=0;a[6][2][9]=0;a[6][2][10]=0;a[6][2][11]=0;a[6][2][12]=0;
        a[6][2][13]=0;a[6][2][14]=0;a[6][2][15]=0;a[6][3][2]=0;a[6][3][3]=0;a[6][3][4]=0;a[6][3][5]=0;
        a[6][3][6]=0;a[6][3][7]=0;a[6][3][8]=0;a[6][3][9]=0;a[6][3][10]=0;a[6][3][11]=0;a[6][3][12]=0;
        a[6][3][13]=0;a[6][3][14]=0;a[6][3][15]=0;

        a[7][0][6]=0;a[7][0][7]=0;a[7][0][13]=2;a[7][1][7]=0;a[7][1][13]=2;a[7][2][7]=0;a[7][3][2]=2;
        a[7][3][3]=3;a[7][3][4]=2;a[7][3][5]=3;a[7][3][6]=0;a[7][3][7]=0;a[7][3][8]=0;a[7][3][9]=0;
        a[7][3][10]=0;a[7][3][11]=0;a[7][3][12]=0;a[7][3][13]=0;a[7][3][14]=0;a[7][3][15]=0;

        a[8][0][7]=0;a[8][1][7]=0;a[8][2][7]=0;a[8][3][0]=2;a[8][3][2]=4;a[8][3][3]=0;a[8][3][4]=3;
        a[8][3][5]=0;a[8][3][6]=0;a[8][3][7]=0;a[8][3][8]=0;a[8][3][9]=0;a[8][3][10]=0;a[8][3][11]=0;
        a[8][3][12]=0;a[8][3][13]=0;a[8][3][14]=0;a[8][3][15]=0;

        a[9][0][7]=0;a[9][1][7]=0;a[9][2][3]=0;a[9][2][6]=0;a[9][2][8]=0;a[9][2][9]=0;a[9][2][10]=0;
        a[9][2][11]=0;a[9][2][12]=0;a[9][2][13]=0;a[9][2][14]=0;a[9][2][15]=0;

        a[10][0][0]=0;a[10][0][7]=0;a[10][1][7]=0;
        for(int i=2;i<=3;i++){
            for(int j=0;j<16;j++){
                a[10][i][j]=0;
            }
        }

        a[11][0][7]=0;a[11][0][14]=0;a[11][1][7]=0;a[11][2][7]=0;a[11][2][14]=0;a[11][3][0]=6;a[11][3][1]=0;a[11][3][2]=0;
        a[11][3][3]=0;a[11][3][4]=0;a[11][3][5]=0;a[11][3][6]=0;a[11][3][7]=0;a[11][3][15]=0;
        a[11][3][8]=0;a[11][3][9]=0;a[11][3][10]=0;a[11][3][11]=0;a[11][3][12]=0;a[11][3][13]=0;a[11][3][14]=0;

        a[12][0][7]=0;a[12][0][14]=0;a[12][0][15]=0;a[12][1][7]=0;a[12][1][14]=0;a[12][1][15]=0;
        a[12][2][0]=0;a[12][2][7]=0;a[12][2][14]=0;a[12][2][15]=0;

        a[13][0][7]=0;a[13][0][14]=0;a[13][0][15]=0;a[13][1][7]=0;a[13][1][14]=0;a[13][1][15]=0;a[13][2][7]=0;
        a[13][2][12]=0;a[13][2][13]=0;a[13][2][14]=0;a[13][2][15]=0;

        a[14][0][0]=0;a[14][0][7]=0;a[14][0][13]=0;a[14][0][14]=0;a[14][0][15]=0;a[14][1][7]=0;
        a[14][1][12]=0;a[14][1][13]=0;a[14][1][14]=0;a[14][1][15]=0;a[14][3][0]=0;a[14][3][1]=0;
        a[14][3][2]=0;a[14][3][3]=0;a[14][3][7]=0;a[14][3][8]=0;a[14][3][9]=4;a[14][3][10]=0;
        a[14][3][12]=0;a[14][3][13]=2;a[14][3][14]=0;a[14][3][15]=0;

        a[15][3][0]=0;a[15][3][1]=0;a[15][3][2]=0;a[15][3][3]=0;a[15][3][4]=0;a[15][3][5]=4;
        a[15][3][6]=5;a[15][3][7]=0;a[15][3][8]=0;a[15][3][10]=2;a[15][3][11]=2;a[15][3][12]=2;
        a[15][3][13]=0;a[15][3][14]=0;a[15][3][15]=0;

        a[16][0][0]=2;a[16][0][5]=0;a[16][0][6]=0;a[16][0][7]=0;a[16][0][14]=0;a[16][0][15]=0;
        a[16][1][0]=0;a[16][1][5]=0;a[16][1][6]=0;a[16][1][7]=0;a[16][1][14]=0;a[16][1][15]=0;
        a[16][2][0]=0;a[16][2][1]=0;a[16][2][2]=0;a[16][2][3]=0;a[16][2][4]=0;a[16][2][5]=0;
        a[16][2][6]=0;a[16][2][7]=0;a[16][2][8]=0;a[16][2][9]=0;a[16][2][10]=0;a[16][2][11]=0;
        a[16][2][12]=0;a[16][2][13]=0;a[16][2][14]=0;a[16][2][15]=0;a[16][3][0]=0;a[16][3][1]=0;
        a[16][3][2]=0;a[16][3][3]=0;a[16][3][4]=0;a[16][3][5]=0;a[16][3][6]=0;a[16][3][7]=0;
        a[16][3][8]=0;a[16][3][9]=0;a[16][3][10]=0;a[16][3][11]=0;a[16][3][12]=0;a[16][3][13]=0;
        a[16][3][14]=0;a[16][3][15]=0;

        a[17][0][2]=0;a[17][0][6]=0;a[17][0][7]=0;a[17][0][14]=0;a[17][0][15]=0;a[17][1][1]=0;a[17][1][2]=0;
        a[17][1][4]=0;a[17][1][5]=3;a[17][1][6]=0;a[17][1][7]=0;a[17][1][8]=0;a[17][1][10]=0;a[17][1][14]=0;
        a[17][1][15]=0;a[17][2][0]=0;a[17][2][1]=0;a[17][2][2]=0;a[17][2][4]=0;a[17][2][6]=0;a[17][2][7]=0;
        a[17][2][8]=0;a[17][2][10]=0;a[17][2][12]=0;a[17][2][14]=0;a[17][2][15]=0;a[17][3][0]=0;a[17][3][1]=0;
        a[17][3][2]=0;a[17][3][4]=0;a[17][3][5]=0;a[17][3][6]=0;a[17][3][7]=0;a[17][3][8]=0;a[17][3][10]=0;
        a[17][3][11]=0;a[17][3][14]=0;a[17][3][15]=0;

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

            contentView= LayoutInflater.from(ContentActivity.this).inflate(R.layout.bookitem, null);

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

