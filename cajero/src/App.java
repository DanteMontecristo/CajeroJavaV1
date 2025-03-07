import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //variables y constantes
        final int PIN_CORRECTO = 1234;
        double saldo = 1000000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

        //Autenticación segun intentos
        while (intentos < 3) {
            System.out.println("¡Bienvenido a su cajero!");
            System.out.println("Ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();

            if (pinIngresado == PIN_CORRECTO) {
                break;
            } else {
                intentos ++;
                System.out.println("¡PIN incorrecto!");
            }

            if (intentos == 3) {
                cuentaBloqueada = true;
                System.out.println("Demaciados intentos incorrectos, cuenta bloqueada");
            }
        }

        //Si la cuenta esta bloqueada finalizara el programa
        if (cuentaBloqueada) {
            scanner.close();
            return;
        }

        //Menú del cajero
        int opcion;
        do {
            System.out.println("\nBienvenido a su cuenta de banco");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Finalizar transacción");
            System.out.println("¿Que decea hacer el dia de hoy?");
            opcion = scanner.nextInt();

            //Manejo de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $ " + saldo);
                    break;

                case 2:
                    System.out.println("¿Cuanto saldo va ha retirar?: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo || retiro <= 0) {
                        System.out.println("No tiene saldo sufuciente para realizar esa transacción o el");
                        System.out.println("valor ingresado es incorrecto, su ssaldo actual es: $ " + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Transacción exitosa, su nuevo saldo es: " + saldo);
                    }
                    break;

                case 3:
                    System.out.println("Cuanto desea consignar?: ");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Consignación exitosa, su nuevo saldo es: " + saldo);
                    } else {
                        System.out.println("El valor ingresado es incorrecto!");
                    }
                    break;
                case 4:
                    System.out.println("¿Cuanto dinero va a transferir?: ");
                    double transferir = scanner.nextDouble();
                    if (transferir > saldo || transferir <= 0) {
                        System.out.println("No tiene saldo sufuciente para realizar esa transacción o el");
                        System.out.println("valor ingresado es incorrecto, su ssaldo actual es: $ " + saldo);
                    } else {
                        System.out.println("Ingrese su PIN: ");
                        int pinIngresado = scanner.nextInt();

                        if (pinIngresado == PIN_CORRECTO) {
                            saldo -= transferir;
                            System.out.println("Transacción exitosa, su nuevo saldo es: " + saldo);
                        } else {
                            System.out.println("¡PIN incorrecto, transacción no realizada!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Gracias por preferirnos, nos volveremos a ver");
                    break;

                default:
                    System.out.println("Opción incorrecta, intente de nuevo");
                    break;
            }

        } while (opcion != 5);
        scanner.close();
    }
}
