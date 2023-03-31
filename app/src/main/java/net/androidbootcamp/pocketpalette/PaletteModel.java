package net.androidbootcamp.pocketpalette;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class PaletteModel implements Serializable {

    //fields
    private String paletteName;
    private String paletteType;
    private ArrayList<String> colorsList;

    //default constructor for data model class
    public PaletteModel() {
        this.paletteName = "new palette";
        this.paletteType = "Custom";
        this.colorsList = new ArrayList<String>();
    }
    public PaletteModel(String paletteName) {
        this.paletteName = paletteName;
        this.paletteType = "Custom";
        this.colorsList = new ArrayList<String>();
    }
    //overloaded constructor for creating new data model from arraylist<String>
    public PaletteModel(String paletteName, String paletteType, ArrayList<String> colorsList) {
        this.paletteName = paletteName;
        this.paletteType = paletteType;
        this.colorsList = colorsList;
    }

    // get/set methods
    public String getPaletteName() {
        return this.paletteName;
    }
    public void setPaletteName(String paletteName) {
        this.paletteName = paletteName;
    }
    public String getPaletteType() {
        return this.paletteType;
    }
    public void setPaletteType() {
        this.paletteType = paletteType;
    }
    public ArrayList<String> getColorsList() {
        return this.colorsList;
    }
    public void setColorsList(ArrayList<String> colorsList) {
        this.colorsList = colorsList;
    }
    public void setColorsList() {
        this.colorsList = colorsList;
    }

    //uses first color in list
    public String getFirstColor() {
        //If list of hex colors is empty return white hex code
        if (this.colorsList.isEmpty() == true) {
            return "#FFFFFF";
        }
        else {
            return this.colorsList.get(0);
        }
    }
}
