package msepulvedas.com.codegen.codegen.model;

public class DatosCodigo {
	
	String dato1;
	
	String dato2;
	
	String dato3;
	
	String dato4;

	public DatosCodigo(String dato1, String dato2, String dato3, String dato4) {
		super();
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
		this.dato4 = dato4;
	}

	public String getDato1() {
		return dato1;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public String getDato2() {
		return dato2;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

	public String getDato3() {
		return dato3;
	}

	public void setDato3(String dato3) {
		this.dato3 = dato3;
	}

	public String getDato4() {
		return dato4;
	}

	public void setDato4(String dato4) {
		this.dato4 = dato4;
	}

	@Override
	public String toString() {
		return dato1 + " " + dato2 + " " + dato3 + " " + dato4;
	}
	
	
	
}
