package com.example.oflinedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserDataAdapter extends BaseAdapter {

    ArrayList<UserModel> mylist;
    Context context;

    public UserDataAdapter(ArrayList<UserModel> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    LayoutInflater inflater;
    @Override
    public int getCount() {
        return mylist.size();
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
        convertView=inflater.inflate(R.layout.custom_list,null);
        TextView n=convertView.findViewById(R.id.n);
        TextView p=convertView.findViewById(R.id.p);

        String name=mylist.get(position).getName();
        String pass=mylist.get(position).getPassword();

        n.setText(name);
        p.setText(pass);
        return convertView;
    }
}
