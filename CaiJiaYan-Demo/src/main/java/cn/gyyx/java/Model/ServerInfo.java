package cn.gyyx.java.Model;

import java.io.Serializable;

public class ServerInfo implements Serializable {

	private int id;
	private int gameId;
	private String serverName;
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
}
