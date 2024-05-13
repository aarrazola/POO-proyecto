/*
Clase: ArrayListinventario

(Controlador de Clase Producto)

Autor: Fernando Cordero 
Version: 1.0
*/

package globoFeliz.controlador;

import globoFeliz.modelo.*;
import globoFeliz.vista.*;

public class GestionInventario {

	 public static void main(String[] args) {
	
// VARIABLES AUXILIARES
		
		IGUProductos interfaz = new IGUProductos();

		String id;

		int opcion;

		Producto productoNuevo;

 		ArrayListProductos inventario = new ArrayListProductos();

// PRODUCTOS INICIALES

		// // DATOS INICIALES

		Producto productoPrueba = new Producto ("Paquete de Globos 0", "aaa", 115.41f, 35);

		Producto productoPrueba1 = new Producto ("Paquete de Globos 1", "eee", 224.61f, 20);

		Producto productoPrueba2 = new Producto ("Paquete de Globos 2", "iii", 123.43f, 56);

		Producto productoPrueba3 = new Producto ("Paquete de Globos 3", "ooo", 321.51f, 66);

		Producto productoPrueba4 = new Producto ("Paquete de Globos 4", "uuu", 150.00f, 67);


		inventario.agregarProducto(productoPrueba);
		inventario.agregarProducto(productoPrueba1);
		inventario.agregarProducto(productoPrueba2);
		inventario.agregarProducto(productoPrueba3);
		inventario.agregarProducto(productoPrueba4);


		do {

			opcion = interfaz.menuInventario();

			switch (opcion) {

				case 1:

					productoNuevo = interfaz.leerDatosProducto();
					inventario.agregarProducto(productoNuevo);
					
					break;
				
				case 2: 

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						productoNuevo = interfaz.leerDatosProducto();
						inventario.remplazarProducto(id, productoNuevo);

					}

					break;
				
				case 3: 

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						int opcionModificar;

						String nuevaCadena;
						float nuevoPrecio;
						int nuevoExistencias;

						opcionModificar = interfaz.leerOpcionModificar();

						switch (opcionModificar) {

							case 1:
								
								nuevaCadena = interfaz.leerNombreNuevo();

								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;
						
							case 2:
								
								nuevaCadena = interfaz.leerDescripcionNuevo();
								
								inventario.modificarProducto(id, opcionModificar, nuevaCadena, 0.0f, 0);
		
								break;	
		
							case 3:
								
								nuevoPrecio = interfaz.leerPrecioNuevo();
								
								inventario.modificarProducto(id, opcionModificar, " ", nuevoPrecio, 0);
		
								break;	
		
							case 4:
								
								nuevoExistencias = interfaz.leerExistenciasNuevo();
								
								inventario.modificarProducto(id, opcionModificar, " ", 0.0f, nuevoExistencias);
		
								break;	
							
							default:
								break;
						}

					}

					break;
				
				case 4: 

					id = interfaz.leerIdProducto();

					if (inventario.buscarProducto(id) == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						inventario.eliminarProducto(id);

					}

					break;
				
				case 5:

					id = interfaz.leerIdProducto();

					int posicion = inventario.buscarProducto(id);

					if (posicion == -1) {

						interfaz.mensaje("El id que ingresaste no existe");

					} else {

						Producto productoEscrito = inventario.getProducto(posicion);

						interfaz.mensaje(productoEscrito.imprimirDatos());
					}
				
					break;
				
				case 6: 
				
					inventario.escribir();
				
					break;
				
				
				case 0: 
				
					break;
				
				
				default:

					break;
				

				}

		} while (opcion != 0);
	
	} 

}


