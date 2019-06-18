package cn.lut.hotelvip.domain.po;

public class Room {

	String roomid; 
	String roomSize; 
	String roomType;
	double roomPrice;
	String roomState;
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomSize=" + roomSize + ", roomType=" + roomType + ", roomPrice="
				+ roomPrice + ", roomState=" + roomState + "]";
	}
	

	
	
}
