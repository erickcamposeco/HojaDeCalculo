package hoja_calculo;

//Celda como una clase
public class Celda {

    private double fila;
    private double columna;
    private String contenido;
    private Hoja hoja;

    public Celda(double fila, double columna, String contenido, Hoja hoja) {
        this.fila = fila;
        this.columna = columna;
        this.contenido = contenido;
        this.hoja = hoja;
    }

        // Constructores
    
    public double getFila() {
        return fila;
    }

    public double getColumna() {
        return columna;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getValor() {
        if (contenido.startsWith("=")) {
            return evaluarFormula(contenido.substring(1));
        } else {
            return contenido;
        }
    }

    private String evaluarFormula(String formula) {
        try {

            //Suma
            if (formula.contains("+")) {    //Verifica
                String[] partes = formula.split("\\+"); //Realiza un salto de linea
                double suma = 0;
                for (String parte : partes) {
                    parte = parte.trim(); //Elimina los espacios en blanco 
                    if (parte.matches("[A-Z][0-9]+")) {
                        suma += Double.parseDouble(hoja.getCelda(parte).getValor());    //Convierte la primera parte en Double es decir 
                        //En un numero
                    } else {
                        suma += Integer.parseInt(parte);
                    }
                }
                return Double.toString(suma);

                //Resta
                
            } else if (formula.contains("-")) {
                String[] partes = formula.split("\\-");
                double resta = Double.parseDouble(obtenerValor(partes[0].trim()));
                for (int i = 1; i < partes.length; i++) {
                    resta -= Double.parseDouble(obtenerValor(partes[i].trim()));
                }
                return Double.toString(resta);

                //Multiplicacion
                
            } else if (formula.contains("*")) 
            {
                String[] partes = formula.split("\\*");
                double producto = 1;
                for (String parte : partes) {
                    parte = parte.trim();
                    if (parte.matches("[A-Z][0-9]+")) {
                        producto *= Double.parseDouble(hoja.getCelda(parte).getValor());
                    } else {
                        producto *= Double.parseDouble(parte);
                    }
                }
                return Double.toString(producto);

                //Division
                
            } else if (formula.contains("/")) 
            {
                String[] partes = formula.split("\\/");
                double division = Double.parseDouble(obtenerValor(partes[0].trim()));
                for (int i = 1; i < partes.length; i++) {
                    double divisor = Double.parseDouble(obtenerValor(partes[i].trim()));
                    if (divisor == 0) {
                        return "Error: No se puede dividir entre cero";
                    }
                    division /= divisor;
                }
                return Double.toString(division);

                //Evaluar 
                
            } else if (formula.contains("^")) {
                String[] partes = formula.split("\\^");
                if (partes.length != 2) {
                    return "Error: Formato incorrecto para la potencia";
                }

                double base;
                double exponente;

                // Procesamiento de la base
                
                String baseParte = partes[0].trim();
                if (baseParte.matches("[A-Z][0-9]+")) {
                    base = Double.parseDouble(hoja.getCelda(baseParte).getValor());
                } else {
                    base = Double.parseDouble(baseParte);
                }

                //Evaluar un exponente
                
                String exponenteParte = partes[1].trim();
                if (exponenteParte.matches("[A-Z][0-9]+")) {
                    exponente = Double.parseDouble(hoja.getCelda(exponenteParte).getValor());
                } else {
                    exponente = Double.parseDouble(exponenteParte);
                }

                // Analisis de resultado
                
                double resultado = Math.pow(base, exponente);
                return Double.toString(resultado);
            }

        } catch (Exception e) {
            return "Error";
        }
        return contenido;
    }

    private String obtenerValor(String referencia) {
        if (referencia.matches("[A-Z][0-9]+")) {
            return hoja.getCelda(referencia).getValor();
        } else {
            return referencia;
        }
    }
}