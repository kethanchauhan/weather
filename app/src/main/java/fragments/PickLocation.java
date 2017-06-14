package fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kethan.weatherapp.MainActivity;
import com.example.kethan.weatherapp.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class PickLocation extends Fragment {

    private View rootview;
    private Button pick;
    private TextView place1;
    private  Double latitude;
    private  Double longitude;
    private  Place place;
    Bundle bundle;

    private static final int PLACE_PICKER_REQUEST=1;
    public static final int RESULT_OK   = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_pick_location,container,false);
        pick =(Button) rootview.findViewById(R.id.pick_location);
        pick.setOnClickListener(pickListener);
        return rootview;
    }

    View.OnClickListener pickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

            try {
                startActivityForResult(builder.build(getActivity()),PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if( requestCode == PLACE_PICKER_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                place =   PlacePicker.getPlace(data,getActivity());
                latitude = place.getLatLng().latitude;
                longitude = place.getLatLng().longitude;

                Home.lat=latitude.toString();
                Home.lon=longitude.toString();
                FiveDays.lat=latitude.toString();
                FiveDays.lon=longitude.toString();

                Bundle bundle = new Bundle();
                bundle.putString("lat",  latitude.toString());
                bundle.putString("lon", longitude.toString());
                ((MainActivity)getActivity()).selectItem(MainActivity.FIVE_DAY_FORECAST,bundle);

            }
        }
    }
}
