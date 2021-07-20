import java.util.Arrays;
import javax.swing.JOptionPane;

/**Clase que nos permite determinar los tres posibles prediagnósticos 
 * con sus respectivas probabilidades
 *
 * @author a-carrasquillo
 * @author arivesan
 */
public class N_Choose_K {
    // data fields
    // Arreglo para almacenar el nombre de 27 prediagnósticos
    private final String[] prediag = new String[27];
    // Arreglo para almacenar el total de síntomas que posee cada uno de los prediagnósticos
    private final byte[] totalSintomas = new byte[27];
    // Arreglo para almacenar la cantidad de síntomas que padece el paciente con respecto a cada prediagnóstico
    private final byte[] sintomas = new byte[27];
    // Arreglo para almacenar la probabilidad de cada prediagnóstico
    private final float[] probabilidad = new float[27];
    // Arreglo para almacenar una copia de la probabilidad de cada prediagnóstico para poder ordenarlo
    private final float[] probCopy = new float[27];
    // Arreglo para almacenar los 3 primeros prediagnósticos
    private final float[] top3 = new float[3];
    // Arreglo para almacenar los 3 primeros índices que indican los prediagnósticos
    private final byte[] top3Indice = new byte[3];
    // Arreglo para almacenar la categoría de los 3 primeros prediagnóstico
    private final boolean[] top3Categoria = new boolean[3];
    // Arreglo para almacenar si el prediagnóstico es emergencia (true) o urgencia (false)
    private final boolean[] categoria = new boolean[27];
    // Variable que indican si el paciente padece dicho síntoma
    private boolean tos, fiebre, fatiga, erupcion_piel, perdida_peso, dolor_muscular, dolor_articulaciones, secrecion_nasal,
            nauseas, vomitos, picazon, perdida_apetito, debilidad, debilidad_muscular, dolor_cabeza, diarrea, cansancio,
            manchas_piel, estrenimiento, congestion_nasal, dolor_garganta, dificultad_respiratoria, malestar_general,
            piel_roja, dolor_abdominal, sangrado_encias, ulcera_genital, aumento_sudor, dolor_pecho, dolor_fuerte_cuello;
    // Variable para almacenar la edad del paciente
    private byte edad;
    
