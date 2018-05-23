package tasks;

public class ObjectProperty {
	String objectId = null;
	String id = null;
	String idValue = null;
	String name = null;
	String nameValue = null;
	String xpath = null;
	String xpathValue = null;
	String css = null;
	String cssValue = null;

	public ObjectProperty() {

	}

	public ObjectProperty(String objectId ,String id,String idValue, String name,
			String nameValue, String xpath, String xpathValue) {
		//id<value>,name<value>,xpath<value>
		this.objectId = objectId;
		this.id = id;
		this.idValue = idValue;
		this.name = name;
		this.nameValue = nameValue;
		this.xpath = xpath;
		this.xpathValue = xpathValue;
//		System.out.println("inside object property" + xpathValue);
	}

	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * @param objectId
	 *            the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public String getidValue() {
		return idValue;
	}

	
	public void setIdValue(String idValue) {
		this.id = idValue;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameValue() {
		return nameValue;
	}

	public void setnameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	
	public String getXpathValue() {
		return xpathValue;
	}

	public void setXpathValue(String xpathValue) {
		this.xpathValue = xpathValue;
	}

}
