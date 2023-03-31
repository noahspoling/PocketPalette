package net.androidbootcamp.pocketpalette;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class MainMenu extends AppCompatActivity {



    /*
    public ArrayList<PaletteModel> paletteNames = new ArrayList<PaletteModel>();
    ArrayList<String> data1 = new ArrayList<String>(Arrays.asList("#D9D9D9", "#FFFFFF"));
    ArrayList<String> data2 = new ArrayList<String>(Arrays.asList("#FFFF00", "#FFFFFF"));

    {
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data1));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data1));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data1));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name", "Custom", data2));
    paletteNames.add(new PaletteModel("Palette Name"));
    }
     */

    public void WriteData(ArrayList<PaletteModel> data) {
        ArrayList<PaletteModel> fileContents = data;
        try{
            FileOutputStream writeData = new FileOutputStream("paletteData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(fileContents);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<PaletteModel> OpenData() {
        try{
            FileInputStream readData = new FileInputStream("paletteData.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<PaletteModel> data = (ArrayList<PaletteModel>) readStream.readObject();
            readStream.close();
            System.out.println(data.toString());
            return data;
        }catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<PaletteModel>();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //creates PaletteModel array list from saved data
        ArrayList<PaletteModel> paletteNames = OpenData();

        //create variables and assigns them if intent extras is not null
        String name;
        String type;
        ArrayList<String> colors = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = (String) extras.get("PaletteName");
            type = (String) extras.get("PaletteType");
            colors = (ArrayList<String>) extras.get("Colors List");
            //takes extra intent values and adds it to a palettemodel and adds it to the arraylist
            paletteNames.add(new PaletteModel(name, type, colors));
        }
        ListView paletteListView;
        paletteListView = findViewById(R.id.paletteList);
        paletteListView.setEmptyView(findViewById(R.id.empty));
        PaletteAdapter array
                = new PaletteAdapter(this, paletteNames);
        paletteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //passes PaletteModel object and index position to
                PaletteModel paletteItem = paletteNames.get(i);
                Intent intent = new Intent(MainMenu.this, PaletteMenu.class);
                intent.putExtra("PaletteIndex", i);
                intent.putExtra("PaletteItem", paletteItem);
                startActivity(intent);
            }
        });

        Button addPaletteBtn = findViewById(R.id.mainAddPaletteBtn);
        addPaletteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this, PaletteMenu.class));
            }
        });
        paletteListView.setAdapter(array);

    }

}