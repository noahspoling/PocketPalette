package net.androidbootcamp.pocketpalette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class PaletteMenu extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int palettePosition = 0;
        int colorPosition;
        PaletteModel paletteItem = new PaletteModel();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_menu);

        //handles getting extras from intent. If extras is null then doesn't assign extra values
        //to variables
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //extra string to get the context of what page the user is coming from
            //TODO there could be better methods to handle this.
            String activity = (String) extras.get("lastActivity");
            palettePosition = (int) extras.get("paletteIndex");
            if (activity == "colorsPage") {
                colorPosition = (int) extras.get("colorIndex");
            }
            //If Palette Item is clicked on Main Menu ListView get arraylist of colors
            if (activity == "paletteListClick") {
            }
            paletteItem = (PaletteModel) extras.get("paletteItem");
        }

        //xml layout references
        ListView colorsListView = findViewById(R.id.colorsListView);
        View namePalette = findViewById(R.id.editTextPaletteName);
        colorsListView.setEmptyView(findViewById(R.id.empty));

        ColorListAdapter array = new ColorListAdapter(this, paletteItem.getColorsList());

        //passed variables are requiring a final temporary variable to pass to next activity
        PaletteModel finalPaletteItem = paletteItem;
        int finalPalettePosition = palettePosition;


        //on click listener event
        colorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PaletteMenu.this, ColorMenu.class);
                intent.putExtra("paletteItem", finalPaletteItem);
                intent.putExtra("paletteIndex", finalPalettePosition);
                //colorCodes.remove(i);
                startActivity(intent);
            }
    });
         colorsListView.setAdapter(array);
         }
    /*
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } */
}