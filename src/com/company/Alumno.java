package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Alumno {
                private String nombre;
                private int notaMediaPrimeraEvalucion;
                private float primerExamen;
                private float segundoExamen;
                private float tercerExamen;
                private int boletinesTotales;
                private int puntosBoletines;
                public Alumno(){
                    notaMediaPrimeraEvalucion =0;
                    this.primerExamen = 0;
                    this.segundoExamen = 0;
                    this.tercerExamen = 0;
                    this.boletinesTotales=0;
                }
                public Alumno(float primerExamen,float segundoExamen,float tercerExamen,int boletinesTotales,String nombre){
                    this.primerExamen = primerExamen;
                    this.segundoExamen = segundoExamen;
                    this.tercerExamen = tercerExamen;
                    this.boletinesTotales = boletinesTotales;
                    this.nombre=nombre;
                }
                public void comprobarNombre(){
                    String sc1 = JOptionPane.showInputDialog("Nombre Alumno: ");
                    if ("FIN".equals(sc1)) {
                        this.nombre = "FIN";
                    }
                   this.nombre = nombre;
                }
                public String getNombre(){
                    return nombre;
                }
                public void setNotaPrimerExamen(){
                    float sc1 = Float.parseFloat(JOptionPane.showInputDialog("Nota primer examen teorico"));
                    float sc2 = 0;
                    while(((sc1 > 10 || sc1 < 0))){
                        sc2 = Float.parseFloat(JOptionPane.showInputDialog("Nota  incorrecta, introduzca de nuevo la nota"));
                        sc1=sc2;
                    }
                    this.primerExamen = sc1;
                }
                public void setNotaSegundoExamen(){
                    float sc1 = Float.parseFloat(JOptionPane.showInputDialog("Nota Segundo examen teorico"));
                    float sc2 = 0;
                    while(((sc1 > 10 || sc1 < 0))){
                        sc2 = Float.parseFloat(JOptionPane.showInputDialog("Nota  incorrecta, introduzca de nuevo la nota"));
                        sc1=sc2;
                    }
                    this.segundoExamen = sc1;
                }
                public void setNotaTercerExamen(){
                    float sc1 = Float.parseFloat(JOptionPane.showInputDialog("Nota Tercer examen teorico"));
                    float sc2 = 0;
                    while(((sc1 > 10 || sc1 < 0))){
                        sc2 = Float.parseFloat(JOptionPane.showInputDialog("Nota  incorrecta, introduzca de nuevo la nota"));
                        sc1=sc2;
                    }
                    this.tercerExamen = sc1;
                }
                public void setBoletines(){
                    int sc1 = Integer.parseInt(JOptionPane.showInputDialog("Numero de boletines entregados"));
                    int sc2 = 0;
                    while(((sc1 > 18 || sc1 < 0))){
                        sc2 = Integer.parseInt(JOptionPane.showInputDialog("Numero incorrecto de boletines"));
                        sc1=sc2;
                    }
                    this.boletinesTotales=sc1;
                }
                public float getNotaPrimerExamen(){
                    return primerExamen;
                }
                public float getNotaSegundoExamen(){return  segundoExamen;}
                public float getNotaTercerExamem(){return tercerExamen; }
                public int getTotalBoletines(){
                    return boletinesTotales;
                }

                public void setNotaPrimeraEvaluacion(){
                    while (nombre!="FIN"){
                        comprobarNombre();
                        if (("FIN").equals(nombre)){
                                break;
                        }
                        setNotaPrimerExamen();
                        setNotaSegundoExamen();
                        setNotaTercerExamen();
                        setBoletines();
                        int notaMediaTeorico = (int) Math.round((((getNotaPrimerExamen() + getNotaSegundoExamen()) / 2) * (0.4)));
                        int notaMediaPratico = (int) Math.round((getNotaTercerExamem() * 0.4));
                        System.out.println(notaMediaTeorico + "-" + notaMediaPratico);
                        float mediaBoletines = (getTotalBoletines() * 20) / 100;

                        if (((getTotalBoletines() * 100) / 18) > 90) {
                            puntosBoletines = 2;
                        } else if ((((getTotalBoletines() * 100) / 18) < 90) && (((getTotalBoletines() * 100) / 18) > 70)) {
                            puntosBoletines = 1;
                        } else
                            puntosBoletines = 0;
                        System.out.println("La nota final de la primera evaluacion: " + (notaMediaPratico + notaMediaTeorico + puntosBoletines));
                    }
                }
}


