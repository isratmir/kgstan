package mr.rad.kg.kyrgyzstan;


import mr.rad.kg.kyrgyzstan.object.Message;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HTTPService {
    public static final String ENDPOINT = "http://128.199.182.216";

    @FormUrlEncoded
    @POST("/mailer.php")
    Call<Message> send(@Field("name") String name, @Field("message") String message);
}
