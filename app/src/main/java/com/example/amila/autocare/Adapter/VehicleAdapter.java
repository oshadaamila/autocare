package com.example.amila.autocare.Adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amila.autocare.Database.entities.Vehicle;
import com.example.amila.autocare.R;

import java.util.List;

/**
 * Created by pavilion 15 on 06-Mar-18.
 */

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder> {

    private Context mcontext;
    private List<Vehicle> vehicleList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_card,parent,
                false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Vehicle vehicle = vehicleList.get(position);
        holder.reg_no.setText(vehicle.getReg_no());
        holder.brand.setText(vehicle.getBrand());
        holder.model.setText(vehicle.getModel());
        holder.reg_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.reg_no);
            }
        });
    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mcontext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_vehicle, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mcontext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mcontext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView reg_no,brand,model;
        public MyViewHolder(View view){
            super(view);
            reg_no= view.findViewById(R.id.Reg_no);
            brand = view.findViewById(R.id.Brand);
            model = view.findViewById(R.id.model);
        }
    }
    public VehicleAdapter(Context mContext, List<Vehicle> vehicleList){
        this.mcontext = mContext;
        this.vehicleList = vehicleList;
    }

}
