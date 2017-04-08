package com.example.phduo.my626spots;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phduo on 3/11/2017.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Activity context, ArrayList<Category> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View categoryItemView = convertView;

        if(categoryItemView == null) {
            categoryItemView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        //Get the current category from the given position in the Category Array List
        Category current = getItem(position);

        if(current.hasIconID()) {
            ImageView imageview = (ImageView) categoryItemView.findViewById(R.id.category_icon);
            imageview.setImageResource(current.getIconID());
        }

        TextView textview = (TextView)categoryItemView.findViewById(R.id.category_text);
        textview.setText(current.getTitle());

        categoryItemView.setBackgroundResource(current.getColorID());

        return categoryItemView;


    }
}
