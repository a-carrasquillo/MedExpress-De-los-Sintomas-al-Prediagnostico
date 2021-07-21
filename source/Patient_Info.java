/**Clase que nos permite almacenar la información de un paciente
 *
 * @author a-carrasquillo
 */
public class Patient_Info {
    //data fields
    private String nombre, genero, preDiag;
    private int peso, edad;
    
    /** Constructor por defecto */
    Patient_Info() {
        nombre = "";
        genero = "";
        peso = 0;
        edad = 0;
        preDiag = "";
    }
    
    /**Constructor especial
     * Copia la información de una instancia ya existente a una nueva.
     * 
     * @param Info - objeto que contiene la información a copiar
     */
    Patient_Info(Patient_Info Info) {
        nombre=Info.getNombre();
        genero=Info.getGenero();
        peso=Info.getPeso();
        edad=Info.getEdad();
        preDiag=Info.getPreDiag();
    }
    
    //getters
    /**Método que nos permite recuperar el nombre del paciente
     * 
     * @return nombre del paciente
     */
    String getNombre() {
        return nombre;
    }
    
    /**Método que nos permite recuperar el género del paciente
     * 
     * @return género del paciente
     */
    String getGenero() {
        return genero;
    }
    
    /**Método que nos permite recuperar la edad del paciente
     * 
     * @return edad del paciente
     */
    int getEdad() {
        return edad;
    }
    
    /**Método que nos permite recuperar el peso del paciente
     * 
     * @return peso del paciente
     */
    int getPeso() {
        return peso;
    }
    
    /**Método que nos permite recuperar el prediagnóstico del paciente
     * 
     * @return prediagnóstico del paciente
     */
    String getPreDiag() {
        return preDiag;
    }
    
    //setters
    /**Método que nos permite modificar el valor del nombre del paciente
     * 
     * @param nombre - nombre del paciente
     */
    void setNombre(String nombre) {
        this.nombre = nombre;
     }
    
    /**Método que nos permite modificar el valor del género del paciente
     * 
     * @param genero - género del paciente
     */
    void setGenero(String genero) {
        this.genero = genero;
    }
    
    /**Método que nos permite modificar el valor de la edad del paciente
     * 
     * @param edad - edad del paciente
     */
    void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**Método que nos permite modificar el valor del peso del paciente
     * 
     * @param peso - peso del paciente
     */
    void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**Método que nos permite modificar el valor del prediagnóstico
     * 
     * @param preDiag - prediagnóstico del paciente
     */
    void setPreDiag(String preDiag) {
        this.preDiag = preDiag;
    }
}
