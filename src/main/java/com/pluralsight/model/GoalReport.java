package com.pluralsight.model;

public class GoalReport {
	
	private int goal_minutes;
	private int exercise_minutes;
	private String exercise_activity;
	
	//Projection - needs a Constructor to be available for the Joins on the JPQL
	public GoalReport(int goal_minutes, int exercise_minutes, String exercise_activity) { 
		this.goal_minutes=goal_minutes;
		this.exercise_minutes=exercise_minutes;
		this.exercise_activity = exercise_activity;
	}
	
	public String getExercise_activity() {
		return exercise_activity;
	}
	public int getExercise_minutes() {
		return exercise_minutes;
	}
	public int getGoal_minutes() {
		return goal_minutes;
	}
	public void setExercise_activity(String exercise_activity) {
		this.exercise_activity = exercise_activity;
	}
	public void setExercise_minutes(int exercise_minutes) {
		this.exercise_minutes = exercise_minutes;
	}
	public void setGoal_minutes(int goal_minutes) {
		this.goal_minutes = goal_minutes;
	}
	

}
