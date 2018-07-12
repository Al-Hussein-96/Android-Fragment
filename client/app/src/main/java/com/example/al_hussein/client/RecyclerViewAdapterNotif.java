package com.example.al_hussein.client;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Al-Hussein on 7/4/2018.
 */

public class RecyclerViewAdapterNotif extends RecyclerView.Adapter<RecyclerViewAdapterNotif.MyViewHolder> {
    Context mContext;
    List<Event> aData;
    Dialog myDialog;

    public RecyclerViewAdapterNotif(Context mContext, List<Event> aData) {
        this.mContext = mContext;
        this.aData = aData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_notifications,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_notification);

        vHolder.item_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
                Toast.makeText(mContext,"Mohammad: " + String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_LONG);
            }
        });
        return vHolder;

    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event event = aData.get(position);


        holder.tv_name_event.setText(event.type);
        holder.tv_owner_event.setText(event.owner);
    }



    @Override
    public int getItemCount() {
        return aData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_notification;
        private TextView tv_name_event;
        private TextView tv_owner_event;
        private ImageView img;

        public MyViewHolder(View itemView){
            super(itemView);
            item_notification = (LinearLayout) itemView.findViewById(R.id.notification_item);
            tv_name_event = (TextView) itemView.findViewById(R.id.name_contact);
            tv_owner_event = (TextView) itemView.findViewById(R.id.phone_contact);
            img = (ImageView) itemView.findViewById(R.id.img_contact);
        }
    }


































}
