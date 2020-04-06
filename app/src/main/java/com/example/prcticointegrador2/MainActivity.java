package com.example.prcticointegrador2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etDolares;
    private EditText etEuros;
    private TextView tvReslutado;
    private RadioButton radioDolares;
    private RadioButton radioEuros;
    private Button btnConvertir;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();




    }

    public void iniciar(){

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

         etDolares = findViewById(R.id.etDolares);
         etEuros = findViewById(R.id.etEuros);
         tvReslutado = findViewById(R.id.tvResultado);
         radioDolares = findViewById(R.id.radioDolares);
         radioEuros = findViewById(R.id.radioEuros);
         btnConvertir = findViewById(R.id.btnConvertir);
         etDolares.setEnabled(false);
         etEuros.setEnabled(false);

         radioDolares.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 etEuros.setEnabled(false);
                 etDolares.setEnabled(true);
                 Toast.makeText(MainActivity.this, "Dolares", Toast.LENGTH_SHORT).show();
                 etEuros.setText("");
                 etDolares.requestFocus();
                 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                 imm.showSoftInput(etDolares, InputMethodManager.SHOW_FORCED);

             }
         });

         radioEuros.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(MainActivity.this, "Euros", Toast.LENGTH_SHORT).show();
                 etEuros.setEnabled(true);
                 etDolares.setEnabled(false);;
                 etDolares.setText("");
                 etEuros.requestFocus();
                 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                 imm.showSoftInput(etEuros, InputMethodManager.SHOW_FORCED);

             }
         });

         btnConvertir.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (radioDolares.isChecked()){
                     viewModel.dolares(etDolares.getText().toString());
                 }else{
                     if (radioEuros.isChecked()){
                         viewModel.euros(etEuros.getText().toString());
                     }
                 }



             }
         });


         final Observer<String> observer = new Observer<String>() {
             @Override
             public void onChanged(String s) {
                 tvReslutado.setText(s);
             }
         };

         viewModel.getResultado().observe(this, observer);


    }
}
