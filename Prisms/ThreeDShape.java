public class ThreeDShape 
{
	private double volume;
	private double surfaceArea;

	public ThreeDShape()
	{
		this.setVolume(calcVolume());
		this.setSurfaceArea(calcSA());
	}

// Can you write this code for this class or does it need to be overridden by every subclass?
	public double calcVolume()
	{
		return 0;
	}

// Can you write this code for this class or does it need to be overridden by every subclass?
	public double calcSA()
	{
		return 0;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}	
}
