package ejemplo.domotica;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by camonappdeveloper on 5/4/17.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "ejemplo.domotica.Configure";
    private static final String IS_FIRST_TUG = "IsFirst_Tug";
    private static final String IS_FIRST_Lumi = "IsFirst_Lumi";
    private static final String IS_FIRST_Aire = "IsFirst_Aire";
    private static final String IS_FIRST_Dimmer = "IsFirst_Dimmer";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTug(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TUG, isFirstTime);
        editor.commit();
    }

    public void setFirstLumi(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_Lumi, isFirstTime);
        editor.commit();
    }
    public void setFirstAire(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_Aire, isFirstTime);
        editor.commit();
    }
    public void setFirstDimmer(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_Dimmer, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTug() {
        return pref.getBoolean(IS_FIRST_TUG, true);
    }

    public boolean isFirstLumi() {
        return pref.getBoolean(IS_FIRST_Lumi, true);
    }

    public boolean isFirstDimmer() {
        return pref.getBoolean(IS_FIRST_Dimmer, true);
    }

    public boolean isFirstTimeAire() {
        return pref.getBoolean(IS_FIRST_Aire, true);
    }
}
