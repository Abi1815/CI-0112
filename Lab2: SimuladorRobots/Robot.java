//Robot.java

public class Robot {
    //Atributos
    private String nombre;
    private double puntosVida;
    private double ataque;

    //Setters
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setPuntosVida(double puntosVida){
        this.puntosVida=puntosVida;
    }
    public void setAtaque(double ataque){
        this.ataque=ataque;
    }

    //Getters
    public String getNombre(){
        return nombre;
    }
    public double getPuntosVida(){
        return puntosVida;
    }
    public double getAtaque(){
        return ataque;
    }

    //Constructor
    public Robot(String nombre, double puntosVida, double ataque){
        this.nombre=nombre;
        this.puntosVida=puntosVida;
        this.ataque=ataque;
    }

    //Atacar a otro robot
    public void atacar(Robot otroRobot) {
        otroRobot.puntosVida = otroRobot.puntosVida-ataque;
        System.out.println("Los puntos de vida de " + otroRobot.nombre + " es de " + otroRobot.puntosVida);
        System.out.println("----------------------------------------------------------------");
    }

    //Verificar si el robot sigue con vida
    public boolean estaVivo() {
        if (puntosVida > 0){
            return true;
        } else {
            return false;
        }
    }
}