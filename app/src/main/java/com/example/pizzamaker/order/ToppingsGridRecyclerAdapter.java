package com.example.pizzamaker.order;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzamaker.R;
import com.example.pizzamaker.model.Topping;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Justin Dang on 8/11/2017.
 */

public class ToppingsGridRecyclerAdapter extends RecyclerView.Adapter<ToppingsGridRecyclerAdapter.ToppingViewHolder> {

    //member variables
    private Context context;
    private List<Topping> selectedToppings;

    //constructor
    public ToppingsGridRecyclerAdapter(Context context ,List<Topping> selectedToppings) {
        this.context = context;
        this.selectedToppings = selectedToppings;
    }


    public ToppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topping_card, parent, false);
        return new ToppingViewHolder(v);
    }

    //binds the values of the
    public void onBindViewHolder(ToppingViewHolder holder, int position) {
        Topping topping = selectedToppings.get(position);
        holder.toppingName.setText(topping.getName());
        holder.toppingImage.setBackgroundColor(topping.getColor());
        //image loader
        Picasso.with(context)
                .load(topping.getImageUrl())
                .placeholder(new ColorDrawable(topping.getColor()))
                .error(new ColorDrawable(topping.getColor()))
                .into(holder.toppingImage);
    }

    @Override
    //get the number of selected toppings
    public int getItemCount() {
        if (selectedToppings == null) {
            return 0;
        }
        return selectedToppings.size();
    }

    //ToppingViewHolder
    public static class ToppingViewHolder extends RecyclerView.ViewHolder {
        public ImageView toppingImage;
        public TextView toppingName;

        public ToppingViewHolder(View itemView) {
            super(itemView);
            toppingImage = (ImageView) itemView.findViewById(R.id.image_topping);
            toppingName = (TextView) itemView.findViewById(R.id.text_topping_name);
        }
    }

}
