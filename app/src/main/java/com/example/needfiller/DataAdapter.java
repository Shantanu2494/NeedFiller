package com.example.needfiller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.myViewHolder> {

    ArrayList<Data> dataList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public DataAdapter(ArrayList<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.type.setText(dataList.get(position).getType());
        holder.desc.setText(dataList.get(position).getDesc());
        holder.phone.setText(dataList.get(position).getPhone());
        holder.location.setText(dataList.get(position).getLocation());
        String id = dataList.get(position).getId();
        holder.delete.setOnClickListener(v -> {
            db.collection("Donations")
                    .document(id)
                    .delete().addOnSuccessListener(
                            unused ->
                                    Toast.makeText(holder.delete.getContext(), "Item deleted", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(
                            e ->
                                    Toast.makeText(holder.delete.getContext(), "something went wrong", Toast.LENGTH_SHORT).show());
            System.out.println("clicked");
            Intent intent = new Intent(holder.delete.getContext(), Receiver.class);
            holder.delete.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, type, desc, phone, location;
        Button delete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameV);
            type = itemView.findViewById(R.id.typeV);
            desc = itemView.findViewById(R.id.descV);
            phone = itemView.findViewById(R.id.phoneV);
            location = itemView.findViewById(R.id.locationV);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
