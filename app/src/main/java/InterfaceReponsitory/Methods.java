package InterfaceReponsitory;

import Model.CangModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("ords/ordstest/cang")
    Call<CangModel> GetCangs();
}
