package com.rohan.actorinfo.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rohan.actorinfo.R;

import com.rohan.actorinfo.constants.Constants;
//import com.rohan.actorinfo.databinding.ListItemRowBinding;
import com.rohan.actorinfo.home.model.HeroModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HeroViewHolder> {

    private Context context;
    private List<HeroModel> list;


    public HomeListAdapter(Context context, List<HeroModel> heroList) {
        this.context= context;
        this.list = heroList;
    }



    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(context);
        View view = layoutInflater.inflate(
                R.layout.list_item_row, viewGroup, false);

       // ListItemRowBinding itemBinding = ListItemRowBinding.inflate(layoutInflater,viewGroup,false);
        return new HeroViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder viewHolder, int i) {

        viewHolder.bind(i);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class HeroViewHolder extends RecyclerView.ViewHolder {

          //ListItemRowBinding mBinding;

        private LinearLayout linearLayout;
        private ImageView imageView;
        private TextView textView;
        private ProgressBar imageLoader;

//        public HeroViewHolder(ListItemRowBinding mBinding) {
//            super(mBinding.getRoot());
//            this.mBinding = mBinding;
//        }

        public HeroViewHolder(View itemView){
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_view);
            imageView = itemView.findViewById(R.id.image_view);
            imageLoader = itemView.findViewById(R.id.image_loader);
            textView = itemView.findViewById(R.id.text_view);

        }

        private void bind(final int position){

            if (!TextUtils.isEmpty(list.get(position).getImageurl())){
                imageLoader.setVisibility(View.VISIBLE);
                Picasso.get()
                        .load(list.get(position).getImageurl())
                        .fit().centerCrop()
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                                imageLoader.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Exception e) {
                                imageLoader.setVisibility(View.GONE);
                            }
                        });
            }

            textView.setText(list.get(position).getName());
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,HomeDetailActivity.class);
                    intent.putExtra(Constants.ITEM_ID,list.get(position).getId());
                    context.startActivity(intent);
                }
            });
        }

    }
}
