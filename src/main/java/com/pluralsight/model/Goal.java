package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="GOALS")

@NamedQueries({
	@NamedQuery(name = Goal.FIND_GOAL_REPORTS, query=Goal.NAMED_QUERY),
	@NamedQuery(name=Goal.FIND_ALL_GOAL, query=Goal.QUERY_ALL_GOALS)
	
})
public class Goal {

	
	public static final String FIND_GOAL_REPORTS = "findGoalReports";
	
	public static final String NAMED_QUERY = "Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"
				+ "from Goal g, Exercise e where g.goalId = e.goal.goalId";

	public static final String FIND_ALL_GOAL = "findAllGoal";
	
	public static final String QUERY_ALL_GOALS = "Select g from Goal g";

	
	@Id
	@GeneratedValue
	@Column(name="GOAL_ID")
	private Long goalId; 
	
	@Range(min = 1, max = 120)
	@Column(name="MINUTES")
	private int minutes;

	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	public Long getGoalId() {
		return goalId;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
