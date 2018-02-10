package aed.positiveiterator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.NoSuchElementException;

import aed.positionlist.NodePositionList;
import aed.positionlist.PositionList;



/**
 * @author groman
 *
 */

public class TesterInd4 {

	public static final String LAB_NAME = "Entrega Individual 4";
	
	public static void main(String[] args) {
		
		try {
			String[] ids = ManagementFactory.getRuntimeMXBean().getName()
					.split("@");
			BufferedWriter bw = new BufferedWriter(new FileWriter("pid"));
			bw.write(ids[0]);
			bw.close();
		} catch (Exception e) {
			System.out.println("Avisa al profesor de fallo sacando el PID");
		}
		boolean exception; 
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{});
			Integer [] output = {}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= null;
			Integer [] output = null; 
			exception = true;
			doCheck(input,output,exception);
		}		
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{1});
			Integer [] output = {1}; 
			exception = false;
			doCheck(input,output,exception);
		}		
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{1,1,1,1,1});
			Integer [] output = {1,1,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{1,1,1,-1,2});
			Integer [] output = {1,1,1,2}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{0,2,1,1,1});
			Integer [] output = {2,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{1,3,1,3,1});
			Integer [] output = {1,3,1,3,1}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{new Integer(1000),new Integer(1000)});
			Integer [] output = {new Integer(1000),new Integer(1000)}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{-1000,-999,-1000,-1000});
			Integer [] output = {}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{-128,200});
			Integer [] output = {200}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{2,0,1,0,1,2});
			Integer [] output = {2,1,1,2}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{2,new Integer(1),1,1,1,2,0,-1,null});
			Integer [] output = {2,new Integer(1),1,1,1,2}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{-1,-1,1,2,3,4,5,6,0,0});
			Integer [] output = {1,2,3,4,5,6}; 
			exception = false;
			doCheck(input,output,exception);
		}		

		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{3,3,null,1,1,1,-1,null,-1});
			Integer [] output = {3,3,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{-1,null,3,3,null,1,1,1});
			Integer [] output = {3,3,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{null,null,3,3,null,1,1,1});
			Integer [] output = {3,3,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{null,null,3,3,null,null,1,1,1,null,null});
			Integer [] output = {3,3,1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{null,-1,null,null,null,1,1,1,-1,-1});
			Integer [] output = {1,1,1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{null,null,null,null});
			Integer [] output = {}; 
			exception = false;
			doCheck(input,output,exception);
		}	
		
		{
			PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{1,null,null});
			Integer [] output = {1}; 
			exception = false;
			doCheck(input,output,exception);
		}	
			// Test to check the exceptions
		{
			try {
				doCheckExceptions();
			} catch (Throwable exc) {
				System.out.println("\n*** Tester Error  (" + LAB_NAME + "): devuelve la siguiente excepcion \n");
				exc.printStackTrace();
				throw new Error("Error en test: resultado incorrecto");		
			}
		}
		
		System.out.println("\n Tester  (" + LAB_NAME + "): Test finalizado correctamente.");
	}

	/**
	 * Método que prueba el resultado obtenido al llamar a compactar
	 * @param list Lista de entrada
	 * @param esperado Resultado esperado
	 * @param excepcion ¿debe lanzar una excepcion?
	 */
	static void doCheck(PositionList<Integer> lista, Integer [] esperado, boolean excepcion) {

		try {
			PositivePositionListIterator<Integer> it = new PositivePositionListIterator<Integer>(lista);
			Object [] input = lista.toArray(); 

			PositionList<Integer> result = new NodePositionList<Integer>();

			while(it.hasNext()) {
				result.addLast(it.next());
			}
			
			Object [] input2 = lista.toArray(); 
			
			if (!Arrays.equals(input, input2)) {
				System.out.println("\n*** Tester Error (" + LAB_NAME + "): Se ha modificado el contenido de la lista de entrada"); 
				throw new Error("Error en test: resultado incorrecto");		    
				
			}
			
			if (!Arrays.equals(result.toArray(), esperado)) {
				System.out.println("\n*** Tester Error (" + LAB_NAME + "): el método devuelve "+ printArray(result.toArray()) + " " +
						"\n en lugar de " + printArray(esperado) + " cuando se invoca con " + printArray(lista.toArray())+ "\n"); 
				throw new Error("Error en test: resultado incorrecto");		    
			}
		} catch (IllegalArgumentException exc) {
			if (!excepcion) {
				System.out.println("\n*** Tester Error (" + LAB_NAME + "): NO se esperaba la excepcion: IllegalArgumentException\n ");
				exc.printStackTrace();
				throw new Error("Error en test: resultado incorrecto");
			}
		} catch (Throwable exc) {
			System.out.println("\n*** Tester Error  (" + LAB_NAME + "): devuelve la siguiente excepcion \n");
			exc.printStackTrace();
			throw new Error("Error en test: resultado incorrecto");		
		}
	}

	/**
	 * Método que prueba si se lanzan las excepciones adecuadasx
	 */
	static void doCheckExceptions() throws Exception {
		PositionList<Integer> input= new NodePositionList<Integer>(new Integer []{});
		PositivePositionListIterator<Integer> it = new PositivePositionListIterator<Integer>(input);

		try {
			it.next();
			throw new Exception ("Debería haber saltado la excepcion NoSuchElementException "
					+ "haciendo next de una lista vacia" ); 
		}
		catch (NoSuchElementException e) {
			; // OK! Resultado esperado
		}

		try {
			it.remove();
			throw new Exception ("Debería haber saltado la excepcion UnsupportedOperationException "
					+ "haciendo remove"); 
		}
		catch (UnsupportedOperationException e) {
			; // OK! Resultado esperado 
		}
		
		try {
			PositionList<Integer> input2= new NodePositionList<Integer>(new Integer []{1,2,3});
			PositivePositionListIterator<Integer> it2 = new PositivePositionListIterator<Integer>(input2);
			while (it2.hasNext()) {
				it2.next(); 
			}
			it2.next(); 
			throw new Exception ("Debería haber saltado la excepcion NoSuchElementException "
					+ "al hacer next despues de iterar sobre toda la lista" ); 
		}
		catch (NoSuchElementException e) {
			; // OK! Resultado esperado
		}
		
	}

	
	static String printArray(Object[] arr) {
		if (arr == null) {
			return "'null'"; 
		}
		StringBuffer result = new StringBuffer();
		result.append("[");
		for (int i=0; i<arr.length; i++) {
			result.append(arr[i]);
			if (i<arr.length-1) {
				result.append(",");
			}
		}
		result.append("]");
		return result.toString();
	}
}
