package local.home.weather;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Second extends Activity {

    private TextView textView;
    String weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.weather);
        Intent intent = getIntent();
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

}
