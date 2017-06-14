package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Main {

    @Expose
    @SerializedName("temp")
    public int temp;

    @Expose
    @SerializedName("pressure")
    public int pressure;

    @Expose
    @SerializedName("humidity")
    public int humidity;

    @Expose
    @SerializedName("temp_min")
    public int temp_min;

    @Expose
    @SerializedName("temp_max")
    public int temp_max;

    public int getTemp() {
        return temp;
    }


    public int getPressure() {
        return pressure;
    }


    public int getHumidity() {
        return humidity;
    }


    public int getTemp_min() {
        return temp_min;
    }


    public int getTemp_max() {
        return temp_max;
    }


}
