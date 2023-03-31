package net.androidbootcamp.pocketpalette;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PaletteAdapter extends ArrayAdapter<PaletteModel> {

    //call constructor of the array adapter class
    PaletteAdapter(@NonNull Context context, ArrayList<PaletteModel> arrayList) {
        //uses super to pass arguments to constructor of ArrayAdapter
        super(context,0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //creates reuseable view from custom_list_object layout xml file
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_object, parent, false);
        }

        //get the position of the view from the adapter
        PaletteModel currentPalettePosition = getItem(position);

        //assign text and hex code
        View colorView = currentItemView.findViewById(R.id.colorView);
        assert currentPalettePosition != null;
        colorView.setBackgroundColor(Color.parseColor(currentPalettePosition.getFirstColor()));
        TextView paletteName = currentItemView.findViewById(R.id.listItemPaletteName);
        TextView paletteType = currentItemView.findViewById(R.id.listItemPaletteType);
        paletteName.setText(currentPalettePosition.getPaletteName());
        paletteType.setText(currentPalettePosition.getPaletteType());

        return currentItemView;
    }
}
