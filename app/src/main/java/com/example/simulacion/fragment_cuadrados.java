package com.example.simulacion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class fragment_cuadrados extends Fragment {


    Button btn_cuadrados,btn_productos,btn_atras;
    EditText et_semilla1,et_semilla11,et_semilla12;
    TextView txt_cuadrados,txt_productos;


    public fragment_cuadrados() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuadrados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btn_atras = view.findViewById(R.id.btn_atras);
        btn_cuadrados = view.findViewById(R.id.btn_cuadrados);
        btn_productos = view.findViewById(R.id.btn_producto);
        et_semilla1 = view.findViewById(R.id.cuadrados_semilla);
        et_semilla11 = view.findViewById(R.id.productos_semilla1);
        et_semilla12 = view.findViewById(R.id.productos_semilla2);
        txt_cuadrados = view.findViewById(R.id.cuadrados_resultado);
        txt_productos = view.findViewById(R.id.productos_resultados);



        btn_cuadrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int semilla = Integer.parseInt(et_semilla1.getText().toString());

                cuadrados cuadrados = new cuadrados(semilla);
                txt_cuadrados.setText(String.valueOf(cuadrados.cuadrados()));
            }
        });

        btn_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int semilla1 = Integer.parseInt(et_semilla11.getText().toString());
                int semilla2 = Integer.parseInt(et_semilla12.getText().toString());

                cuadrados cuadrados = new cuadrados(semilla1,semilla2);

                txt_productos.setText(String.valueOf(cuadrados.punto()));
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