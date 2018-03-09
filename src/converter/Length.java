package converter;

public enum Length {
	Mile(1609.344), Kilometer(1000.0), Meter(1.0), Centimeter(0.0100), Foot(0.30480), WA(2.00000), AU(149597870700L);
	// attributes of the enum members
	private final double value;

	// constructor must be private
	private Length(double value) {
		this.value = value;
	}

	// methods just like in a class
	public double getValue() {
		return this.value;
	}

}
