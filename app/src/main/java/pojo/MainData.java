package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kethan on 10/6/17.
 */

public class MainData {

    @Expose
    @SerializedName("main")
    private Main main;

    @Expose
    @SerializedName("dt")
    private long dt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    @Expose
    @SerializedName("weather")
    public Weather weather;

    public class Weather{

        @Expose
        @SerializedName("description")
        public String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

public class Main

    {

        @Expose
        @SerializedName("temp")
        private int temp;

        @Expose
        @SerializedName("pressure")
        private int pressure;

        @Expose
        @SerializedName("humidity")
        private int humidity;

        @Expose
        @SerializedName("temp_min")
        private int temp_min;

        @Expose
        @SerializedName("temp_max")
        private int temp_max;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int result) {
        this.temp_min = temp_min;
    }

    public int gettemp_max() {
        return temp_max;
    }

    public void settemp_max(int result) {
        this.temp_max = temp_max;
    }


    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