    /**Constructor por defecto
     * 
     * Inicializa los nombres de los prediagnósticos, el total de síntomas por prediagnósticos,
     * las categorías de los prediagnósticos (true para emergencia, false para urgencia), la cantidad de síntomas,
     * las probabilidades, los primeros 3 prediagnósticos con su respectiva información, los síntomas y la edad. 
     */
    N_Choose_K() {
        prediag[0] = "Bronquitis";
        totalSintomas[0] = 4;
        categoria[0] = false;
        
        prediag[1] = "Tuberculosis";
        totalSintomas[1] = 8;
        categoria[1] = true;
        
        prediag[2] = "Resfriado";
        totalSintomas[2] = 10;
        categoria[2] = false;
        
        prediag[3] = "Asma";
        totalSintomas[3] = 6;
        categoria[3] = true;
        
        prediag[4] = "Eritema Infeccioso";
        totalSintomas[4] = 10;
        categoria[4] = false;
        
        prediag[5] = "Sarampión";
        totalSintomas[5] = 3;
        categoria[5] = false;
        
        prediag[6] = "Rubeola";
        totalSintomas[6] = 7;
        categoria[6] = false;
        
        prediag[7] = "Dermatitis";
        totalSintomas[7] = 4;
        categoria[7] = false;
        
        prediag[8] = "Gastroenteritis";
        totalSintomas[8] = 7;
        categoria[8] = false;
        
        prediag[9] = "Dengue";
        totalSintomas[9] = 12;
        categoria[9] = true;
        
        prediag[10] = "Chikungunya";
        totalSintomas[10] = 8;
        categoria[10] = false;
        
        prediag[11] = "Zika";
        totalSintomas[11] = 6;
        categoria[11] = false;
        
        prediag[12] = "Hipotiroidismo";
        totalSintomas[12] = 9;
        categoria[12] = false;
        
        prediag[13] = "Hipertiroidismo";
        totalSintomas[13] = 8;
        categoria[13] = false;
        
        prediag[14] = "Varicela";
        totalSintomas[14] = 3;
        categoria[14] = false;
        
        prediag[15] = "Otitis";
        totalSintomas[15] = 4;
        categoria[15] = false;
        
        prediag[16] = "Amigdalitis";
        totalSintomas[16] = 5;
        categoria[16] = false;
        
        prediag[17] = "Meningitis";
        totalSintomas[17] = 9;
        categoria[17] = true;
        
        prediag[18] = "Gingivitis";
        totalSintomas[18] = 5;
        categoria[18] = false;
        
        prediag[19] = "Apendicitis";
        totalSintomas[19] = 9;
        categoria[19] = true;
        
        prediag[20] = "VIH";
        totalSintomas[20] = 4;
        categoria[20] = false;
        
        prediag[21] = "Sífilis";
        totalSintomas[21] = 8;
        categoria[21] = false;
        
        prediag[22] = "Herpes";
        totalSintomas[22] = 13;
        categoria[22] = false;
        
        prediag[23] = "Chancroides";
        totalSintomas[23] = 3;
        categoria[23] = false;
        
        prediag[24] = "SIDA";
        totalSintomas[24] = 5;
        categoria[24] = false;
        
        prediag[25] = "Artritis";
        totalSintomas[25] = 2;
        categoria[25] = false;
        
        prediag[26] = "Preinfarto";
        totalSintomas[26] = 8;
        categoria[26] = true;
        
        for (int i = 0; i < 27; i++) {
            sintomas[i] = 0;
            probabilidad[i] = (float) 0.0;
            probCopy[i] = (float) 0.0;
        }
        
        for (int i = 0; i < 3; i++) {
            top3[i] = (float) 0.0;
            top3Indice[i] = 0;
            top3Categoria[i] = false;
        }
        
        tos = false;
        fiebre = false;
        fatiga = false;
        erupcion_piel = false;
        perdida_peso = false;
        dolor_muscular = false;
        dolor_articulaciones = false;
        secrecion_nasal = false;
        nauseas = false;
        vomitos = false;
        picazon = false;
        perdida_apetito = false;
        debilidad = false;
        debilidad_muscular = false;
        dolor_cabeza = false;
        diarrea = false;
        cansancio = false;
        manchas_piel = false;
        estrenimiento = false;
        congestion_nasal = false;
        dolor_garganta = false;
        dificultad_respiratoria = false;
        malestar_general = false;
        piel_roja = false;
        dolor_abdominal = false;
        sangrado_encias = false;
        ulcera_genital = false;
        aumento_sudor = false;
        dolor_pecho = false;
        dolor_fuerte_cuello = false;
        
        edad = 0;
    }
    
