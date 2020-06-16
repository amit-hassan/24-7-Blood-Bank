package com.example.myfireapptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int flag;
    String[] ambulanceNames;
    String[] ambulanceDescription;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] ambulanceNames, String[] ambulanceDescription,int flag){
        this.context = context;
        this.ambulanceNames = ambulanceNames;
        this.ambulanceDescription = ambulanceDescription;
        this.flag = flag;
    }


    @Override
    public int getCount() {
        return ambulanceNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ambulance_sampleview,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.imageViewId);
        TextView ambulanceName = convertView.findViewById(R.id.ambulance_nameId);
        /* ambulanceName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ambulance, 0, 0, 0);
         */
        TextView ambulanceDesc = convertView.findViewById(R.id.ambulance_descId);
        /*ambulanceDesc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.location,0,0,0);*/

        imageView.setImageResource(flag);
        ambulanceName.setText(ambulanceNames[position]);
        ambulanceDesc.setText(ambulanceDescription[position]);

        return convertView;
    }
}
