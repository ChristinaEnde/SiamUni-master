package android.siamuni.siamuni;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Academics_MBAActivity extends AppCompatActivity {

    ListView myListView;
    List<String> itemString=new ArrayList<String>();
    List <Object> itemImage=new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics_mba);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }


        ArrayList<HashMap<String, Object>> listItem =new ArrayList<HashMap<String, Object>>();
        myListView = (ListView) findViewById(R.id.listView_academicsMBA);

        HashMap <String, Object> itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_1_itemtitle));
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_2_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_3_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_5_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_4_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_6_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_7_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString",getApplication().getString(R.string.academics_bba_8_itemtitle) );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);


        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this,listItem,R.layout.admissionitemlayout, new String[] {  "itemString" ,"itemImage2"},
                new int[] { R.id.textView_admissionItem,R.id.imageView_admissionItem2 });

        myListView.setAdapter(mySimpleAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                Intent one=null;
                switch (arg2){
                    case 0:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_1_string);
                        break;
                    case 1:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_2_string);
                        break;
                    case 2:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_3_string);
                        break;
                    case 3:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_4_string);
                        break;
                    case 4:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_5_string);
                        break;
                    case 5:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_6_string);
                        break;
                    case 6:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_7_string);
                        break;
                    case 7:one=new Intent(Academics_MBAActivity.this,Academics_DetailActivity.class);
                        one.putExtra("stringsid",R.string.academics_mba_8_string);
                        break;
                }
                startActivity(one);
            }
        });
    }
}
