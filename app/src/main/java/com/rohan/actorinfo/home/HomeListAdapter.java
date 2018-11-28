package com.rohan.actorinfo.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohan.actorinfo.constants.Constants;
import com.rohan.actorinfo.databinding.ListItemRowBinding;
import com.rohan.actorinfo.home.model.HeroModel;
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

        ListItemRowBinding itemBinding = ListItemRowBinding.inflate(layoutInflater,viewGroup,false);
        return new HeroViewHolder(itemBinding);

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

          ListItemRowBinding mBinding;

        public HeroViewHolder(ListItemRowBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        private void bind(final int position){

            if (!TextUtils.isEmpty(list.get(position).getImageurl())){
                Picasso.get()
                        .load(list.get(position).getImageurl())
                        .transform(new CropCircleTransformation())
                        .into(mBinding.imageView);
            }

              mBinding.textView.setText(list.get(position).getName());
            mBinding.parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,HomeDetailActivity.class);
                    intent.putExtra(Constants.ITEM_ID,list.get(position).getImageurl());
                    context.startActivity(intent);
                }
            });
        }

    }
}
