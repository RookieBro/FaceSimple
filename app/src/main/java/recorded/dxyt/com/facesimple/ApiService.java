package recorded.dxyt.com.facesimple;
import recorded.dxyt.com.facesimple.bean.TestContacts;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("/sgcc/communication/queryPeersInfoByOrgaCode.do")
    Call<TestContacts> getContacts(
            @Field("superCode") String superCode
    );

}
