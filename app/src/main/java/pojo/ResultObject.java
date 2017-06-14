package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultObject<T> {

    @Expose
    @SerializedName("name")
    public String name;


    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("cod")
    public int cod;


    @Expose
    @SerializedName("dt")
    public long dt;

    @Expose
    @SerializedName("visibility")
    public int visibility;

    @Expose
    @SerializedName("base")
    public String base;

    @Expose
    @SerializedName("main")
    public T main;

    public T getMain() {
        return main;
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

}
