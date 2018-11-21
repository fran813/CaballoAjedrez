package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	
	private Color color;
	private Posicion posicion;
	
	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion (8, 'b');
	}
	
	public Caballo(Color color) {
		this.color = color;
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}
		else {
			posicion = new Posicion(8, 'b');
		}
	}

	public Caballo(Color color, char Columna) {
		this.color = color;
		if (Columna == 'b' || Columna == 'g') {
			if (this.color == Color.BLANCO) {
				posicion = new Posicion(1, Columna);
			} else {
				posicion = new Posicion(8, Columna);
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
	}
	
	public Color getColor() {
		return color;
	}
	private void setColor(Color color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caballo [posición=" + posicion + ", color=" + color + "]";
	}
	
	
	

}
