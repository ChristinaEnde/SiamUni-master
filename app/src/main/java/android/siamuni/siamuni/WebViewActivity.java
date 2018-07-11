package android.siamuni.siamuni;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    String TAG="WebViewActivity";
    int courseNo;
    int docTypeNo;
    int weekNo;
    int classNum;
    String course;
    String week;
    String courseUrl;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }


        Intent intent=getIntent();
        courseNo=intent.getIntExtra("courseNo",0);
        docTypeNo=intent.getIntExtra("docTypeNo",0);
        weekNo=intent.getIntExtra("weekNo",0);
        classNum=intent.getIntExtra("classNum",0);
        Log.i(TAG, "onCreate: courseNo="+courseNo);
        Log.i(TAG, "onCreate: docTypeNo="+docTypeNo);
        Log.i(TAG, "onCreate: weekNo="+weekNo);
        Log.i(TAG, "onCreate: classNum="+classNum);


        if(courseNo<10) course="0"+courseNo;
        if(weekNo<10) week="0"+weekNo;
        courseUrl="c"+course+docTypeNo+week+classNum;
        Log.i("", "onCreate: courseUrl="+courseUrl);


        //获取对应字符串资源id
        int id=getStringId(WebViewActivity.this,courseUrl);
        if(docTypeNo==0||docTypeNo==3){
            url="";
            url=url+getString(id);
            Uri uri = Uri.parse(url);
            Intent in = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(in);
        }else{
            url="http://docs.google.com/gview?embedded=true&url=";
            url=url+getString(id);
            WebView urlWebView = (WebView) findViewById(R.id.docPreview);
            urlWebView.getSettings().setJavaScriptEnabled(true);
            urlWebView.setWebViewClient(new AppWebViewClients());
            urlWebView.loadUrl(url);
            Log.i("", "onCreate: "+url);
        }




        //"http://view.officeapps.live.com/op/view.aspx?src="+ "YOUR_DOC_URL_HERE"
        //"http://docs.google.com/gview?embedded=true&url="
        //http://gened.siam.edu/wp-content/uploads/2010/06/ASEAN_lecture_1.ppt
    }

    public static int getStringId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "string", context.getPackageName());
    }

    public class AppWebViewClients extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }

}
