package com.tonilopezmr.vadgtests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tonilopezmr.vadgtests.katas.RandomPrinter;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final RandomPrinter kataclass = new RandomPrinter();

    final TextView textView = findViewById(R.id.textView);
    Button button = findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int randomNumber = kataclass.generateRandomBetween0And100();
        String vadgOrAndroid = kataclass.getAndroidOrVadgForNumber(randomNumber);
        textView.setText(vadgOrAndroid);
      }
    });
  }
}
