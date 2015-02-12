package com.example.akaszuba.bmicalc;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculateClicked(View view){
        //get controls
        EditText txtHeightControl =  (EditText)findViewById(R.id.txtHeight);
        EditText txtWeightControl =  (EditText)findViewById(R.id.txtWeight);
        TextView lblResult = (TextView)findViewById(R.id.lblResult);

        lblResult.setText("");


        if(txtHeightControl.getText().length() == 0 || txtWeightControl.getText().length()== 0){
            handleError("Please fill all the required fields.");
            return;
        }
        double height = Double.parseDouble(txtHeightControl.getText().toString());
        double weight = Double.parseDouble (txtWeightControl.getText().toString());



        double result = 10000 *weight/(height * height);
        String weightCategory = "";

        if(result <=18.5){
            weightCategory = "Underweight";
        }
        else if(result <=25){
            weightCategory = "Normal";
        }
        else{
            weightCategory = "Overweight";
        }

        lblResult.setText("Your body mas index is equal to:" + String.format("%.1f",result) + " ("+ weightCategory+")");
    }



    private void handleError(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setNeutralButton("OK",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
