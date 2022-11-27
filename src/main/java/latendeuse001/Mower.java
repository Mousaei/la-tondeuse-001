/**
 * 
 */
package latendeuse001;

/**
 * @author vahidmousaei
 *
 */
public class Mower {
	
	private int coord_x;
	private int coord_y;
	private char orientation;
	
	
	/**
	 * 
	 */
	public Mower() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the coord_x
	 */
	public int getCoord_x() {
		return coord_x;
	}

	/**
	 * @param coord_x the coord_x to set
	 */
	public void setCoord_x(int coord_x) {
		this.coord_x = coord_x;
	}


	/**
	 * @return the coord_y
	 */
	public int getCoord_y() {
		return coord_y;
	}


	/**
	 * @param coord_y the coord_y to set
	 */
	public void setCoord_y(int coord_y) {
		this.coord_y = coord_y;
	}


	/**
	 * @return the orientation
	 */
	public char getOrientation() {
		return orientation;
	}


	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coord_x;
		result = prime * result + coord_y;
		result = prime * result + orientation;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Mower)) {
			return false;
		}
		Mower other = (Mower) obj;
		if (coord_x != other.coord_x) {
			return false;
		}
		if (coord_y != other.coord_y) {
			return false;
		}
		if (orientation != other.orientation) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Mower [coord_x=" + coord_x + ", coord_y=" + coord_y + ", orientation=" + orientation + "]";
	}
	
}