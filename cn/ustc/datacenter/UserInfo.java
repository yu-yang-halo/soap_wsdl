package cn.ustc.datacenter;

public class UserInfo {
	
	public String gid;
	public String name;
	public String yktserial;//一卡通的物理卡号，１０进制YKTSERIAL
	public String rfid;//一卡通的RFID号码
	public String photo;
	public String usercode;//工资号或学号
	
	public UserInfo(){
		
	}
	
	@Override
	public String toString() {
		return "UserInfo---- \n [gid=" + gid + ", name=" + name + ", yktserial="
				+ yktserial + ", rfid=" + rfid + ", photo=" + photo
				+ ", usercode=" + usercode + "]\n";
	}

	public UserInfo(String gid, String name, String yktserial, String rfid,
			String photo, String usercode) {
		super();
		this.gid = gid;
		this.name = name;
		this.yktserial = yktserial;
		this.rfid = rfid;
		this.photo = photo;
		this.usercode = usercode;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYktserial() {
		return yktserial;
	}
	public void setYktseria(String yktserial) {
		this.yktserial = yktserial;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	
	
	
}
