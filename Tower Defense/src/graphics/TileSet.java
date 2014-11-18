package graphics;

import java.awt.Image;
import java.io.Serializable;
import java.util.Arrays;

public class TileSet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Image[] tileset;
	private int length;
	
	public TileSet(int length) {
		tileset = new Image[length];
		this.length = length;
	}

	public Image[] getTileset() {
		return tileset;
	}
	
	public void setImage(Image i, int index) {
		tileset[index] = i;
	}
	
	public Image getImage(int index) {
		return tileset[index];
	}

	public int getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + Arrays.hashCode(tileset);
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
		TileSet other = (TileSet) obj;
		if (length != other.length)
			return false;
		if (!Arrays.equals(tileset, other.tileset))
			return false;
		return true;
	}
	
	
	
}
