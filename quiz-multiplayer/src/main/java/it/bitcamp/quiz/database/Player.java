package it.bitcamp.quiz.database;

public class Player {
 private int id;
 private String name;
 private int totalScore;
 
public Player(int id, String name, int totalScore) {
	
	this.id = id;
	this.name = name;
	this.totalScore = totalScore;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getTotalScore() {
	return totalScore;
}

public void setTotalScore(int totalScore) {
	this.totalScore = totalScore;
}

@Override
public String toString() {
	return "Player [id=" + id + ", name=" + name + ", totalScore=" + totalScore + "]";
}
 

 
}
