package local.home.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {


    private Spinner spinner;
    private TextView textView;
    String[] citySet;
    String[] weatherSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Метод onCreate");
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.weather);
        spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.button);
        citySet = getResources().getStringArray(R.array.city_selection);
        weatherSet = getResources().getStringArray(R.array.city_weather);
        button.setOnClickListener(view -> onClick(view));

    }

    private void onClick(View view) {
        int position = spinner.getSelectedItemPosition();
        Intent secondAct = new Intent(this, Second.class);
        secondAct.putExtra("statusw", weatherSet[position]);
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
    protected void onRestart() {
        super.onRestart();
        System.out.println("Метод onRestart");

    }

}
