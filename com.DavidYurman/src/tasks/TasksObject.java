package tasks;

import java.util.HashMap;
import java.util.Map;

public class TasksObject {
	
	public String stepNumber;
	
	public String stepName;

	public Map<Integer, StepObject> steps = new HashMap<Integer,StepObject>();
	
	public String windowName;

	public TasksObject(){
		
	}
	

	public TasksObject(String stepNumber, String stepName,Map<Integer, StepObject> steps){
		setStepNumber(stepNumber);
		setStepName(stepName);
		this.steps.putAll(steps);
	}
	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * @return the steps
	 */
	public Map<Integer, StepObject> getSteps() {
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(Map<Integer, StepObject> steps) {
		this.steps = steps;
	}

	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}	

	public String getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(String stepNumber) {
		this.stepNumber = stepNumber;
	}
}