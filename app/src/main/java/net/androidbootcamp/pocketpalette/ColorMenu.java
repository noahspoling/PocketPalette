package net.androidbootcamp.pocketpalette;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorMenu extends AppCompatActivity {

    //Sets either selected color from palette or default color of #FFFFFF (white)
    String colorBackground = "#FFFFFF";
    String rHex = "FF";
    String gHex = "FF";
    String bHex = "FF";

    //function to handle low hexadecimal values. For example 10 as 0A instead of A
    public String getValueBelow15(int input) {
        String Hex = "00";
        if (input >= 16) {
            Hex = Integer.toHexString(input);
        } else {
            //bHex =  getValueBelow15(valueB);
            switch (input) {
                case 0:
                    Hex = "00";
                    break;
                case 1:
                    Hex = "01";
                    break;
                case 2:
                    Hex = "02";
                    break;
                case 3:
                    Hex = "03";
                    break;
                case 4:
                    Hex = "04";
                    break;
                case 5:
                    Hex = "05";
                    break;
                case 6:
                    Hex = "06";
                    break;
                case 7:
                    Hex = "07";
                    break;
                case 8:
                    Hex = "08";
                    break;
                case 9:
                    Hex = "09";
                    break;
                case 10:
                    Hex = "0A";
                    break;
                case 11:
                    Hex = "0B";
                    break;
                case 12:
                    Hex = "0C";
                    break;
                case 13:
                    Hex = "0D";
                    break;
                case 14:
                    Hex = "0E";
                    break;
                case 15:
                    Hex = "0F";
                    break;
            }
        }
        return Hex;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_menu);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String name = (String) extras.get("PaletteName");
            String type = (String) extras.get("PaletteType");
            ArrayList<String> colors = (ArrayList<String>) extras.get("Colors List");
        }

        //default to 1st view

        final Button[] currentHexCode = {findViewById(R.id.viewButton1)};
        final View[] currentColor = {findViewById(R.id.colorPreview1)};
        View colorPreview1 = findViewById(R.id.colorPreview1);
        View colorPreview2 = findViewById(R.id.colorPreview2);
        View colorPreview3 = findViewById(R.id.colorPreview3);
        View colorPreview4 = findViewById(R.id.colorPreview4);
        View colorPreview5 = findViewById(R.id.colorPreview5);
        View colorPreview6 = findViewById(R.id.colorPreview6);
        Button option1 = findViewById(R.id.viewButton1);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview1;
                currentHexCode[0] = option1;
            }
        });
        Button option2 = findViewById(R.id.viewButton2);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview2;
                currentHexCode[0] = option2;
            }
        });
        Button option3 = findViewById(R.id.viewButton3);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview3;
                currentHexCode[0] = option3;
            }
        });
        Button option4 = findViewById(R.id.viewButton4);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview4;
                currentHexCode[0] = option4;
            }
        });
        Button option5 = findViewById(R.id.viewButton5);
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview5;
                currentHexCode[0] = option5;
            }
        });
        Button option6 = findViewById(R.id.viewButton6);
        option6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentColor[0] = colorPreview6;
                currentHexCode[0] = option6;
            }
        });

        //TextView hexLabel = findViewById(R.id.colorHexLabel1);
        /*
        EditText rHexEditText = findViewById(R.id.rHexEditText);
        rHexEditText.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});
        EditText gHexEditText = findViewById(R.id.gHexEditText);
        gHexEditText.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});
        EditText bHexEditText = findViewById(R.id.bHexEditText);
        bHexEditText.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});
        Button setColorButton = findViewById(R.id.setColorBtn);
        setColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("STATE", "Clicked button");
                int valueR = Integer.parseInt(rHexEditText.getText().toString());
                Log.d("STATE", "ValueR: " +valueR);
                if (valueR > 15) {
                    rHex = Integer.toHexString(valueR);
                }
                else {
                    rHex = getValueBelow15(valueR);
                }
                Log.d("STATE", "ValueR: " +rHex);
                int valueG = Integer.parseInt(gHexEditText.getText().toString());
                if (valueG > 16) {
                    gHex = Integer.toHexString(valueG);
                }
                else {
                    gHex = getValueBelow15(valueG);
                }
                int valueB = Integer.parseInt(bHexEditText.getText().toString());
                if (valueG > 16) {
                    bHex = Integer.toHexString(valueB);
                }
                else {
                    bHex =  getValueBelow15(valueB);
                } /*
                int valueR = Integer.parseInt(rHexEditText.getText().toString());
                rHex = Integer.toHexString(valueR);
                int valueG = Integer.parseInt(gHexEditText.getText().toString());
                gHex = Integer.toHexString(valueG);
                int valueB = Integer.parseInt(bHexEditText.getText().toString());
                bHex = Integer.toHexString(valueB);
                //Log.println();
                Log.d("STATE", "Hex: " +rHex+ " "+gHex+" "+bHex);
                String colorBackground = "#" + rHex + gHex + bHex;
                Log.d("STATE", "ColorBackground: " +colorBackground);
                currentColor[0].setBackgroundColor(Color.parseColor(colorBackground));
                currentHexCode[0].setText(colorBackground);
            }
        });
        */
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String rHex = getValueBelow15(seekBar.getProgress());
                String gHex = getValueBelow15(greenSeekBar.getProgress());
                String bHex = getValueBelow15(blueSeekBar.getProgress());
                colorBackground = "#" + rHex + gHex + bHex;
                Log.d("STATE", "color rHex: "+rHex);
                Log.d("STATE", "color background: "+colorBackground);
                currentColor[0].setBackgroundColor(Color.parseColor(colorBackground));
                currentHexCode[0].setText(colorBackground);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String rHex = getValueBelow15(redSeekBar.getProgress());
                String gHex = getValueBelow15(seekBar.getProgress());
                String bHex = getValueBelow15(blueSeekBar.getProgress());
                colorBackground = "#" + rHex + gHex + bHex;
                Log.d("STATE", "color gHex: "+gHex);
                Log.d("STATE", "color background: "+ colorBackground);
                currentColor[0].setBackgroundColor(Color.parseColor(colorBackground));
                currentHexCode[0].setText(colorBackground);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String rHex = getValueBelow15(redSeekBar.getProgress());
                String gHex = getValueBelow15(greenSeekBar.getProgress());
                String bHex = getValueBelow15(seekBar.getProgress());
                colorBackground = "#" + rHex + gHex + bHex;
                Log.d("STATE", "color bHex: "+bHex);
                Log.d("STATE", "color background: "+colorBackground);
                currentColor[0].setBackgroundColor(Color.parseColor(colorBackground));
                currentHexCode[0].setText(colorBackground);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}