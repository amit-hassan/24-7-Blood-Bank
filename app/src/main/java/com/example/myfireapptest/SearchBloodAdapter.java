package com.example.myfireapptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchBloodAdapter extends RecyclerView.Adapter<SearchBloodAdapter.MyViewHolder>{

    private Context context;
    private List<Request> requestList;
    //private ImageView image;

    //Making a Constructor


    public SearchBloodAdapter(Context context, List<Request> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.search_blood_sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.imageView.setImageResource(image[position]);
        holder.name.setText(requestList.get(position).getName());
        holder.address.setText(requestList.get(position).getAddress());
        holder.bloodAmount.setText(requestList.get(position).getAmountSpinnerValue());
        holder.phoneNumber.setText(requestList.get(position).getMobile());
        holder.bloodGroup.setText(requestList.get(position).getSpinnerValue());


    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,address,bloodGroup,bloodAmount,phoneNumber;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewId);
            name = itemView.findViewById(R.id.nameTextViewId);
            address = itemView.findViewById(R.id.addressTextViewId);
            bloodAmount = itemView.findViewById(R.id.bloodAmountTextViewId);
            phoneNumber = itemView.findViewById(R.id.phnTextViewId);
            bloodGroup = itemView.findViewById(R.id.bloodGroupTextViewId);
        }
    }
}
