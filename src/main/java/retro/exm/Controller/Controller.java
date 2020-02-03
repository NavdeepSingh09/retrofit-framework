package retro.exm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Controller implements Callback<Group_Multigroup> {

    static final String BASE_URL = "";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MultigroupAPI MultigroupAPI = retrofit.create(MultigroupAPI.class);

        Call<Group_Multigroup> call = MultigroupAPI.getMultigroups();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Group_Multigroup> call, Response<Group_Multigroup> response) {
        if(response.isSuccessful()) {
            Group_Multigroup changesList = response.body();
            int Group_Size=changesList.getGroups().size();
            int Multigroup_Size=changesList.getMultigroups().size();
            for(int i=0;i<Group_Size;i++){
                System.out.println(changesList.getGroups().get(i).getName());
            }
            for(int i=0;i<Multigroup_Size;i++){
                System.out.println(changesList.getMultigroups().get(i).getName());
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Group_Multigroup> call, Throwable t) {
        t.printStackTrace();
    }
}
