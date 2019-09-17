package recorded.dxyt.com.facesimple.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressLint("ParcelCreator")
public class TestContacts {
    @Override
    public String toString() {
        return "TestContacts{" +
                "personInfoList=" + personInfoList +
                ", organizationList=" + organizationList +
                '}';
    }

    /**
     * code : 0
     * data : {"personInfoList":[{"vidyoMemberId":"15642","vidyoName":"110106196806102716","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19646","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"110106196806102716","vidyoUserId":"19646","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"魏宝军","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19867","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"QRTcOaSZbd","userType":0,"vidyoPassword":"102716","status":"2","gzbUserId":"default","username":"魏宝军"},{"vidyoMemberId":"15669","vidyoName":"110223197010031437","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19673","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"110223197010031437","vidyoUserId":"19673","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"刘万霜","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19894","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"oxctnWdi41","userType":0,"vidyoPassword":"031437","status":"2","gzbUserId":"default","username":"刘万霜"},{"vidyoMemberId":"15641","vidyoName":"11010719630716031X","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19645","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"11010719630716031X","vidyoUserId":"19645","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"王玉林","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19866","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"sTzxbn4CbO","userType":0,"vidyoPassword":"16031X","status":"2","gzbUserId":"default","username":"王玉林"},{"vidyoMemberId":"15667","vidyoName":"110102197303162353","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19671","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"110102197303162353","vidyoUserId":"19671","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"王骏","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19892","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"PT5cinssdz","userType":0,"vidyoPassword":"162353","status":"2","gzbUserId":"default","username":"王骏"},{"vidyoMemberId":"15668","vidyoName":"11022519640125381X","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19672","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"11022519640125381X","vidyoUserId":"19672","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"杨进则","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19893","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"KbLyl0Pc6I","userType":0,"vidyoPassword":"25381X","status":"2","gzbUserId":"default","username":"杨进则"},{"vidyoMemberId":"15666","vidyoName":"110105196311052511","dispatch":0,"city":"北京","jobTitle":"default","latitude":"default","telephonesIsShow":0,"roomId":"19670","gzbPassword":"default","wepttName":"default","major":"default","province":"北京","onlineLatitude":"","orgCode":"110000050000","loginName":"110105196311052511","vidyoUserId":"19670","company":"default","department":"警务督察总队","email":"default","longitude":"default","gzbName":"default","phoneIsShow":0,"phoneExt":"default","address":"default","userNameIsShow":0,"superFlag":1,"nickName":"王玉馨","wepttPassword":"default","sex":"21","telephoneS":"default","superCode":"110000000000","wepttUserId":"default","addressIsShow":0,"picture":"default","onlineLongitude":"","accountId":"19891","telephoneZ":"default","areaFlag":1,"telephonezIsShow":0,"phone":"default","grade":"0","duty":"default","roomKey":"5QXx2NYANS","userType":0,"vidyoPassword":"052511","status":"2","gzbUserId":"default","username":"王玉馨"}],"organizationList":[{"orgaCode":"110000050200","superCode":"110000050000","orgaName":"综合办公室","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000050400","superCode":"110000050000","orgaName":"案件核查督办大队","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000050600","superCode":"110000050000","orgaName":"执法现场督察大队","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000050800","superCode":"110000050000","orgaName":"勤务现场督察大队","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000051000","superCode":"110000050000","orgaName":"维护民警执法权益大队","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000051200","superCode":"110000050000","orgaName":"信息化督察中心","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null},{"orgaCode":"110000051400","superCode":"110000050000","orgaName":"警务工作暗访大队","mapPosition":null,"buttonCode":null,"whetherSuper":0,"areaFlag":null,"childFlag":null,"createDate":null,"companyPhone":null,"childList":null}]}
     * message : 查询成功
     */

    private List<PersonInfoListBean> personInfoList;
    private List<OrganizationListBean> organizationList;

    public List<PersonInfoListBean> getPersonInfoList() {
        return personInfoList;
    }

    public void setPersonInfoList(List<PersonInfoListBean> personInfoList) {
        this.personInfoList = personInfoList;
    }

