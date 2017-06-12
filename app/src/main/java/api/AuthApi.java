package api;


import java.util.List;

import pojo.MainData;
import pojo.ResultObject;
import pojo.ResultObject1;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AuthApi {

//    http://api.openweathermap.org/data/2.5/weather?lat=19&lon=72&units=metric&APPID=dcae12cb0488a2a684320828b6e1acc3

    @GET("weather")
    Call<ResultObject> currentData(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("units") String units,
            @Query("APPID") String APPID
    );

    @GET("forecast")
    Call<ResultObject1<List<MainData>>> forecastData(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("units") String units,
            @Query("APPID") String APPID
    );


}