    //setters
    /**Método que nos permite modificar el valor del síntoma tos
     * 
     * @param tos - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setTos(boolean tos) {
        this.tos = tos;
    }

    /**Método que nos permite modificar el valor del síntoma fiebre
     * 
     * @param fiebre - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setFiebre(boolean fiebre) {
        this.fiebre = fiebre;
    }

    /**Método que nos permite modificar el valor del síntoma fatiga
     * 
     * @param fatiga - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setFatiga(boolean fatiga) {
        this.fatiga = fatiga;
    }

    /**Método que nos permite modificar el valor del síntoma erupción en la piel
     * 
     * @param erupcion_piel - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setErup_Piel(boolean erupcion_piel) {
        this.erupcion_piel = erupcion_piel;
    }

    /**Método que nos permite modificar el valor del síntoma perdida de peso
     * 
     * @param perdida_peso - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setPerdidaPeso(boolean perdida_peso) {
        this.perdida_peso = perdida_peso;
    }

    /**Método que nos permite modificar el valor del síntoma dolor muscular
     * 
     * @param dolor_muscular - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Muscular(boolean dolor_muscular) {
        this.dolor_muscular = dolor_muscular;
    }

    /**Método que nos permite modificar el valor del síntoma dolor de articulaciones
     * 
     * @param dolor_articulaciones - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Articulaciones(boolean dolor_articulaciones) {
        this.dolor_articulaciones = dolor_articulaciones;
    }

    /**Método que nos permite modificar el valor del síntoma de secreción nasal
     * 
     * @param secrecion_nasal - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setSecrecion_Nasal(boolean secrecion_nasal) {
        this.secrecion_nasal = secrecion_nasal;
    }

    /**Método que nos permite modificar el valor del síntoma de nauseas
     * 
     * @param nauseas - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setNauseas(boolean nauseas) {
        this.nauseas = nauseas;
    }

    /**Método que nos permite modificar el valor del síntoma de vómitos
     * 
     * @param vomitos - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setVomitos(boolean vomitos) {
        this.vomitos = vomitos;
    }

    /**Método que nos permite modificar el valor del síntoma de picazón
     * 
     * @param picazon - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setPicazon(boolean picazon) {
        this.picazon = picazon;
    }

    /**Método que nos permite modificar el valor del síntoma de perdida de apetito
     * 
     * @param perdida_apetito - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setPerdida_Apetito(boolean perdida_apetito) {
        this.perdida_apetito = perdida_apetito;
    }

    /**Método que nos permite modificar el valor del síntoma de debilidad
     * 
     * @param debilidad - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDebilidad(boolean debilidad) {
        this.debilidad = debilidad;
    }

    /**Método que nos permite modificar el valor del síntoma de debilidad muscular
     * 
     * @param debilidad_muscular - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDebilidad_Muscular(boolean debilidad_muscular) {
        this.debilidad_muscular = debilidad_muscular;
    }

    /**Método que nos permite modificar el valor del síntoma de dolor de cabeza
     * 
     * @param dolor_cabeza - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Cabeza(boolean dolor_cabeza) {
        this.dolor_cabeza = dolor_cabeza;
    }

    /**Método que nos permite modificar el valor del síntoma de diarrea
     * 
     * @param diarrea - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDiarrea(boolean diarrea) {
        this.diarrea = diarrea;
    }

    /**Método que nos permite modificar el valor del síntoma de cansancio
     * 
     * @param cansancio - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setCansancio(boolean cansancio) {
        this.cansancio = cansancio;
    }

    /**Método que nos permite modificar el valor del síntoma de manchas en la piel
     * 
     * @param manchas_piel - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setManchas_Piel(boolean manchas_piel) {
        this.manchas_piel = manchas_piel;
    }

    /**Método que nos permite modificar el valor del síntoma de estreñimiento
     * 
     * @param estrenimiento - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setEstrenimiento(boolean estrenimiento) {
        this.estrenimiento = estrenimiento;
    }

    /**Método que nos permite modificar el valor del síntoma de congestión nasal
     * 
     * @param congestion_nasal - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setCongestion_Nasal(boolean congestion_nasal) {
        this.congestion_nasal = congestion_nasal;
    }

    /**Método que nos permite modificar el valor del síntoma de dolor de garganta
     * 
     * @param dolor_garganta - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Garganta(boolean dolor_garganta) {
        this.dolor_garganta = dolor_garganta;
    }

    /**Método que nos permite modificar el valor del síntoma de dificultad respiratoria
     * 
     * @param dificultad_respiratoria - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDificultad_Respiratoria(boolean dificultad_respiratoria) {
        this.dificultad_respiratoria = dificultad_respiratoria;
    }

    /**Método que nos permite modificar el valor del síntoma de malestar general
     * 
     * @param malestar_general - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setMalestar_General(boolean malestar_general) {
        this.malestar_general = malestar_general;
    }

    /**Método que nos permite modificar el valor del síntoma de piel roja
     * 
     * @param piel_roja - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setPiel_Roja(boolean piel_roja) {
        this.piel_roja = piel_roja;
    }

    /**Método que nos permite modificar el valor del síntoma de dolor abdominal
     * 
     * @param dolor_abdominal - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Abdominal(boolean dolor_abdominal) {
        this.dolor_abdominal = dolor_abdominal;
    }

    /**Método que nos permite modificar el valor del síntoma de sangrado de encías
     * 
     * @param sangrado_encias - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setSangrado_Encias(boolean sangrado_encias) {
        this.sangrado_encias = sangrado_encias;
    }

    /**Método que nos permite modificar el valor del síntoma de úlcera genital
     * 
     * @param ulcera_genital - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setUlcera_Genital(boolean ulcera_genital) {
        this.ulcera_genital = ulcera_genital;
    }
    
    /**Método que nos permite modificar el valor del síntoma de aumento de sudor
     * 
     * @param aumento_sudor - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setAumento_Sudor(boolean aumento_sudor) {
        this.aumento_sudor = aumento_sudor;
    }
    
    /**Método que nos permite modificar el valor del síntoma de dolor de pecho
     * 
     * @param dolor_pecho - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Pecho(boolean dolor_pecho) {
        this.dolor_pecho = dolor_pecho;
    }
    
    /**Método que nos permite modificar el valor del síntoma de dolor fuerte en el cuello
     * 
     * @param dolor_fuerte_cuello - valor booleano indicando si el paciente padece dicho síntoma
     *                         true: lo padece
     *                         false: no lo padece
     */
    void setDolor_Fuerte_Cuello(boolean dolor_fuerte_cuello) {
        this.dolor_fuerte_cuello = dolor_fuerte_cuello;
    }

