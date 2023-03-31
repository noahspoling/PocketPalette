package net.androidbootcamp.pocketpalette;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ColorListAdapter extends ArrayAdapter<String>{
    //call constructor of the array adapter class
    ColorListAdapter(@NonNull Context context, ArrayList<String> arrayList) {
        //uses super to pass arguments to constructor of ArrayAdapter
        super(context,0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //creates reuseable view from custom_list_object layout xml file
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_color_list_object, parent, false);
        }

        //get the position of the view from the adapter
        String currentPalettePosition = getItem(position);

        //assign text and hex code
        View colorView = currentItemView.findViewById(R.id.colorView);
        assert currentPalettePosition != null;
        colorView.setBackgroundColor(Color.parseColor(currentPalettePosition));
        TextView colorCode = currentItemView.findViewById(R.id.colorCode);
        colorCode.setText(currentPalettePosition);
        return currentItemView;
    }
}
