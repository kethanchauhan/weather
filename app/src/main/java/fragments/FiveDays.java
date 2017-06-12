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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import api.AuthApi;
import helper.RetrofitHelper;
import pojo.MainData;
import pojo.ResultObject;
import pojo.ResultObject1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FiveDays extends Fragment {

    private View rootview;
    private ProgressDialog pd;
    private AuthApi mApi;
    private List<MainData> mData = new ArrayList<>();
    private Call<ResultObject1<List<MainData>>> forecastCall;
    private TextView f_date1,f_date2,f_date3,f_date4,f_date5,f_status1,f_status2,f_status3,f_status4,f_status5,location;
    private TextView f_temp1,f_temp2,f_temp3,f_temp4,f_temp5;
    private String lat,lon;
    private String units="metric";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_five_days,container,false);

        f_temp1= (TextView) rootview.findViewById(R.id.f_temp1);
        f_temp2= (TextView) rootview.findViewById(R.id.f_temp2);
        f_temp3= (TextView) rootview.findViewById(R.id.f_temp3);
        f_temp4= (TextView) rootview.findViewById(R.id.f_temp4);
        f_temp5= (TextView) rootview.findViewById(R.id.f_temp5);

        f_status1= (TextView) rootview.findViewById(R.id.f_status1);
        f_status2= (TextView) rootview.findViewById(R.id.f_status2);
        f_status3= (TextView) rootview.findViewById(R.id.f_status3);
        f_status4= (TextView) rootview.findViewById(R.id.f_status4);
        f_status5= (TextView) rootview.findViewById(R.id.f_status5);

        f_date1= (TextView) rootview.findViewById(R.id.f_date1);
        f_date2= (TextView) rootview.findViewById(R.id.f_date2);
        f_date3= (TextView) rootview.findViewById(R.id.f_date3);
        f_date4= (TextView) rootview.findViewById(R.id.f_date4);
        f_date5= (TextView) rootview.findViewById(R.id.f_date5);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            lat= bundle.getString("lat", "0");
            lon=bundle.getString("lon","0");
        }
        loadData(lat,lon);
        return rootview;
    }

    public void loadData(String lat,String lon){
        pd = new ProgressDialog(getActivity());
        pd.setMessage("Loading");
        pd.show();

        mApi = new RetrofitHelper<AuthApi>().getApi(AuthApi.class);

        forecastCall = mApi.forecastData(lat,lon,units,Home.key);

        forecastCall.enqueue(new Callback<ResultObject1<List<MainData>>>() {
            @Override
            public void onResponse(Call<ResultObject1<List<MainData>>> call,
                                   Response<ResultObject1<List<MainData>>> response) {

                //Log.d("enter","enter");
                //Log.d("temp",new Integer(response.body().getMain().getTemp()).toString());
               // temp_current.setText(new Integer(response.body().gelist().getTemp()).toString());

                mData=response.body().getList();
                f_temp1.setText(mData.get(0).getMain().gettemp_max()+"/"+mData.get(0).getMain().getTemp_min());
                Home.temp_today.setText(mData.get(0).getMain().gettemp_max()+"/"+mData.get(0).getMain().getTemp_min());
                f_temp2.setText(mData.get(1).getMain().gettemp_max()+"/"+mData.get(1).getMain().getTemp_min());
                Home.temp_tomorrow.setText(mData.get(1).getMain().gettemp_max()+"/"+mData.get(1).getMain().getTemp_min());
                f_temp3.setText(mData.get(2).getMain().gettemp_max()+"/"+mData.get(2).getMain().getTemp_min());
                f_temp4.setText(mData.get(3).getMain().gettemp_max()+"/"+mData.get(3).getMain().getTemp_min());
                f_temp5.setText(mData.get(4).getMain().gettemp_max()+"/"+mData.get(4).getMain().getTemp_min());


                f_status1.setText(mData.get(0).getWeather().getDescription());
                Home.status_today.setText(mData.get(0).getWeather().getDescription());
                f_status2.setText(mData.get(1).getWeather().getDescription());
                Home.status_tomorrow.setText(mData.get(1).getWeather().getDescription());
                f_status3.setText(mData.get(2).getWeather().getDescription());
                f_status4.setText(mData.get(3).getWeather().getDescription());
                f_status5.setText(mData.get(4).getWeather().getDescription());


                f_date1.setText(Date(mData.get(0).getDt()));
                f_date2.setText(Date(mData.get(1).getDt()));
                f_date3.setText(Date(mData.get(2).getDt()));
                f_date4.setText(Date(mData.get(3).getDt()));
                f_date5.setText(Date(mData.get(4).getDt()));


                pd.hide();
            }

            @Override
            public void onFailure(Call<ResultObject1<List<MainData>>> call, Throwable t) {
                Log.d("enterf","enterf");
                pd.hide();
            }
        });

    }

    public String Date(long secs){
        long unixSeconds = secs;
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

}
