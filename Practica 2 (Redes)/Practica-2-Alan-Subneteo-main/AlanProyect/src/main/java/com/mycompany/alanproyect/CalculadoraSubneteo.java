package com.mycompany.alanproyect;

public class CalculadoraSubneteo {
    
 
    private String ip;
    private int cantidadSolicitada;
    private boolean esPorSubred;
    private int salto;
    private String mascaraDecimal;
    
    private char claseRed;
    private int bitsPrestados;
    private int subredesTeoricas;
    private int subredesPracticas;
    private int hostsTeoricos;
    private int hostsPracticos;

    //Recibe los datos del formulario y los pasa a variables dentro del objeto :v
    public CalculadoraSubneteo(String ip, int cantidadSolicitada, boolean esPorSubred) {
        this.ip = ip;
        this.cantidadSolicitada = cantidadSolicitada;
        this.esPorSubred = esPorSubred;
    }

  
    
    // Método para saber si es A, B o C
    private void identificarClase() {
        String[] octetos = ip.split("\\.");
        if (octetos.length > 0) {
            int primerOcteto = Integer.parseInt(octetos[0]);
            if (primerOcteto >= 1 && primerOcteto <= 127) claseRed = 'A';
            else if (primerOcteto >= 128 && primerOcteto <= 191) claseRed = 'B';
            else if (primerOcteto >= 192 && primerOcteto <= 223) claseRed = 'C';
                
        }
    }

    // MÉTODO PRINCIPAL (Verbo público): Este es el que el formulario manda a llamar para trabajar.
    
   public void calcular() {
    identificarClase();

    int bitsDisponibles = 0;
    if (claseRed == 'A') bitsDisponibles = 24;
    else if (claseRed == 'B') bitsDisponibles = 16;
    else if (claseRed == 'C') bitsDisponibles = 8;

    if (esPorSubred) {
        bitsPrestados = 0;
        while (Math.pow(2, bitsPrestados) < cantidadSolicitada) {
            bitsPrestados++;
        }

        int bitsHost = bitsDisponibles - bitsPrestados;

        subredesTeoricas = (int)Math.pow(2, bitsPrestados);
        subredesPracticas = subredesTeoricas - 2;

        hostsTeoricos = (int)Math.pow(2, bitsHost);
        hostsPracticos = hostsTeoricos - 2;

    } else {
        int bitsHost = 0;
        while (Math.pow(2, bitsHost) < cantidadSolicitada) {
            bitsHost++;
        }

        bitsPrestados = bitsDisponibles - bitsHost;

        subredesTeoricas = (int)Math.pow(2, bitsPrestados);
        subredesPracticas = subredesTeoricas - 2;

        hostsTeoricos = (int)Math.pow(2, bitsHost);
        hostsPracticos = hostsTeoricos - 2;
    }

    int bitsEnOcteto = bitsPrestados % 8;
    if (bitsEnOcteto == 0) bitsEnOcteto = 8;

    salto = (int)Math.pow(2, (8 - bitsEnOcteto));

    int valorMascara = 256 - salto;

    if (claseRed == 'A') {
        mascaraDecimal = "255." + valorMascara + ".0.0";
    } 
    else if (claseRed == 'B') {
        mascaraDecimal = "255.255." + valorMascara + ".0";
    } 
    else {
        mascaraDecimal = "255.255.255." + valorMascara;
    }
        // El usuario seleccionó calcular por Subred o por Host
        if (esPorSubred) {
            // Si el usuario eligió "Subredes"
            int bitsHost = bitsDisponibles - bitsPrestados;
            subredesTeoricas = (int) Math.pow(2, bitsPrestados);
            subredesPracticas = subredesTeoricas - 2;
            hostsTeoricos = (int) Math.pow(2, bitsHost);
            hostsPracticos = hostsTeoricos - 2;
        } else {
            int bitsHost = 0;

            while (Math.pow(2, bitsHost) < cantidadSolicitada) {
                bitsHost++;
            }

            int bitsSubred = bitsDisponibles - bitsHost;

            subredesTeoricas = (int) Math.pow(2, bitsSubred);
            subredesPracticas = subredesTeoricas - 2;

            hostsTeoricos = (int) Math.pow(2, bitsHost);
            hostsPracticos = hostsTeoricos - 2;

            bitsPrestados = bitsSubred;
        }
    }

    // GETTERS (Para poder mandar los resultados de vuelta al formulario)
    public int getSubredesTeoricas() { return subredesTeoricas; }
    public int getSubredesPracticas() { return subredesPracticas; }
    public int getHostsTeoricos() { return hostsTeoricos; }
    public int getHostsPracticos() { return hostsPracticos; }
    public char getClaseRed() { return claseRed; } 
    public int getSalto() { return salto; }
    public String getMascaraDecimal() { return mascaraDecimal; }
}