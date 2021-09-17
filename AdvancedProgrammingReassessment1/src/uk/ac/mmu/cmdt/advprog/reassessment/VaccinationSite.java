package uk.ac.mmu.cmdt.advprog.reassessment;
/**
 * Represents a single vaccination site, allowing the application to store data in a friendly format
 * 
 * You do not need to modify this class, and should not do so.
 * 
 * @author K. Welsh
 */
public final class VaccinationSite {
	
	/**
	 * Default constructor - does nothing
	 */
	public VaccinationSite() {
		
	}

	/**
	 * Returns the ID of this vaccination site
	 * @return the ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of this vaccination site
	 * @param id the ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of this vaccination site
	 * @return the name
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * Sets the name of this vaccination site
	 * @param siteName the name to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * Returns the first line of this vaccination site's address
	 * @return the first line of the address
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Sets the first line of this vaccination site's address
	 * @param addressLine1 the first line of the address to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Returns the second line of this vaccination site's address
	 * @return the second line of the address
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Sets the second line of this vaccination site's address
	 * @param addressLine1 the second line of the address to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Returns the third line of this vaccination site's address
	 * @return the third line of the address
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * Sets the third line of this vaccination site's address
	 * @param addressLine1 the third line of the address to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * Returns the name of the city in which this vaccination site is located
	 * @return the city name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the name of the city in which this vaccination site is located
	 * @param city the city name to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the postcode of this vaccination site
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * Sets the postcode of this vaccination site
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Returns the NHS region in which this vaccination site is located
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the NHS region in which this vaccination site is located
	 * @param region the region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Returns the estimated latitude of this vaccination site
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the estimated latitude of this vaccination site
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Returns the estimated longitude of this vaccination site
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the estimated longitude of this vaccination site
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Returns the type of this vaccination site
	 * @return the type, using the Type enum
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type of this vaccination site
	 * @param type one of the values from the Type enum
	 */
	public void setType(Type type) {
		this.type = type;
	}

	private int id;
	private String siteName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String postcode;
	private String region;
	private double latitude;
	private double longitude;
	private Type type;
	
	/**
	 * Represents the different types of vaccination site available
	 */
	enum Type {
		VACCINATION_CENTRE, PHARMACY, GP_SURGERY
	}
}
