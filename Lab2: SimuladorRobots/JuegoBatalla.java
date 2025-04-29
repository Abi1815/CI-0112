//JuegoBatalla.java

import java.util.Scanner;

public class JuegoBatalla{

    //Arreglo para los objetos de tipo Robot
    private Robot[] arreglo=new Robot[10];
    Scanner scanner=new Scanner(System.in);

    //Metodo para iniciar la batalla
    public void iniciarBatalla() {

        //Esta parte tiene la funcion de pedir y guardar los robots de los participantes
        System.out.println("Bienvenido al simulador de batalla de robots, por favor indique la cantidad de participantes (maximo 10 participantes).");
        int participantes=scanner.nextInt();
        for(int i=0; i < participantes; i++){
            System.out.println("Escriba el nombre del robot.");
            String robotNombre=scanner.next();
            System.out.println("Indique la cantidad de vida (entre 50 y 100).");
            double robotPuntosVida=scanner.nextDouble();
            if (robotPuntosVida < 50 || robotPuntosVida > 100) {
                System.out.println("Cantidad de vida es invalida, se debe elegir entre 50 y 100.");
                return;
            }
            System.out.println("Indique la cantidad de danyo que puede causar (entre 10 y 20).");
            double robotAtaque=scanner.nextDouble();
            if (robotAtaque < 10 || robotAtaque > 20) {
                System.out.println("Cantidad de ataque es invalida, se debe elegir entre 10 y 20.");
                return;
            }
            Robot robot=new Robot(robotNombre, robotPuntosVida, robotAtaque);
            arreglo[i]=robot;
            System.out.println("----------------------------------------------------------------");
        }

        //Esta parte sirve para que los participante eligan a cual robot atacar
        int robotVivos=participantes;
        while(robotVivos > 1){
            for(int i=0; i < arreglo.length; i++) {
                if(arreglo[i] != null){
                    System.out.println("El participante " + arreglo[i].getNombre() + " debe elegir a cual robot atacar.");
                    String nombreRobotAtacado=scanner.next();
                    Robot robotAtacado = null;

                    //Compara el String de nombreRobotAtacado con los nombres de los robots
                    for(int j=0; j < arreglo.length; j++) {
                        if (arreglo[j] != null && arreglo[j].getNombre().equals(nombreRobotAtacado)) {
                            robotAtacado = arreglo[j];
                            break;
                        }
                    }
                    if (robotAtacado != null){
                        arreglo[i].atacar(robotAtacado);
                    } else {
                        System.out.println("El participante " + nombreRobotAtacado + " no existe");
                        System.out.println("----------------------------------------------------------------");
                    }
                }
            }

            //Aqui avisa los participantes que perdieron y revisa cuantos robots siguen vivos para que el while se siga ejecutando 
            robotVivos=0;
            for(int i=0; i < arreglo.length; i++) {
                if (arreglo[i] != null){
                    if(arreglo[i].estaVivo()){
                        robotVivos++; 
                    } else {
                        System.out.println("El participante " + arreglo[i].getNombre() + " queda eliminado.");
                        System.out.println("----------------------------------------------------------------");
                    }
                }
            }
        }
    }

    //Metodo para mostrar al ganador
    public void mostrarGanador() {
        for(int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] != null) {
                System.out.println("El participante " + arreglo[i].getNombre() + " es el ganador.");
                break;
            }
        }
    }

    //Metodo main para iniciar el juego
    public static void main(String[] args) {
        JuegoBatalla partidas= new JuegoBatalla();
        partidas.iniciarBatalla();
        partidas.mostrarGanador();
    }
}