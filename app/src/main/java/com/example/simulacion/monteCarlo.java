package com.example.simulacion;

public class monteCarlo {

    int a,b,m,j=0,k=0,indep;
    double xi[] = new double[6];
    double zi[] = new double[6];
    double f[] = new double[10];
    double fx[] = new double[5];
    double y[] = new double[5];
    double X[] = new double[5];
    StringBuilder ecuacion = new StringBuilder();

    public monteCarlo(int a, int b, int m) {
        this.a = a;
        this.b = b;
        this.m = m;
    }

    public void aleatorios() {

    }

    public void ecuacion(String x, String z, int indep) {
        this.indep = indep;
        ecuacion.append(x + "x" + "^" + z);
        xi[k] = Double.parseDouble(x);
        zi[k] = Double.parseDouble(z);
        if (indep > 1) {
            ecuacion.append(" + ");
            ecuacion.append(indep);
        }else{
            ecuacion.append(indep);
        }
        k++;
    }

    public void X1(double uno,double dos,int i) {
        X[i] = this.a + uno * (this.b - this.a);
    }

    public void Y(double uno,int dos,int i) {
        y[i] = uno * dos;
    }

    public void FX() {
        fx[j] = xi[0] * Math.pow(X[j], zi[0]) + indep;
        j++;
    }
}
