package com.example.niu.yummy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;
import android.view.View.OnClickListener;
/**
 * Created by 路人 on 2017/5/14.
 * 处理listview的adapter
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

        ImageView host=(ImageView) itemlayout.findViewById(R.id.iv);
        host.setImageResource(item.getPictureId());
        TextView ptr_url=(TextView)itemlayout.findViewById(R.id.tv_url);
        ptr_url.setText(item.getPtr_url());
        return itemlayout;
    }
}
