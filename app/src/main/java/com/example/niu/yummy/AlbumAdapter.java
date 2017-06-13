package com.example.niu.yummy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import android.view.View.OnClickListener;
/**
 * Created by 路人 on 2017/5/14.
 */

public class AlbumAdapter extends ArrayAdapter<PutPtr> {
    private Context context;

    public AlbumAdapter(Context context, List objects) {
        super(context,0,objects);
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= LayoutInflater.from(context);
        LinearLayout itemlayout=null;
        if(convertView==null)
        {
            itemlayout=(LinearLayout)inflater.inflate(R.layout.listitem,null);
        }else{
            itemlayout=(LinearLayout)convertView;
        }
        PutPtr item=(PutPtr) getItem(position);

        ImageButton host=(ImageButton)itemlayout.findViewById(R.id.imgButton1);
        private OnClickListener ptrUrl=new OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("http://mp.weixin.qq.com/s/Xlnylj4RXxT28d0qO4E3nQ");
                Intent intent=new Intent();
                intent.putExtra("ResUri",uri);

            }
        }
        host.setImageResource(item.getPictureId());
        return itemlayout;
    }
}
