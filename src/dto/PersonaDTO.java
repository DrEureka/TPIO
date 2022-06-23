package dto;

import java.util.Date;

public class PersonaDTO {
	private String dni;
	private String apellido;
	private String nombre;
	private boolean sindicalizado;
	private String fchNacimiento;
	private Double sueldo;
	
	public PersonaDTO(String dni, String apellido, String nombre, boolean sindicalizado, String fchNacimiento, Double sueldo)
	{
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.sindicalizado = sindicalizado;
		this.fchNacimiento = fchNacimiento;
		this.sueldo = sueldo;
		
	}
	
	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFchNacimiento() {
		return fchNacimiento;
	}
	public void setFchNacimiento(String fchNacimiento) {
		this.fchNacimiento = fchNacimiento;
	}
	public boolean isSindicalizado() {
		return sindicalizado;
	}
	public void setSindicalizado(boolean sindicalizado) {
		this.sindicalizado = sindicalizado;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	
	

}
