package com.example.prcticointegrador2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> resultado;

    public MainActivityViewModel(){
        resultado = new MutableLiveData<String>();
    }

    public LiveData<String> getResultado(){
        return resultado;
    }


    public void dolares(String valor){
        Double valorDolar = Double.valueOf(64.92);
        Double valor2 = Double.parseDouble(valor);
        String calculo = String.valueOf(valor2*valorDolar);

        resultado.setValue(calculo);
    }

    public void euros(String valor) {
        Double valorEuro = Double.valueOf(70.03);
        Double valor2 = Double.parseDouble(valor);
        String calculo = String.valueOf(valor2*valorEuro);

        resultado.setValue(calculo);
    }
}
