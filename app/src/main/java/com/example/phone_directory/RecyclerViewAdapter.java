package com.example.phone_directory;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    public ArrayList<model> modelArrayList;
    public Context context;

    public RecyclerViewAdapter(ArrayList<model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        model modal = modelArrayList.get(position);
        holder.titletxt.setText(modal.getTitle());
        holder.bodytxt.setText(modal.getBody());
        holder.mobile.setText(modal.getMobile());
        holder.initials.setText(String.valueOf(modal.getBody().charAt(0)));
        holder.initials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent person_details= new Intent((Activity) context,ViewPerson.class);
                person_details.putExtra("name", modal.getBody());
                person_details.putExtra("designation", modal.getDesignation());
                person_details.putExtra("department", modal.getDepartment());
                person_details.putExtra("id", modal.getTitle());
                person_details.putExtra("mobile", modal.getMobile());
                person_details.putExtra("emptype", modal.getEmptype());
                context.startActivity(person_details);


            }
        });
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = modal.getMobile();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));

                if (Build.VERSION.SDK_INT > 23) {
                    context.startActivity(intent);
                } else {

                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(context, "Permission Not Granted ", Toast.LENGTH_SHORT).show();
                    } else {
                        final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                        ActivityCompat.requestPermissions((Activity) context, PERMISSIONS_STORAGE, 9);
                        context.startActivity(intent);
                    }
                }
            }
        });



        
    }


    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void filterList(ArrayList<model> filteredList){
        modelArrayList=filteredList;
        notifyDataSetChanged();
    }



    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView titletxt,bodytxt,mobile;
        FloatingActionButton call;
        TextView initials;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            titletxt = itemView.findViewById(R.id.titletxt);
            bodytxt = itemView.findViewById(R.id.bodytxt);
            mobile = itemView.findViewById(R.id.mobile);
            call = itemView.findViewById(R.id.call);
            initials=itemView.findViewById(R.id.initials);

        }
    }
}

