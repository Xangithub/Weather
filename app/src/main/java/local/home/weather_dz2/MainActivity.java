package local.home.weather_dz2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class MainActivity extends Activity {
    public static final String NUMBER_CITY_CHOSEN = "cityString";
    private Spinner spinner;
    private TextView textView;
    String[] citySet;
    String[] weatherSet;
    int cityChosen;
    CheckBox checkBoxPressure;
    CheckBox checkBoxTemp;
    CheckBox checkBoxWind;
    boolean checkBoxPressureState;
    boolean checkBoxTempState;
    boolean checkBoxWindState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Метод onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            cityChosen = savedInstanceState.getInt(NUMBER_CITY_CHOSEN);
        }


        textView = findViewById(R.id.weather);
        spinner = findViewById(R.id.spinner);
//        checkBoxTem = findViewById(R.id.checkBoxTemp);

        Button button = findViewById(R.id.button);
        citySet = getResources().getStringArray(R.array.city_selection);
        weatherSet = getResources().getStringArray(R.array.city_weather);
        button.setOnClickListener(view -> onClick(view));

    }

    private void onClick(View view) {
        cityChosen = spinner.getSelectedItemPosition();
        Intent secondAct = new Intent(this, Second.class);
        secondAct.putExtra("statusw", weatherSet[cityChosen]);
        startActivity(secondAct);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Метод onStart.. окно активности уже на экране");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Метод onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Метод onDestroy ");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Сохранение данных Активности");
        outState.putInt(NUMBER_CITY_CHOSEN, cityChosen);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Метод onRestart");

    }

    public void checkBoxStateChange(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxPressure:
                if (checked) checkBoxPressureState=false;
                else checkBoxPressureState=true;
                break;
            case R.id.checkBoxTemp:
                if (checked) checkBoxTempState=false;
                else checkBoxTempState=true;
                break;

            case R.id.checkBoxWind:
                if (checked)  checkBoxWindState=false;
                else checkBoxWindState=true;
            break;
        }

    }

    public void checkBoxPressureState(View view) {
//     if(((CheckBox) view).isChecked())
    }

    public void checkBoxTempState(View view) {
    }

    public void checkBoxWindState(View view) {
    }
}

