/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package storm;
public class Storm {
    private final double KnotsToMPH = 1.15;
    private String stormID;
    private int beginDate;
    private int duration;
    private String name;
    private int category;
    private int wind;
    private int pressure;
    
    public Storm( String stormid, int bdate, int dur, String sname, int w, int p ){
        stormID = stormid;
        beginDate = bdate;
        duration = dur;
        name = sname;
        wind = (int)(w * KnotsToMPH);
        pressure = p;
        SaffirSimpson();

    }
    public void setDuration( int d ){
        duration = d;
    }

    public void setWind( int w ){
    w = (int)(w * KnotsToMPH);
    if(w > wind)
        wind = w;
    SaffirSimpson();
    }
    public void setPressure( int p ){
        // Set pressure by taking in an integer
        if(pressure <= 0)
            pressure = p;
        if(p > 0 && p < pressure)
            pressure = p;
        SaffirSimpson();
    }
    public void SaffirSimpson(){
        // Compute storm category, using the Saffir-Simpson scale
        if(pressure <= 920 && wind >= 156){
            category = 5;   // Category 5
        }
        if(pressure > 920 && wind < 156){
            category = 4;   // Category 4
        }
        if(pressure > 945 && wind < 113){
            category = 3;   // Category 3
        }
        if(pressure > 965 && wind < 96){
            category = 2;   // Category 2
        }
        if(pressure > 980 && wind < 83){
            category = 1;   // Category 1
        }
        if(wind < 64){
            category = -1;  // Tropical Storm
        }
        if(wind < 34){
            category = -2;  // Tropical Depression
        }
        if(pressure == 0){
            category = 0;   // Missing pressure
        }
    }
    public int getCategory(){
        return category;
    }
    public String toString() {
        return String.format("%s %9d %7d      %-10s %2d      %6d   %8d\n", stormID, beginDate, duration, name, category, wind, pressure);
    }
}