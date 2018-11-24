package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
			
private static Caballo caballo;

public MainApp() {
	
	caballo = null;
}
	
public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
	mostrarMenu();
	}

	
private static void mostrarMenu() {
		
	int numero;
		
		do {
			System.out.println("Mostrar Menú");	
			System.out.println("1.Crear caballo por defecto");
			System.out.println("2.Crear caballo de un color");
			System.out.println("3.Crear caballo de un color columna inicial valida");
			System.out.println("4.Mover el caballo");
			System.out.println("0.Salir");
			
			numero = elegirOpcion();
			ejecutarOpcion(numero);
			}while (numero<=0 && numero>=4);
		
	}
private static int elegirOpcion() {
	
	int numero=6;
	do {
		System.out.println("Elegir Opción");
		numero = Entrada.entero();
	}while  (numero<0 || numero>4);	
	
	return numero;	
}

private static void ejecutarOpcion(int numero) {

		switch (numero) {

		case 0:
			System.exit(0);
			break;
		case 1:
			crearCaballoDefecto();
			mostrarMenu();
			break;
		case 2:
			crearCaballoDefectoColor();
			mostrarMenu();
			break;
		case 3:
			crearCaballoColorPosicion();
			mostrarMenu();
			break;
		case 4:
			mover();
			mostrarMenu();
			break;

		}
	}

private static void crearCaballoDefecto() {
		caballo = new Caballo();
		System.out.println(caballo);
	}


private static void crearCaballoDefectoColor() {
		Color color = elegirColor();
		caballo = new Caballo(color);
		System.out.println(caballo);		
	}


private static Color elegirColor() {
	
	Color color;
	int colorNumero;
		
	color = null;
	do {	
		System.out.println("Elige un color \n1.Color Blanco \n2.Color Negro");
		colorNumero = Entrada.entero();
			if (colorNumero == 1) {
			color = (Color.BLANCO);
			}
			if (colorNumero ==2) {
			color = (Color.NEGRO);
			}
	}
	while 
		(colorNumero!=1 && colorNumero!=2);
	return color;
	}
private static void crearCaballoColorPosicion() {
	
	Color color = elegirColor();
	char columna = elegirColumnaInicial();
	caballo = new Caballo(color,columna);
	System.out.println(caballo);
}
private static char elegirColumnaInicial() {
	
	
	char columna;
	
	Posicion posicion;
	posicion = (null);
	columna = 0;
	
	do {
		
		System.out.println("Elige Columna \n B.Columna b \n G.Columna g");
		columna = Entrada.caracter();
		if (columna == 'b') {
			posicion = new Posicion (1,columna);
					}
		if (columna == 'g') {
			posicion = new Posicion (8,columna);
		}
			
		} while 
			(columna!='b' && columna!='g');
	return columna;
	}

private static void mover() {
	
	try {
		
		mostrarMenuDirecciones();
		caballo.mover(elegirDireccion());
		System.out.print(caballo);		
		mostrarMenu();
		
	} catch (OperationNotSupportedException e) {
		
		System.out.println("Movimiento no válido");
	}
	
	mover();
		
}
private static void mostrarMenuDirecciones() {
	
	System.out.println("MENÚ DE DIRECCIONES");
	System.out.println("1.Mover: Arriba a la derecha");
	System.out.println("2.Mover: Arriba a la izquierda");
	System.out.println("3.Mover: Derecha hacia abajo");
	System.out.println("4.Mover: Derecha hacia arriba");
	System.out.println("5.Mover: Abajo a la derecha");
	System.out.println("6.Mover: Abajo a la izquierda");
	System.out.println("7.Mover: Izquierda hacia abajo");
	System.out.println("8.Mover: Izquierda hacia arriba");
	
}

	private static Direccion elegirDireccion() {

		Direccion movimiento;
		int posicion;
		movimiento = null;

		do {
			System.out.println("Introduce el numero de la dirección");
			posicion = Entrada.entero();

		} while (posicion < 1 || posicion > 8);

		switch (posicion) {

		case 1:
			movimiento = Direccion.ARRIBA_DERECHA;
			break;
		case 2:
			movimiento = Direccion.ARRIBA_IZQUIERDA;
			break;
		case 3:
			movimiento = Direccion.DERECHA_ABAJO;
			break;
		case 4:
			movimiento = Direccion.DERECHA_ARRIBA;
			break;
		case 5:
			movimiento = Direccion.ABAJO_DERECHA;
			break;
		case 6:
			movimiento = Direccion.ABAJO_IZQUIERDA;
			break;
		case 7:
			movimiento = Direccion.IZQUIERDA_ABAJO;
			break;
		case 8:
			movimiento = Direccion.IZQUIERDA_ARRIBA;
			break;

		}

		return movimiento;

	}
}
