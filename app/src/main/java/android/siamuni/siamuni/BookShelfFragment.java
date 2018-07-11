package android.siamuni.siamuni;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookShelfFragment extends Fragment {
    private static String TAG="BookShelfFragment";
    private GridView bookShelf;
    private int[] data;
    private int[] cno;
    private int num;
    private Button btnlogin;
    private Button resetButton,loginButton;
    SharedPreferences sp;
    private String[] name;
    private String[] allName={
            "Economics and Philosophy of Sufficiency Economy","The main logic and thinking skills for lifelong learning","Psychology in Everyday Life","Human relations and personality development","civilization studies","Philosophy and religion to dominate their lives",
            "ASEAN in the modern world","Thailand to use language to communicate","Thailand language presentation","information technology","Computers for Education","Uruguay's Environment",
            "Mathematics in Daily Life","Preliminary statistics for analysis","Physical Education and Recreation","Study Art and Music Appreciation","English 1","English 2"
    };

    public BookShelfFragment() {
        // Required empty public constructor
    }

    public static BookShelfFragment newInstance() {
        BookShelfFragment fragment = new BookShelfFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_shelf, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] course=new String[18];

        resetButton = getView().findViewById(R.id.btn_reset);
        loginButton = getView().findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(i1);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("flag","0");
                for (int i=1;i<=18;i++){
                    editor.putString("sub"+i,"0");
                    editor.apply();
                    Intent intent = new Intent(getActivity(),SelectActivity.class);
                    startActivity(intent);
                }
            }
        });

        num=0;
        //获得SP里保存的数据
        sp=this.getActivity().getSharedPreferences("subnum", Activity.MODE_PRIVATE);
        for(int i=1;i<=18;i++){
            String a="sub"+i;
            course[i-1]=sp.getString(a,"0");
            if(course[i-1].equals("1")){
                num++;
            }
        }
        Log.i(TAG, "onActivityCreated: num="+num);

        data=new int[num];
        name=new String[num];
        cno=new int[num];

        for(int i=0;i<num;i++){
            data[i]=R.drawable.cover_txt;
        }
        int j=0;
        for(int i=0;i<16;i++){
            if(course[i].equals("1")){
                name[j]=allName[i];
                cno[j]=i;
                Log.i(TAG, "onActivityCreated: name["+j+"]="+name[j]);
                Log.i(TAG, "onActivityCreated: cno["+j+"]="+cno[j]);
                j++;
            }
        }
        bookShelf = getView().findViewById(R.id.bookShelf);
        ShelfAdapter adapter=new ShelfAdapter();
        bookShelf.setAdapter(adapter);
        bookShelf.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Log.i("onItemClick", "onItemClick: arg0="+arg0);
                Log.i("onItemClick", "onItemClick: arg1="+arg1);
                Log.i("onItemClick", "onItemClick: arg2="+arg2);
                Log.i("onItemClick", "onItemClick: arg3="+arg3);
                if(arg2<data.length){
                    Toast.makeText(getActivity(), ""+arg2, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),CourseActivity.class);
                    intent.putExtra("courseName",name[arg2]);
                    intent.putExtra("courseNo",cno[arg2]);
                    Log.i(TAG, "onItemClick: courseName="+name[arg2]);
                    Log.i(TAG, "onItemClick: courseNo="+cno[arg2]);

                    startActivity(intent);
                }
            }
        });

    }
    /*public void onClick(View v){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("flag","0");
        for (int i=1;i<=18;i++){
            editor.putString("sub"+i,"0");
            Intent intent = new Intent(getActivity(),SelectActivity.class);
            startActivity(intent);
        }
    }*/

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

            contentView=LayoutInflater.from(getActivity()).inflate(R.layout.bookitem, null);

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
