package co.edu.udea.app;

/**
 * 
 * @author Rafael Luna
 * @version 1.0
 * Esta clase permite convertir numeros enteros a numeros romanos
 *
 */
public class NumerosRomanos{

	public String convertir(int numero) {
		String resultado = "";
		int i, j, tamanoNumero = obtenerTamano(numero);
		String resultadoTemporal[] = new String[tamanoNumero];
		int digitos[] = new int[tamanoNumero];
		for (i = 0; i < tamanoNumero; i++) {
			resultadoTemporal[i] = "";
		}
		obtenerDigitos(digitos,numero,tamanoNumero);
		for (i = 0; i < tamanoNumero; i++) {
			if (digitos[i] > 4) {
				resultadoTemporal[i] = convertirARomano(i, 5);
				digitos[i] = digitos[i] - 5;
				if (4 == digitos[i])
					resultadoTemporal[i] = convertirARomano(i, 1) + convertirARomano(i, 10);
				else {
					j = 0;
					while (j < digitos[i]) {
						resultadoTemporal[i] = resultadoTemporal[i] + convertirARomano(i, 1);
						j++;
					}
				}
			} else {
				if (4 == digitos[i])
					resultadoTemporal[i] = convertirARomano(i, 1) + convertirARomano(i, 5);
				else {
					j = 0;
					while (j < digitos[i]) {
						resultadoTemporal[i] = resultadoTemporal[i] + convertirARomano(i, 1);
						j++;
					}
				}
			}
		}
		for (i = tamanoNumero - 1; i >= 0; i--)
			resultado = resultado + resultadoTemporal[i];
		return resultado;
	}

	/**
	 * Calcular el tamaño de del numero (cantidad de digitos)
	 * @param numero_parametro: numero al que se obtendrá el tamaño
	 * @return tamaño del numero pasado como parametro (corresponderá a la cantidad de digitos)
	 */
	public int obtenerTamano(int numero_parametro) {
		int tamano = 0, numero = numero_parametro;
		while (numero > 0) {
			numero = numero / 10;
			tamano++;
		}
		return tamano;
	}

	/**
	 * Este metodo permite convertir numero entero (numero fundamental) a numero romano, entiendase por numero fundamental 
	 * a los numeros romanos que no son derivados de otros, por ejemplo: I,V,X,L...
	 * @param posicion: Especifica la posicion que tiene el digito numeroAConvertir en el numero que se quiere convertir
	 * @param numeroAConvertir: Numero entero que se va a convertir en numero romano
	 * @return el numero romano correspondiente al digito numeroAConvertir
	 */
	public String convertirARomano(int posicion, int numeroAConvertir) {
		String numeroEnRomano = null;
		int numero = (int) (numeroAConvertir * (Math.pow(10, posicion)));
		switch (numero) {
		case 1:
			numeroEnRomano = "I";
			break;
		case 5:
			numeroEnRomano = "V";
			break;
		case 10:
			numeroEnRomano = "X";
			break;
		case 50:
			numeroEnRomano = "L";
			break;
		case 100:
			numeroEnRomano = "C";
			break;
		case 500:
			numeroEnRomano = "D";
			break;
		case 1000:
			numeroEnRomano = "M";
			break;
		}
		return numeroEnRomano;
	}

	/**
	 * Este metodo me permite obtener los digitos del numero ingresado
	 * @param digitos: Vector en el que se almacenarán los digitos del numero que se va a convertir
	 * @param _numero: numero que se va a convertir
	 * @param cantidadDigitos: Tamaño del numero que se va a convertir (cantidad de digitos que tiene el numero)
	 */
	public void obtenerDigitos(int digitos[], int _numero, int cantidadDigitos) {
		int numero=_numero;
		for (int i = 0; i < cantidadDigitos; i++) {
			digitos[i] = numero % 10;
			numero = numero / 10;
		}
	}

}
