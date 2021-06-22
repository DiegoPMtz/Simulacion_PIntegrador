package com.example.simulacion;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class fragment_montecarlo extends Fragment {

    private Button btn_calcular,btn_atras;
    private EditText et_argumento,et_potencia,et_independiente;
    private TextView txt_ecuacion,txt_aleatorios,txt_resultados;
    String al="";
    String re="";


    public fragment_montecarlo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_montecarlo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btn_calcular = view.findViewById(R.id.btn_calcular);
        btn_atras = view.findViewById(R.id.btn_atras);
        et_argumento = view.findViewById(R.id.et_argumento);
        et_potencia = view.findViewById(R.id.et_potencia);
        et_independiente = view.findViewById(R.id.et_independiente);
        txt_ecuacion = view.findViewById(R.id.ecuacion);
        txt_aleatorios = view.findViewById(R.id.aleatorios);
        txt_resultados = view.findViewById(R.id.resultados);



        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arg = et_argumento.getText().toString();
                String pot = et_potencia.getText().toString();
                int indep = Integer.parseInt(et_independiente.getText().toString());

                monteCarlo monteCarlo = new monteCarlo(1,2,30);

                monteCarlo.ecuacion(arg,pot,indep);

                txt_ecuacion.setText("F(x)= " + monteCarlo.ecuacion);

                for (int i = 0; i < 10; i++) {
                    monteCarlo.f[i] = Math.round(Math.random() * 10000d) / 10000d;
                    al = al + monteCarlo.f[i] + "\n";
                    txt_aleatorios.setText(al);
                }

                int j = 0;
                for (int i = 0; i < 10; i += 2) {
                    monteCarlo.X1(monteCarlo.f[i],monteCarlo.f[i + 1],j);
                    monteCarlo.Y(monteCarlo.f[i + 1],monteCarlo.m, j);
                    j++;
                }

                for (int i = 0; i < 5; i++) {
                    monteCarlo.FX();

                    if (monteCarlo.y[i] <= monteCarlo.fx[i]) {
//                        txt_resultados.setTextColor(Color.GREEN);
                        re = re + "f(x" + (i + 1) + ")= " + String.format("%.4f", monteCarlo.fx[i]) + " SI" + "\n";
                    } else {
//                        txt_resultados.setTextColor(Color.RED);
                        re = re + "f(x" + (i + 1) + ")= " + String.format("%.4f", monteCarlo.fx[i]) + " NO" + "\n";
                    }
                    txt_resultados.setText(re);
                }
            }
        });


        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragment_Inicio);
            }
        });

    }
}