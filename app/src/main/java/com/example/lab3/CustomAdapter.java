package com.example.lab3;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    private int icons[];
    private Context context;

    public CustomAdapter(Context context, int icons[]) {
        this.context = context;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imView  = new ImageView(context);
        imView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //imView.setPadding(10,10,10,10);
        imView.setLayoutParams(new GridView.LayoutParams(350,350));
        imView.setImageResource(icons[position]);
        imView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View) View.inflate(context,R.layout.dialog,null);
                AlertDialog.Builder adb =new AlertDialog.Builder(context);
                ImageView imageView = (ImageView) dialogView.findViewById(R.id.dialogImage);
                imageView.setImageResource(icons[position]);
                String name = context.getResources().getResourceEntryName(icons[position]);
                adb.setTitle(name);
                adb.setIcon(R.drawable.icon);
                adb.setView(dialogView);
                adb.setNegativeButton("Close",null);
                adb.show();
            }
        });
        return imView;
    }
}
