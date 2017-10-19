package com.example.gnjoroge.ringthealarm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FireAdapter extends RecyclerView.Adapter<FireAdapter.FireView> {


    private ArrayList<Fire> fireData;
    private Context mContext;

    public FireAdapter(Context context, ArrayList<Fire> data) {
        this.fireData = data;
        mContext = context;
    }

    public class FireView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fireImage;
        TextView stationName;
        TextView stationLocation;
        TextView stationContacts;

        public FireView(View view) {
            super(view);
            this.fireImage = (ImageView) itemView.findViewById(R.id.imageView);
            this.stationName = (TextView) itemView.findViewById(R.id.textViewName);
            this.stationLocation = (TextView) itemView.findViewById(R.id.textViewLocation);
            this.stationContacts = (TextView) itemView.findViewById(R.id.textViewContact);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View args0){
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:020-23344559"));
            itemView.getContext().startActivity(phoneIntent);
        }
    }

    @Override
    public FireView onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the card view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        //create new instance of view holder
        FireView viewHolder = new FireView(view);
        return viewHolder;
    }




    @Override
public void onBindViewHolder(final FireView holder, final int listPosition) {
        ImageView fireImage = holder.fireImage;
        TextView stationName = holder.stationName;
        TextView stationLocation = holder.stationLocation;
        TextView stationContacts = holder.stationContacts;

        fireImage.setImageResource(fireData.get(listPosition).getImage());
        stationName.setText(fireData.get(listPosition).getName());
        stationLocation.setText(fireData.get(listPosition).getLocation());
     stationContacts.setText(fireData.get(listPosition).getContact());

    }

    @Override
    public int getItemCount(){
        return fireData.size();
    }
}