    public List<OrganizationListBean> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<OrganizationListBean> organizationList) {
        this.organizationList = organizationList;
    }



    public static class PersonInfoListBean implements Parcelable {
        /**
         * vidyoMemberId : 12678
         * vidyoName : 232126198705030016
         * dispatch : 0
         * city : 北京
         * jobTitle : default
         * latitude : default
         * telephonesIsShow : 0
         * roomId : 16682
         * gzbPassword : default
         * wepttName : default
         * major : default
         * province : 北京
         * onlineLatitude :
         * orgCode : 110000000000
         * loginName : 232126198705030016
         * vidyoUserId : 16682
         * company : default
         * department : 北京市公安局
         * email : default
         * longitude : default
         * gzbName : default
         * phoneIsShow : 0
         * phoneExt : default
         * address : default
         * userNameIsShow : 0
         * superFlag : 1
         * nickName : 刘彦伟
         * wepttPassword : default
         * sex : 21
         * telephoneS : default
         * superCode : 0
         * wepttUserId : default
         * addressIsShow : 0
         * picture : default
         * onlineLongitude :
         * accountId : 16891
         * telephoneZ : default
         * areaFlag : 1
         * telephonezIsShow : 0
         * phone : default
         * grade : 0
         * duty : default
         * roomKey : 7h8Ni9stTE
         * userType : 0
         * vidyoPassword : 030016
         * status : 2
         * gzbUserId : default
         * username : 刘彦伟
         * rankCode : 11
         * position : 董事长
         */

        private String vidyoMemberId;
        private String vidyoName;
        private int dispatch;
        private String city;
        private String jobTitle;
        private String latitude;
        private int telephonesIsShow;
        private String roomId;
        private String gzbPassword;
        private String wepttName;
        private String major;
        private String province;
        private String onlineLatitude;
        private String orgCode;
        private String loginName;
        private String vidyoUserId;
        private String company;
        private String department;
        private String email;
        private String longitude;
        private String gzbName;
        private int phoneIsShow;
        private String phoneExt;
        private String address;
        private int userNameIsShow;
        private int superFlag;
        private String nickName;
        private String wepttPassword;
        private String sex;
        private String telephoneS;
        private String superCode;
        private String wepttUserId;
        private int addressIsShow;
        private String picture;
        private String onlineLongitude;
        private String accountId;
        private String telephoneZ;
        private int areaFlag;
        private int telephonezIsShow;
        private String phone;
        private String grade;
        private String duty;
        private String roomKey;
        private int userType;
        private String vidyoPassword;
        private String status;
        private String gzbUserId;
        private String username;
        private int rankCode;
        private String position;

        public PersonInfoListBean() {
            this.vidyoMemberId = vidyoMemberId;
            this.vidyoName = vidyoName;
            this.dispatch = dispatch;
            this.city = city;
            this.jobTitle = jobTitle;
            this.latitude = latitude;
            this.telephonesIsShow = telephonesIsShow;
            this.roomId = roomId;
            this.gzbPassword = gzbPassword;
            this.wepttName = wepttName;
            this.major = major;
            this.province = province;
            this.onlineLatitude = onlineLatitude;
            this.orgCode = orgCode;
            this.loginName = loginName;
            this.vidyoUserId = vidyoUserId;
            this.company = company;
            this.department = department;
            this.email = email;
            this.longitude = longitude;
            this.gzbName = gzbName;
            this.phoneIsShow = phoneIsShow;
            this.phoneExt = phoneExt;
            this.address = address;
            this.userNameIsShow = userNameIsShow;
            this.superFlag = superFlag;
            this.nickName = nickName;
            this.wepttPassword = wepttPassword;
            this.sex = sex;
            this.telephoneS = telephoneS;
            this.superCode = superCode;
            this.wepttUserId = wepttUserId;
            this.addressIsShow = addressIsShow;
            this.picture = picture;
            this.onlineLongitude = onlineLongitude;
            this.accountId = accountId;
            this.telephoneZ = telephoneZ;
            this.areaFlag = areaFlag;
            this.telephonezIsShow = telephonezIsShow;
            this.phone = phone;
            this.grade = grade;
            this.duty = duty;
            this.roomKey = roomKey;
            this.userType = userType;
            this.vidyoPassword = vidyoPassword;
            this.status = status;
            this.gzbUserId = gzbUserId;
            this.username = username;
            this.rankCode = rankCode;
            this.position = position;
        }

        public String getVidyoMemberId() {
            return vidyoMemberId;
        }

        public void setVidyoMemberId(String vidyoMemberId) {
            this.vidyoMemberId = vidyoMemberId;
        }

        public String getVidyoName() {
            return vidyoName;
        }

        public void setVidyoName(String vidyoName) {
            this.vidyoName = vidyoName;
        }

        public int getDispatch() {
            return dispatch;
        }

        public void setDispatch(int dispatch) {
            this.dispatch = dispatch;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public int getTelephonesIsShow() {
            return telephonesIsShow;
        }

        public void setTelephonesIsShow(int telephonesIsShow) {
            this.telephonesIsShow = telephonesIsShow;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getGzbPassword() {
            return gzbPassword;
        }

        public void setGzbPassword(String gzbPassword) {
            this.gzbPassword = gzbPassword;
        }

        public String getWepttName() {
            return wepttName;
        }

        public void setWepttName(String wepttName) {
            this.wepttName = wepttName;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getOnlineLatitude() {
            return onlineLatitude;
        }

        public void setOnlineLatitude(String onlineLatitude) {
            this.onlineLatitude = onlineLatitude;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getVidyoUserId() {
            return vidyoUserId;
        }

        public void setVidyoUserId(String vidyoUserId) {
            this.vidyoUserId = vidyoUserId;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getGzbName() {
            return gzbName;
        }

        public void setGzbName(String gzbName) {
            this.gzbName = gzbName;
        }

        public int getPhoneIsShow() {
            return phoneIsShow;
        }

        public void setPhoneIsShow(int phoneIsShow) {
            this.phoneIsShow = phoneIsShow;
        }

        public String getPhoneExt() {
            return phoneExt;
        }

        public void setPhoneExt(String phoneExt) {
            this.phoneExt = phoneExt;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUserNameIsShow() {
            return userNameIsShow;
        }

        public void setUserNameIsShow(int userNameIsShow) {
            this.userNameIsShow = userNameIsShow;
        }

        public int getSuperFlag() {
            return superFlag;
        }

        public void setSuperFlag(int superFlag) {
            this.superFlag = superFlag;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getWepttPassword() {
            return wepttPassword;
        }

        public void setWepttPassword(String wepttPassword) {
            this.wepttPassword = wepttPassword;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTelephoneS() {
            return telephoneS;
        }

        public void setTelephoneS(String telephoneS) {
            this.telephoneS = telephoneS;
        }

        public String getSuperCode() {
            return superCode;
        }

        public void setSuperCode(String superCode) {
            this.superCode = superCode;
        }

        public String getWepttUserId() {
            return wepttUserId;
        }

        public void setWepttUserId(String wepttUserId) {
            this.wepttUserId = wepttUserId;
        }

        public int getAddressIsShow() {
            return addressIsShow;
        }

        public void setAddressIsShow(int addressIsShow) {
            this.addressIsShow = addressIsShow;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getOnlineLongitude() {
            return onlineLongitude;
        }

        public void setOnlineLongitude(String onlineLongitude) {
            this.onlineLongitude = onlineLongitude;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getTelephoneZ() {
            return telephoneZ;
        }

        public void setTelephoneZ(String telephoneZ) {
            this.telephoneZ = telephoneZ;
        }

        public int getAreaFlag() {
            return areaFlag;
        }

        public void setAreaFlag(int areaFlag) {
            this.areaFlag = areaFlag;
        }

        public int getTelephonezIsShow() {
            return telephonezIsShow;
        }

        public void setTelephonezIsShow(int telephonezIsShow) {
            this.telephonezIsShow = telephonezIsShow;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getDuty() {
            return duty;
        }

        public void setDuty(String duty) {
            this.duty = duty;
        }

        public String getRoomKey() {
            return roomKey;
        }

        public void setRoomKey(String roomKey) {
            this.roomKey = roomKey;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getVidyoPassword() {
            return vidyoPassword;
        }

        public void setVidyoPassword(String vidyoPassword) {
            this.vidyoPassword = vidyoPassword;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getGzbUserId() {
            return gzbUserId;
        }

        public void setGzbUserId(String gzbUserId) {
            this.gzbUserId = gzbUserId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getRankCode() {
            return rankCode;
        }

        public void setRankCode(int rankCode) {
            this.rankCode = rankCode;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }


    }

    public static class OrganizationListBean {
        /**
         * orgaCode : 000000000000
         * superCode : 110000000000
         * orgaName : 测试部
         * mapPosition : null
         * buttonCode : null
         * whetherSuper : 1
         * areaFlag : null
         * childFlag : null
         * createDate : null
         * companyPhone : null
         * childList : null
         */

        private String orgaCode;
        private String superCode;
        private String orgaName;
        private Object mapPosition;
        private Object buttonCode;
        private int whetherSuper;
        private Object areaFlag;
        private Object childFlag;
        private Object createDate;
        private Object companyPhone;
        private Object childList;

        public String getOrgaCode() {
            return orgaCode;
        }

        public void setOrgaCode(String orgaCode) {
            this.orgaCode = orgaCode;
        }

        public String getSuperCode() {
            return superCode;
        }

        public void setSuperCode(String superCode) {
            this.superCode = superCode;
        }

        public String getOrgaName() {
            return orgaName;
        }

        public void setOrgaName(String orgaName) {
            this.orgaName = orgaName;
        }

        public Object getMapPosition() {
            return mapPosition;
        }

        public void setMapPosition(Object mapPosition) {
            this.mapPosition = mapPosition;
        }

        public Object getButtonCode() {
            return buttonCode;
        }

        public void setButtonCode(Object buttonCode) {
            this.buttonCode = buttonCode;
        }

        public int getWhetherSuper() {
            return whetherSuper;
        }

        public void setWhetherSuper(int whetherSuper) {
            this.whetherSuper = whetherSuper;
        }

        public Object getAreaFlag() {
            return areaFlag;
        }

        public void setAreaFlag(Object areaFlag) {
            this.areaFlag = areaFlag;
        }

        public Object getChildFlag() {
            return childFlag;
        }

        public void setChildFlag(Object childFlag) {
            this.childFlag = childFlag;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public Object getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(Object companyPhone) {
            this.companyPhone = companyPhone;
        }

        public Object getChildList() {
            return childList;
        }

        public void setChildList(Object childList) {
            this.childList = childList;
        }
    }


}
