package json.Components;

import java.util.Date;
import java.util.List;

/**
 * Created by lin on 2016/11/15.
 */
public class Data {
    int roomId,cateId,roomStatus,online,fansNum;

    String roomThumb,cateName,roomName,ownerName, avatar,ownerWeight,startTime;

    List<Gift> gift;



    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public String getRoomThumb() {
        return roomThumb;
    }

    public void setRoomThumb(String roomThumb) {
        this.roomThumb = roomThumb;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOwnerWeight() {
        return ownerWeight;
    }

    public void setOwnerWeight(String ownerWeight) {
        this.ownerWeight = ownerWeight;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Gift> getGift() {
        return gift;
    }

    public void setGift(List<Gift> gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "Data{" +
                "roomId=" + roomId +
                ", cateId=" + cateId +
                ", roomStatus=" + roomStatus +
                ", online=" + online +
                ", fansNum=" + fansNum +
                ", roomThumb='" + roomThumb + '\'' +
                ", cateName='" + cateName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", ownerWeight='" + ownerWeight + '\'' +
                ", startTime='" + startTime + '\'' +
                ", gift=" + gift +
                '}';
    }
}
