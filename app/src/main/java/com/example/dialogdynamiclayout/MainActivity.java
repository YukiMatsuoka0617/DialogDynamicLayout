package com.example.dialogdynamiclayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView[] imageViews;
    TextView[] textViews;
    CheckBox[] checkBoxes;

    int[] imageViewIds = {R.id.icon1,R.id.icon2,R.id.icon3,R.id.icon4};
    int[] textViewIds = {R.id.name1,R.id.name2,R.id.name3,R.id.name4};
    int[] checkBoxIds = {R.id.checkbox1,R.id.checkbox2,R.id.checkbox3,R.id.checkbox4};

    String[] strings = {"name1","name2","name3","name4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews = new ImageView[imageViewIds.length];
        textViews = new TextView[textViewIds.length];
        checkBoxes = new CheckBox[checkBoxIds.length];

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_layout, (ViewGroup) findViewById(R.id.layout));

        for(int i = 0;i < imageViewIds.length;i++){
            imageViews[i] = view.findViewById(imageViewIds[i]);
            imageViews[i].setImageResource(R.drawable.ic_launcher_foreground);

            textViews[i] = view.findViewById(textViewIds[i]);
            textViews[i].setText(strings[i]);

            checkBoxes[i] = view.findViewById(checkBoxIds[i]);
            int finalI = i;
            checkBoxes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isChecked = checkBoxes[finalI].isChecked();
                    if(isChecked){
                        Log.d("test",""+true);
                    } else {
                        Log.d("test",""+false);
                    }
                }
            });
        }

        int count = 2;

        if(count < 3){
            imageViews[2].setVisibility(View.GONE);
            textViews[2].setVisibility(View.GONE);
            checkBoxes[2].setVisibility(View.GONE);
            imageViews[3].setVisibility(View.GONE);
            textViews[3].setVisibility(View.GONE);
            checkBoxes[3].setVisibility(View.GONE);
        }

        new AlertDialog.Builder(this)
                .setTitle("title")
                .setView(view)
                .show();

    }
}