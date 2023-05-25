package com.quind.calculadora.modelo;

public class Resultados {

    private float resultados;
    private String resultadosCero;
    private String estado;


    public void setResultadosCero(String resultadosCero){

        this.resultadosCero = resultadosCero;

    }

    public void setResultados(float resultados){

        this.resultados = resultados;

    }

    public void setEstado(String estado){

        this.estado= estado;

    }

    public float getResultados(){

        return this.resultados;

    }

    public String getEstado(){

        return this.estado;

    }

    public Resultados(){
        setResultados(0);
        setEstado("Pending");

    }


}