    /**Método que nos permite modificar el valor de la edad
     * 
     * @param edad - valor indicando la edad del paciente
     */
    void setEdad(byte edad) {
        this.edad = edad;
    }

    //getters
    /**Método que nos permite recuperar la probabilidad correspondiente
     * al prediagnóstico indicado por el índice
     * 
     * @param indice - indica cual de los 3 primeros prediagnósticos se desea saber la probabilidad
     * @return la probabilidad del prediagnóstico solicitado
     */
    float getTop3Prob(int indice) {
        return top3[indice];
    }

    /**Método que nos permite recuperar el nombre del prediagnóstico indicado por el índice
     * 
     * @param indice - indica cual de los 3 primeros prediagnósticos se desea saber el nombre
     * @return nombre del prediagnóstico
     */
    String getTop3PreDiag(int indice) {
        return prediag[top3Indice[indice]];
    }

    /**Método que nos permite recuperar la categoría del prediagnóstico indicado por el índice
     * 
     * @param indice - indica cual de los 3 primeros prediagnósticos se desea saber su categoría
     * @return la categoría del prediagnóstico (Emergencia o Urgencia)
     */
    String getTop3Categoria(int indice) {
        if (top3Categoria[indice]) 
            return "Emergencia";
        else
            return "Urgencia";
    }

