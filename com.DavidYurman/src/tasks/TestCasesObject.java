package tasks;

import java.util.ArrayList;
import java.util.List;


public class TestCasesObject {

	String testCaseId;

	String testCaseName;
	
	String testCaseDesc;

	String testCaseCount;

	String testCaseModule;
	
	ArrayList<String> inputDataFiles = new ArrayList<String>();
	
	String testScenarioId;

	public TestCasesObject() {

	}

	/**
	 * @param testCaseId
	 * @param testCaseName
	 * @param testCaseCount
	 * @param testCaseModule
	 */
	public TestCasesObject(String testCaseId, String testCaseName,
			String testCaseCount, String testCaseModule) {
		this.testCaseId = testCaseId;
		this.testCaseName = testCaseName;
		this.testCaseCount = testCaseCount;
		this.testCaseModule = testCaseModule;
	}

	/**
	 * @param testCaseId
	 * @param testScenarioId
	 * @param testCaseName
	 * @param testCaseCount
	 * @param testCaseModule
	 * @param inputDataFiles
	 */
	public TestCasesObject(String testCaseId, String testScenarioId, String testCaseDesc, String testCaseName,
			String testCaseCount, String testCaseModule) {
		this.testCaseId = testCaseId;
		this.testScenarioId = testScenarioId;
		this.testCaseDesc = testCaseDesc;
		this.testCaseName = testCaseName;
		this.testCaseCount = testCaseCount;
		this.testCaseModule = testCaseModule;
		//this.inputDataFiles.addAll(inputDataFiles);
	}

	/**
	 * @param testCaseId
	 * @param testCaseName
	 * @param testCaseCount
	 * @param testCaseModule
	 * @param inputDataFiles
	 */
	public TestCasesObject(String testCaseId, String testCaseDesc, String testCaseName,
			String testCaseCount, String testCaseModule) {
		this.testCaseId = testCaseId;
		this.testCaseDesc = testCaseDesc;
		this.testCaseName = testCaseName;
		this.testCaseCount = testCaseCount;
		this.testCaseModule = testCaseModule;
		//this.inputDataFiles.addAll(inputDataFiles);
	}

	/**
	 * @return the testCaseId
	 */
	public String getTestCaseId() {
		return testCaseId;
	}

	/**
	 * @param testCaseId
	 *            the testCaseId to set
	 */
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	/**
	 * @return the testCaseName
	 */
	public String getTestCaseName() {
		return testCaseName;
	}

	/**
	 * @param testCaseName
	 *            the testCaseName to set
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	/**
	 * @return the testCaseCount
	 */
	public String getTestCaseCount() {
		return testCaseCount;
	}

	/**
	 * @param testCaseCount
	 *            the testCaseCount to set
	 */
	public void setTestCaseCount(String testCaseCount) {
		this.testCaseCount = testCaseCount;
	}

	/**
	 * @return the testCaseModule
	 */
	public String getTestCaseModule() {
		return testCaseModule;
	}

	/**
	 * @param testCaseModule
	 *            the testCaseModule to set
	 */
	public void setTestCaseModule(String testCaseModule) {
		this.testCaseModule = testCaseModule;
	}

	public List<String> getInputDataFiles() {
		return inputDataFiles;
	}

	public void setInputDataFiles(ArrayList<String> inputDataFiles) {
		this.inputDataFiles = inputDataFiles;
	}

	public String getTestCaseDesc() {
		return testCaseDesc;
	}

	public void setTestCaseDesc(String testCaseDesc) {
		this.testCaseDesc = testCaseDesc;
	}
	
	public String getTestScenarioId() {
		return testScenarioId;
	}

	public void setTestScenarioId(String testScenarioId) {
		this.testScenarioId = testScenarioId;
	}
}
