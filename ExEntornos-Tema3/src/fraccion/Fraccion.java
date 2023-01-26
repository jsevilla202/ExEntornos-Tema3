package fraccion;

// Clase que define una fracción
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0){
			this.den = 1;
		}
		else{
			this.den = den;
		}
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	public Fraccion(final Fraccion fraccion) {
		num = fraccion.num;
		den = fraccion.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int mcd() {
		int absoluton = Math.abs(num); // valor absoluto del numerador
		int absolutod = Math.abs(den); // valor absoluto del denominador
		int aux = 0; //auxiliar añadido en rama PMD
		if (absolutod == 0) {
			aux = absoluton;
		}
		int resultado;
		while (absolutod != 0) {
			resultado = absoluton % absolutod;
			absoluton = absolutod;
			aux = absoluton;
			absolutod = resultado;
		}
		return aux;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int numero = mcd();
		num = num / numero;
		den = den / numero;
	}

	// Método toString

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den + den * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den - den * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den;
		aux.den = den * fraccion.num;
		aux.simplificar();
		return aux;

	}

}