    //métodos
    /**Método de soporte que nos ayuda a encontrar índices en 
     * un arreglo, basándose en una probabilidad a buscar.
     * 
     * Nota: Encuentra la primera ocurrencia de dicha probabilidad.
     * 
     * @param array - arreglo en el cual se realizará la búsqueda
     * @param prob - probabilidad que se desea buscar
     * @return índice de donde se encuentra la probabilidad deseada
     */
    private byte findIndex(float array[], float prob) {
        // verificar si el arreglo es nulo
        if (array == null) 
            return - 1;

        // determinar el largo del arreglo
        byte len = (byte) array.length;
        
        // encontrar la primera ocurrencia de la probabilidad a buscar
        for (byte i = 0; i < len; i++) 
            if (array[i] == prob) 
                return i;
        
        // no se encontró la probabilidad
        return -1;
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de tos para así sumar uno (1) a los prediagnósticos que
     * posean dicho síntoma. 
     */
    private void checkTos() {
        // evaluar si tiene tos
        if (tos) {
            /* [0] bronquitis++ [1] tuberculosis++  [2] resfriado++ 
            [3] asma++  [4] Eritema_infeccioso++ [5] sarampión++*/
            for (int i = 0; i < 6; i++)
                sintomas[i]++;

            if (edad < 12) 
                sintomas[16]++;//amigdalitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de fiebre para así sumar uno (1) a los prediagnósticos que
     * posean dicho síntoma. 
     */
    private void checkFiebre() {
        // evaluar si tiene fiebre
        if (fiebre) {
            sintomas[1]++;//tuberculosis++
            sintomas[2]++;//Resfriado++
            sintomas[4]++;//eritema_infeccioso++
            sintomas[6]++;//rubeola++
            sintomas[8]++;//gastroenteritis++
            sintomas[9]++;//dengue++
            sintomas[10]++;//chikungunya
            sintomas[11]++;//Zika++ 
            sintomas[14]++;//varicela++

            if (edad < 12) {
                sintomas[15]++;//otitis++
                sintomas[16]++;//amigdalitis++
            } else {
                // [19] apendicitis++  [20] VIH++  [21] Sífilis++  [22] Herpes++
                for(int i = 19; i < 23; i++) 
                    sintomas[i]++;
            }
            
            if (edad > 9 && edad < 20) 
                sintomas[17]++;//meningitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de fatiga para así sumar uno (1) a los prediagnósticos que
     * posean dicho síntoma. 
     */
    private void checkFatiga() {
        // evaluar si tiene fatiga
        if (fatiga) {
            sintomas[1]++;//tuberculosis++
            sintomas[2]++;//resfriado++
            sintomas[3]++;//asma++
            sintomas[4]++;//eritema_infeccioso++
            sintomas[12]++;//hipotiroidismo++
            sintomas[13]++;//hipertiroidismo++

            if (edad > 11) 
                sintomas[21]++;//sifilis++
            
            if (edad > 20) 
                sintomas[26]++;//preinfarto++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de erupciones en la piel para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma. 
     */
    private void checkErupPiel() {
        // evaluar si padece de erupciones en la piel
        if (erupcion_piel) {
            sintomas[6]++;//rubeola++
            sintomas[9]++;//dengue++
            sintomas[11]++;//zika++
            
            int input;
            // pregunta de rutina para mejorar el prediagnóstico
            input = JOptionPane.showConfirmDialog(null, "¿Las erupciones tienen líquido?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
            
            // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
            if (input == 0)
                sintomas[14]++;//varicela++
            
            // pregunta de rutina para mejorar el prediagnóstico
            input = JOptionPane.showConfirmDialog(null, "¿Las erupciones son en el área de la cara y/o nalga?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
            
            // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
            if (input == 0)
                sintomas[4]++;//eritema_infeccioso++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de perdida de peso para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma. 
     */
    private void checkPerdidaPeso() {
        // evaluar si padece de perdida de peso
        if (perdida_peso) {
            sintomas[1]++;//tuberculosis++
            sintomas[13]++;//hipertiroidismo++
            
            if (edad > 11) {
                // pregunta de rutina para mejorar el prediagnóstico
                int input = JOptionPane.showConfirmDialog(null, "¿La perdida de peso es anormalmente rápida?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
                // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
                if (input == 0)
                    sintomas[24]++;//sida++
            }
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor muscular para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma. 
     */
    private void checkDolorMuscular() {
        // evaluar si padece de dolor muscular
        if (dolor_muscular) {
            sintomas[2]++;//resfriado++
            sintomas[5]++;//sarampión++
            sintomas[9]++;//dengue++
            sintomas[10]++;//chikungunya++
            sintomas[11]++;//zika++

            if (edad > 11) 
                sintomas[22]++;//herpes++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor en las articulaciones para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma. 
     */
    private void checkDolorArti() {
        // evaluar si padece de dolor en las articulaciones
        if (dolor_articulaciones) {
            sintomas[9]++;//dengue++
            sintomas[10]++;//chikungunya++
            sintomas[11]++;//zika++
            
            if (edad > 11) 
                sintomas[21]++;//sifilis++
            
            if (edad > 40) 
                sintomas[25]++;//artritis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de secreciones nasales para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkSecreNasal() {
        // evaluar si padece de secresiones nasales
        if (secrecion_nasal) {
            sintomas[2]++;//resfriado++
            sintomas[3]++;//asma++
            
            if (edad < 12) 
                sintomas[16]++;//amigdalitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de nauseas para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkNauseas() {
        // evaluar si padece de nauseas
        if (nauseas) {
            sintomas[4]++;//eritema_infeccioso++
            sintomas[8]++;//gastroenteritis++
            sintomas[10]++;//chikungunya++
            
            if (edad > 11)
                sintomas[19]++;//apendicitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de vómitos para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkVomitos() {
        // evaluar si padece de vómitos
        if (vomitos) {
            sintomas[2]++;//resfriado++
            sintomas[8]++;//gastroenteritis++
            sintomas[9]++;//dengue++
            
            if (edad >= 10 && edad < 20) 
                sintomas[17]++;//meningitis++
            
            if (edad > 11) 
                sintomas[19]++;//apendicitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de picazón para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkPicazon() {
        // evaluar si padece de picazón
        if (picazon) {
            sintomas[7]++;//dermatitis++
            sintomas[9]++;//dengue++
            sintomas[14]++;//varicela++
            
            // pregunta de rutina para mejorar el prediagnóstico
            int input = JOptionPane.showConfirmDialog(null, "¿La picazón es en el área de la cara y/o nalga?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
            // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
            if (input == 0)
                sintomas[4]++;//eritema_infeccioso++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de pérdida de apetito para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkPerdidaApetito() {
        // evaluar si padece de pérdida de apetito
        if (perdida_apetito) {
            sintomas[8]++;//gastroenteritis++
            sintomas[10]++;//chikungunya++
            
            if (edad > 11) 
                sintomas[19]++;//apendicitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de debilidad para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDebilidad() {
        // evaluar si padece de debilidad
        if (debilidad) {
            sintomas[1]++;//tuberculosis++
            sintomas[8]++;//gastroenteritis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de debilidad muscular para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDebMuscular() {
        // evaluar si padece de debilidad muscular
        if (debilidad_muscular) {
            sintomas[12]++;//hipotiroidismo++
            sintomas[13]++;//hipertiroidismo++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor de cabeza para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDolorCabeza() {
        // evaluar si padece de dolor de cabeza
        if (dolor_cabeza) {
            sintomas[2]++;//resfriado++
            sintomas[4]++;//eritema_infeccioso++
            sintomas[6]++;//rubeola++
            sintomas[9]++;//dengue++
            sintomas[10]++;//chikungunya++
            
            if (edad >= 10 && edad < 20) 
                sintomas[17]++;//meningitis++
            
            if (edad > 11) {
                sintomas[20]++;//VIH++
                sintomas[21]++;//sífilis++
                sintomas[22]++;//Herpes++
            }
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de diarrea para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDiarrea() {
        // evaluar si padece de diarrea
        if (diarrea) {
            sintomas[8]++;//gastroenteritis++
            
            if (edad > 11) 
                sintomas[19]++;//apendicitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de cansancio para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkCansancio() {
        // evaluar si padece de cansancio
        if (cansancio) {
            sintomas[10]++;//chikungunya++
            
            if (edad > 11) 
                sintomas[20]++;//VIH++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de manchas en la piel para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkManchasPiel() {
        // evaluar si padece de manchas en la piel
        if (manchas_piel) {
            sintomas[9]++;//dengue++
            sintomas[10]++;//chikungunya++
            
            if (edad >= 10 && edad < 20) 
                sintomas[17]++;//meningitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de estreñimiento para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkEstrenimiento() {
        // evaluar si padece de estreñimiento
        if (estrenimiento) {
            sintomas[12]++;//hipotiroidismo++
            
            if (edad > 11) 
                sintomas[19]++;//apendicitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de congestión nasal para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkCongNasal() {
        // evaluar si padece de congestión nasal
        if (congestion_nasal) {
            // [0] bronquitis++ [2] resfriado++ [4] eritema_infeccioso++ [6] rubeola++
            for(int i = 0; i < 7; i = i + 2) 
                sintomas[i]++;
            
            if (edad < 12) 
                sintomas[16]++;//amigdalitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor de garganta para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDolorGarganta() {
        // evaluar si padece de dolor de garganta
        if (dolor_garganta) {
            sintomas[0]++;//bronquitis++
            sintomas[2]++;//resfriado++
            sintomas[4]++;//eritema_infeccioso++
            
            if (edad > 11) 
                sintomas[21]++;//sifilis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dificultad respiratoria para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDifResp() {
        // evaluar si padece de dificultad respiratoria
        if (dificultad_respiratoria) {
            sintomas[3]++;//asma++
            sintomas[9]++;//dengue++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de malestar general para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkMalestarGeneral() {
        // evaluar si padece de malestar general
        if (malestar_general) {
            sintomas[6]++;//rubeola++
            sintomas[11]++;//zika++
            
            if (edad > 11) 
                sintomas[22]++; //herpes++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de piel roja para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkPielRoja() {
        // evalur si padece de piel roja
        if (piel_roja) {
            sintomas[7]++;//dermatitis++
            // pregunta de rutina para mejorar el prediagnóstico
            int input = JOptionPane.showConfirmDialog(null, "¿La piel roja es en el área de la cara y/o nalga?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
            // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
            if (input == 0)
                sintomas[4]++;//eritema_infeccioso++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor abdominal para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDolorAb() {
        // evaluar si padece de dolor abdominal
        if (dolor_abdominal) {
            sintomas[8]++;//gastroenteritis++
            
            if (edad > 11) {
                // pregunta de rutina para mejorar el prediagnóstico
                int input = JOptionPane.showConfirmDialog(null, "¿El dolor abdominal es persistente en el \nárea media derecha inferior?", "Preguntas de Rutina", JOptionPane.YES_NO_OPTION);
                // aquí 0 significa que sí, esto se debe al retorno ConfirmDialog
                if (input == 0)
                    sintomas[19]++;//apendicitis++
            }
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de sangrado en las encías para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkSangradoEncias() {
        // evaluar si padece de sangrado en las encías
        if (sangrado_encias) {
            sintomas[9]++;//dengue++
            
            if (edad > 11 && edad < 55) 
                sintomas[18]++;//gingivitis++
        }
    }

    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de úlceras en los genitales para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkUlceraGenital() {
        // evaluar si padece de úlceras en los genitales
        if (ulcera_genital && edad > 11) {
            sintomas[21]++;//sifilis++
            sintomas[22]++;//herpes++
        }
    }
    
    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de aumento del sudor para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkAumentoSudor() {
        // evaluar si padece de aumento del sudor
        if(aumento_sudor) 
            sintomas[13]++; //hipertiroidismo++
    }
    
    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor de pecho para así sumar uno (1) a los 
     * prediagnósticos que posean dicho síntoma.
     */
    private void checkDolorPecho() {
        // evaluar si padece de dolor de pecho y la edad del paciente en mayor a 20
        if(dolor_pecho&&edad>20) 
                sintomas[26]++;//preinfarto++
    }
    
    /**Método de soporte que nos ayuda a determinar si el paciente
     * padece de dolor fuerte en el cuello para así sumar uno (1) 
     * a los prediagnósticos que posean dicho síntoma.
     */
     private void checkDolorFuerteCuello() {
         // evaluar si padece de dolor fuerte en el cuello y la edad del paciente en mayor a 20
        if(dolor_fuerte_cuello&&edad>20) 
                sintomas[26]++;//preinfarto++
    }

     /**Método que calcula la probabilidad de cada prediagnóstico. */
    public void detProbability() {
        // verificando los síntomas del paciente
        checkTos();
        checkFiebre();
        checkFatiga();
        checkErupPiel();
        checkPerdidaPeso();
        checkDolorMuscular();
        checkDolorArti();
        checkSecreNasal();
        checkNauseas();
        checkVomitos();
        checkPicazon();
        checkPerdidaApetito();
        checkDebilidad();
        checkDebMuscular();
        checkDolorCabeza();
        checkDiarrea();
        checkCansancio();
        checkManchasPiel();
        checkEstrenimiento();
        checkCongNasal();
        checkDolorGarganta();
        checkDifResp();
        checkMalestarGeneral();
        checkPielRoja();
        checkDolorAb();
        checkSangradoEncias();
        checkUlceraGenital();
        checkAumentoSudor();
        checkDolorPecho();
        checkDolorFuerteCuello();
        
        // determinar la probabilidad de cada prediagnóstico
        for (int i = 0; i < 27; i++) {
            probabilidad[i] = sintomas[i] / (float) totalSintomas[i];
        }
        
        // copiar el arreglo que contiene la probabilidad de cada prediagnóstico
        System.arraycopy(probabilidad, 0, probCopy, 0, 27);
        
        // ordenar de forma ascendente 
        Arrays.sort(probCopy);
        
        // obteniendo las 3 probabilidades más altas
        top3[0] = probCopy[26];
        top3[1] = probCopy[25];
        top3[2] = probCopy[24];
        
        // índices de las probabilidades más altas, con esto se determina el prediagnóstico al que pertenece la probabilidad
        top3Indice[0] = findIndex(probabilidad, top3[0]);
        top3Indice[1] = findIndex(probabilidad, top3[1]);
        top3Indice[2] = findIndex(probabilidad, top3[2]);
        
        // obteniendo la categoría de los 3 primeros prediagnósticos
        top3Categoria[0] = categoria[ top3Indice[0]];
        top3Categoria[1] = categoria[ top3Indice[1]];
        top3Categoria[2] = categoria[ top3Indice[2]];
    }
}
