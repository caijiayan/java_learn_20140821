package cn.gyyx.java.Model;

import java.io.Serializable;

public class GameInfo implements Serializable {

	private int id;
	private String gameName;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
