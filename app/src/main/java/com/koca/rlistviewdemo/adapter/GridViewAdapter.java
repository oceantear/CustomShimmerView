/**
 * Copyright 2017 Harish Sridharan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.koca.rlistviewdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.koca.rlistviewdemo.R;

import java.util.HashMap;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private List<HashMap<String, String>> items;

    public void setItems(List<HashMap<String, String>> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public GridViewAdapter(List<HashMap<String, String>> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_grid_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt_01.setText(items.get(position).get("name"));
        holder.txt_02.setText(items.get(position).get("address"));
        holder.txt_03.setText(items.get(position).get("about"));
        Glide.with(holder.itemView.getContext()).load("http://www.youbike.com.tw/img/default.png").into(holder.img_01);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_01;
        TextView txt_02;
        TextView txt_03;
        ImageView img_01;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_01 = itemView.findViewById(R.id.txt_01);
            txt_02 = itemView.findViewById(R.id.txt_02);
            txt_03 = itemView.findViewById(R.id.txt_03);
            img_01 = itemView.findViewById(R.id.img_01);
        }
    }
}
