package local.home.weather_dz2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Second extends Activity {
    public static final String WEATHER_DESCRIPTION = "weatherDescription";
    private TextView textView;
        String weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState != null) {
            weather = savedInstanceState.getString(WEATHER_DESCRIPTION);
        }

        textView = findViewById(R.id.weather);

        Intent intent = getIntent(); //а вот тут интересно, если активность пересоздана, то будет NPE?
        weather = intent.getStringExtra("statusw");
        textView.setText(weather);

    }

    public void shareWeatherStatus(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra("shareWeather", weather);
        try {
            startActivity(shareIntent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Сохранение данных Активности");
        outState.putString(WEATHER_DESCRIPTION, weather);
    }
}
