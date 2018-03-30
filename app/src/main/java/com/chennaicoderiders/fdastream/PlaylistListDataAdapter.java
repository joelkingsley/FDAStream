package com.chennaicoderiders.fdastream;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by karthikeyansekar on 28/03/18.
 */

public class PlaylistListDataAdapter extends RecyclerView.Adapter<PlaylistListDataAdapter.SingleItemRowHolder>{
    private ArrayList<Video> itemsList;
    private Context mContext;

    public PlaylistListDataAdapter(Activity context, ArrayList<Video> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public PlaylistListDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        PlaylistListDataAdapter.SingleItemRowHolder mh = new PlaylistListDataAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(PlaylistListDataAdapter.SingleItemRowHolder holder, int i) {

        final Video singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.get_name());
        AssetManager assetManager = mContext.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {

            istr = assetManager.open("posters/gullivers_travels.jpg");

            bitmap = BitmapFactory.decodeStream(istr);
            holder.itemImage.setImageBitmap(bitmap);

        } catch (IOException e) {
            // handle exception
            e.printStackTrace();
        }

        Glide.with(mContext)
                .load(singleItem.get_image_url())
                .into(holder.itemImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DescriptionActivity.class);
                intent.putExtra("EXTRA_ID",singleItem.get_id());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = view.findViewById(R.id.tvTitle);
            this.itemImage = view.findViewById(R.id.itemImage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }
}
