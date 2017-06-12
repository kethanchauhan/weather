package helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pranav on 26/08/16.
 */
public class PreferenceHelper {
    private Context mAppContext;
    private static PreferenceHelper sPreferenceHelper;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private PreferenceHelper(Context appContext) {
        mAppContext = appContext;
        sp = appContext.getSharedPreferences(QuickPreferences.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static PreferenceHelper get(Context c) {
        if (sPreferenceHelper == null) {
            sPreferenceHelper = new PreferenceHelper(c.getApplicationContext());
        }
        return sPreferenceHelper;
    }

    public void putAccessToken(String s) {
        editor.putString(QuickPreferences.ACCESS_TOKEN, s);
        editor.commit();
    }

    public String getAccessToken() {
        return sp.getString(QuickPreferences.ACCESS_TOKEN, null);
    }


    public void putMobile(String s) {
        editor.putString(QuickPreferences.MOBILE, s);
        editor.commit();
    }

    public String getMobile() {
        return sp.getString(QuickPreferences.MOBILE, null);
    }

    public void putName(String s) {
        editor.putString(QuickPreferences.Name, s);
        editor.commit();
    }

    public String getName() {
        return sp.getString(QuickPreferences.Name, null);
    }


    public void putGroup_name(String s) {
        editor.putString(QuickPreferences.Group_name, s);
        editor.commit();
    }

    public String getGroup_name() {
        return sp.getString(QuickPreferences.Group_name, null);
    }


    public void putImagePropId(int s) {
        editor.putInt(QuickPreferences.ADD_IMAGE_PROP, s);
        editor.commit();
    }

    public int getImagePropId() {
        return sp.getInt(QuickPreferences.ADD_IMAGE_PROP, 0);
    }


}
