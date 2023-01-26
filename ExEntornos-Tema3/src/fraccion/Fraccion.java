package fraccion;
/**
 * Clase que define una fracción
 * @author Jaime Sevilla Alvarez
 *
 */
// Clase que define una fracción
public class Fraccion {
	// Numerador
	/**
	 * Numerador
	 */
	private int num;

	// Denominador
	/**
	 * Denominador
	 */
	private int den;

	// Constructor por defecto
	/**
	 * Constructor por defecto
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * Constructor con parámetros
	 * @param num Numerador
	 * @param den Denominador
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	/**
	 * Constructor copia
	 * @param f Fracción
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
	/**
	 *  Setter del parametro "num"
	 * @param num Numerador
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Getter del parametro "num"
	 * @return Devuelve el valor del parametro "num"
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Setter del parámetro "den"
	 * @param den Denominador
	 */
	public void setDen(int den) {
		this.den = den;
	}
	
	/**
	 * Getter del parámetro "den"
	 * @return Devuelve el valor del parámetro "den"
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return Devuelve el parámetro "u"
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * método para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString
	/**
	 * Método toString
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	/**
	 * Suma de fracciones
	 * @param f Fracción
	 * @return Devuelve un parametro auxiliar tras sumar las fracciones
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
	/**
	 * Restar fracciones
	 * @param f Fracción
	 * @return Devuelve un parametro auxiliar tras restar las fracciones
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
	/**
	 * Multiplicar fracciones
	 * @param f Fracción
	 * @return Devuelve un parametro auxiliar tras multiplicar las fracciones
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
	/**
	 * Dividir fracciones
	 * @param f Fracción
	 * @return Devuelve un parametro auxiliar tras dividir las fracciones
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
