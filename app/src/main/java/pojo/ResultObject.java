package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultObject {

    @Expose
    @SerializedName("message")
    public String message;

    @Expose
    @SerializedName("result")
    public int result;

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

    public void setMain(Main main) {
        this.main = main;
    }

    @Expose
    @SerializedName("main")
    public Main main;

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

        public int getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(int result) {
            this.temp_max = temp_max;
        }

    }


    @Expose
    @SerializedName("errors")
    public List<String> errors;


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


    public Main getMain() {
        return main;
    }

    public void setmain(Main main) {
        this.main = main;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
