package com.example.niu.yummy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class ResActivity2 extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button main_button = (Button) findViewById(R.id.main_btn);
        main_button.setOnClickListener(back_main);
        Button cuisine_button = (Button) findViewById(R.id.cuisine_btn);
        cuisine_button.setOnClickListener(cuisine);

        ArrayList<PutPtr> ResItem = new ArrayList<PutPtr>();
        ResItem.add(new PutPtr(R.drawable.res_p1, "http://mp.weixin.qq.com/s/qXuXhBu6nuvWleKnrWbUFA"));
        ResItem.add(new PutPtr(R.drawable.res_p2, "http://mp.weixin.qq.com/s/Xlnylj4RXxT28d0qO4E3nQ"));
        ResItem.add(new PutPtr(R.drawable.res_p3, "http://mp.weixin.qq.com/s/Qc1-xFkhC34YSP1IAHVWpwv"));
        AlbumAdapter adapter = new AlbumAdapter(this, ResItem);
        lv = (ListView) findViewById(R.id.res);
        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(itemclick);
    }
        /*OnItemClickListener itemclick=new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url=null;
                switch (i){
                    case 0:
                        //tv=(TextView)findViewById(R.id.tv_url);
                        url="http://mp.weixin.qq.com/s/qXuXhBu6nuvWleKnrWbUFA";
                        //Toast.makeText(ResActivity2.this,url,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //tv=(TextView)findViewById(R.id.tv_url);
                        url="http://mp.weixin.qq.com/s/Xlnylj4RXxT28d0qO4E3nQ";
                        //Toast.makeText(ResActivity2.this,url,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //tv=(TextView)findViewById(R.id.tv_url);
                        url="http://mp.weixin.qq.com/s/Qc1-xFkhC34YSP1IAHVWpwv";
                        //Toast.makeText(ResActivity2.this,url,Toast.LENGTH_SHORT).show();
                        break;
                }
                Intent intent=new Intent();
                intent.setClass(ResActivity2.this,WebViewActivity2.class);
                intent.putExtra("uri", url);
                startActivity(intent);
            }
        };*/
            /*TextView tv;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url=null;
                switch (i){
                    case 0:
                        tv=(TextView)findViewById(R.id.tv_url);
                        //url="http://mp.weixin.qq.com/s/qXuXhBu6nuvWleKnrWbUFA";
                        Toast.makeText(ResActivity2.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        tv=(TextView)findViewById(R.id.tv_url);
                        //url="http://mp.weixin.qq.com/s/Xlnylj4RXxT28d0qO4E3nQ";
                        //Toast.makeText(ResActivity2.this,url,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        tv=(TextView)findViewById(R.id.tv_url);
                        //url="http://mp.weixin.qq.com/s/Qc1-xFkhC34YSP1IAHVWpwv";
                        //Toast.makeText(ResActivity2.this,url,Toast.LENGTH_SHORT).show();
                        break;
                }
                interceptHyperLink(tv);
                Intent intent=new Intent();
                intent.setClass(ResActivity2.this,WebViewActivity.class);
                intent.putExtra(WebViewActivity.WEB_URL,url);
                startActivity(intent);
            }
        })*/
    private View.OnClickListener back_main=new View.OnClickListener() {
        @Override
        public void onClick(View view) {Intent intent=new Intent();
            intent.setClass( ResActivity2.this,
                    MainActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener cuisine=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(ResActivity2.this,
                    CuisineActivity2.class);
            startActivity(intent);
        }
    };
    private void interceptHyperLink(TextView tv) {

        tv.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tv.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable spannable = (Spannable) tv.getText();
            URLSpan[] urlSpans = spannable.getSpans(0, end, URLSpan.class);
            if (urlSpans.length == 0) {
                return;
            }

            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            // 循环遍历并拦截 所有http://开头的链接
            for (URLSpan uri : urlSpans) {
                String url = uri.getURL();
                if (url.indexOf("http://") == 0) {
                    CustomUrlSpan customUrlSpan = new CustomUrlSpan(this,url);
                    spannableStringBuilder.setSpan(customUrlSpan, spannable.getSpanStart(uri),
                            spannable.getSpanEnd(uri), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            }
            tv.setText(spannableStringBuilder);
        }
    }
    public class CustomUrlSpan extends ClickableSpan {
        private Context context;
        private String url;

        public CustomUrlSpan(Context context, String url) {
            this.context = context;
            this.url = url;
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context,WebViewActivity.class);
            intent.putExtra(WebViewActivity.WEB_URL,url);
            context.startActivity(intent);
        }
    }
}
