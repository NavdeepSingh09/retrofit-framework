package retro.exm;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MultigroupAPI {
    @GET("location/multigroup")
    Call <Group_Multigroup> getMultigroups();
}