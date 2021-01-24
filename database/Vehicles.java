package database;

public class Vehicles {
	
	private String type;
	private String manufacturer;
	private String plateNumber;
	private String color;
	private Integer numOfSail;
	private Integer seats;
	private Integer vintage;
	private boolean underRepair;
	private String cause;
	
	public Vehicles() {}
	
	public Vehicles(String type, String manufacturer) {
		this.type = type;
		this.manufacturer = manufacturer;
	}
	
	public Vehicles(String type, String manufacturer, String plateNumber, String color, Integer numOfSail, Integer seats, Integer vintage, boolean underRepair) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.plateNumber = plateNumber;
		this.color = color;
		this.numOfSail = numOfSail;
		this.seats = seats;
		this.vintage = vintage;
		this.underRepair = underRepair;
	}
	
	public Vehicles(String type, String manufacturer, String plateNumber, String color, Integer seats, Integer vintage, boolean underRepair, String cause) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.plateNumber = plateNumber;
		this.color = color;
		this.seats = seats;
		this.vintage = vintage;
		this.underRepair = underRepair;
		this.cause = cause;
	}
	
	public Vehicles(String type, String manufacturer, String plateNumber, String color, Integer numOfSail, Integer seats, Integer vintage, boolean underRepair, String cause) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.plateNumber = plateNumber;
		this.color = color;
		this.numOfSail = numOfSail;
		this.seats = seats;
		this.vintage = vintage;
		this.underRepair = underRepair;
		this.cause = cause;
	}
	
	public Vehicles(String cause) {
		this.cause = cause;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getNumOfSail() {
		return numOfSail;
	}

	public void setNumOfSail(Integer numOfSail) {
		this.numOfSail = numOfSail;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getVintage() {
		return vintage;
	}

	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}

	public boolean isUnderRepair() {
		return underRepair;
	}
	
	public String isUnderRepairTranslate() {
		if (isUnderRepair()) {
			return "igen";
		}
		return "nem";
	}

	public void setUnderRepair(boolean underRepair) {
		this.underRepair = underRepair;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		return "Vehicles [type=" + type + ", manufacturer=" + manufacturer + ", plateNumber=" + plateNumber + ", color="
				+ color + ", numOfSail=" + numOfSail + ", seats=" + seats + ", vintage=" + vintage + ", underRepair="
				+ isUnderRepairTranslate() + ", cause=" + cause + "]";
	}
}