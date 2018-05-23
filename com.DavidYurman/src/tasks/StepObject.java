package tasks;

public class StepObject {
	String contentItem = null;
	String inputData = null;
	String objectId = null;

	public StepObject() {

	}

	public StepObject(String inputData, String objectId) {
		this.inputData = inputData;
		this.objectId = objectId;
	}

	/**
	 * @return the contentItem
	 */
	public String getContentItem() {
		return contentItem;
	}

	/**
	 * @param contentItem
	 *            the contentItem to set
	 */
	public void setContentItem(String contentItem) {
		this.contentItem = contentItem;
	}

	/**
	 * @return the inputData
	 */
	public String getInputData() {
		return inputData;
	}

	/**
	 * @param inputData
	 *            the inputData to set
	 */
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
}
