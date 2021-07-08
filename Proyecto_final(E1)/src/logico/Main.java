package logico;

import java.util.Scanner;

public class Main {

	public Main() {
		int num1 = 0, num2 = 0, resultado = 0;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese el primer valor: ");
		num1 = entrada.nextInt();
		
		System.out.println("Ingrese el segundo valor: ");
		num2 = entrada.nextInt();
		
		resultado = num1 + num2;
		System.out.println("Su resultado es " + resultado + " Coño");
	
	}
}
