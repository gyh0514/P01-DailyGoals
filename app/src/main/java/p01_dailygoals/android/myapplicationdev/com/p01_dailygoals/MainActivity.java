package p01_dailygoals.android.myapplicationdev.com.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get the RadioGroup object
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);

                // Get the RadioGroup object
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);

                // Get the RadioGroup object
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                // Get the EditText
                EditText etText = (EditText) findViewById(R.id.editText);

                // Put the name and age into an array
                String[] info = {rb1.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        etText.getText().toString()};

                // Create an intent to start another activity called
                //  DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this,
                        Main2Activity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);


                SharedPreferences.Editor preEdit = pref.edit();
                preEdit.putInt("one", selectedButtonId1);
                preEdit.putInt("two", selectedButtonId2);
                preEdit.putInt("three", selectedButtonId3);

            }
        });

    }

    
    @Override
    protected void onResume() {
        super.onResume();
        int one = pref.getInt("one", 0);
        int two = pref.getInt("two", 0);
        int three = pref.getInt("three", 0);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

        rg1.check(one);
        rg2.check(two);
        rg3.check(three);
    }
}
