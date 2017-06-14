package fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kethan.weatherapp.R;

import api.AuthApi;
import helper.RetrofitHelper;
import pojo.Main;
import pojo.MainData;
import pojo.ResultObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {

    public static final String key="dcae12cb0488a2a684320828b6e1acc3";

    private View rootview;
    private ProgressDialog pd;
    private AuthApi mApi;
    private Call<ResultObject<Main>> currentCall;
    private TextView temp_current,status_current,location;

    public static TextView temp_today,temp_tomorrow;
    public static TextView status_today,status_tomorrow;

    private String lat,lon;
    private String geo;
    private String units="metric";
    private ResultObject<Main> mData= new ResultObject<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_home,container,false);

        temp_current= (TextView) rootview.findViewById(R.id.temp_current);
        status_current= (TextView) rootview.findViewById(R.id.status_current);

        temp_today= (TextView) rootview.findViewById(R.id.temp_today);
        temp_tomorrow=(TextView) rootview.findViewById(R.id.temp_tomorrow);

        status_today=(TextView) rootview.findViewById(R.id.status_today);
        status_tomorrow=(TextView) rootview.findViewById(R.id.status_tomorrow);

        location=(TextView) rootview.findViewById(R.id.location);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            lat= bundle.getString("lat", "0");
            lon=bundle.getString("lon","0");
        }
        loadData(lat,lon);
        return rootview;
    }

//?lat=19&lon=72&units=metric&APPID=dcae12cb0488a2a684320828b6e1acc3

//http://api.openweathermap.org/weather?geo=lat%3D0%26lon%3D0%26units%3Dmetric%26APPID%3Ddcae12cb0488a2a684320828b6e1acc3

    public void loadData(String lat,String lon){
        pd = new ProgressDialog(getActivity());
        pd.setMessage("Loading");
        pd.show();

        mApi = new RetrofitHelper<AuthApi>().getApi(AuthApi.class);

        currentCall = mApi.currentData(lat,lon,units,key);

        currentCall.enqueue(new Callback<ResultObject<Main>>() {
            @Override
            public void onResponse(Call<ResultObject<Main>> call,
                                   Response<ResultObject<Main>> response) {

                Log.d("enter","enter");
                //Log.d("temp",new Integer(response.body().getMain().getTemp()).toString());
                mData=response.body();
                temp_current.setText(mData.getMain().getTemp());
                status_current.setText(mData.getWeather().getDescription());


                pd.hide();
            }

            @Override
            public void onFailure(Call<ResultObject<Main>> call, Throwable t) {
                Log.d("enterf",Log.getStackTraceString(new Exception()));
                pd.hide();

            }
        });

    }


}
