/*
Clase: ControladorVentas
Autor: Fernando Cordero 
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionVentas {
    

    
// ATRIBUTOS

	private ArrayListVenta ventas = new ArrayListVenta(); // MODELO

	private IGUVentas interfaz = new IGUVentas(); // VISTA

    
// CONSTRUCTOR 	

	// sin parametros 

	public GestionVentas () {

		// DATOS INICIALES (PRUEBA)

		Venta ventaPrueba = new Venta (null, " ", " ", " ", 0.0f);

		Venta ventaPrueba2 = new Venta (null, " ", " ", " ", 0.0f);

		Venta ventaPrueba3 = new Venta (null, " ", " ", " ", 0.0f);

		Venta ventaPrueba4 = new Venta (null, " ", " ", " ", 0.0f);

		Venta ventaPrueba5 = new Venta (null, " ", " ", " ", 0.0f);

		ventas.agregarVenta(ventaPrueba);
		ventas.agregarVenta(ventaPrueba2);
		ventas.agregarVenta(ventaPrueba3);
		ventas.agregarVenta(ventaPrueba4);
		ventas.agregarVenta(ventaPrueba5);

	}

	// con parametros (pendiente)



// METODO PRINCIPAL CLASE PRODUCTO

	public void ejecutarControlador () {


		// VARIABLES AUXILIARES

		String id;
		int opcion;
		Venta ventaNueva;

		// CONTROLADOR DE MENU PRINCIPAL

		do {

			opcion = interfaz.menuInventario();

			// SWITCH MENU

			switch (opcion) {


					

				case 1: // AGREGAR (CREATE)

					ventaNueva = new Venta (interfaz.leerProductosVendidos(), " ", " ", " ", 0.0f);

					ventas.agregarVenta(ventaNueva);
					
					break;

				case 2: // ELIMINAR (DELETE)

					id = interfaz.leerIdVenta();

					if (ventas.buscarVenta(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						ventas.eliminarVenta(id);

					}

					break;
				
				case 3: // BUSCAR (READ)

					id = interfaz.leerIdVenta();

					int posicion = ventas.buscarVenta(id);

					if (posicion == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						Venta ventaEscrita = ventas.getVenta(posicion);

						interfaz.mensaje(ventaEscrita.imprimirDatos());
					}
				
					break;
				
				case 4: // LISTAR (READ) 
				
					interfaz.escribirVentas(ventas);
				
					break;
				
				
				case 0: // SALIR
				
					break;
				
				
				default:

					break;
				

				}

		} while (opcion != 0);

	}

}
