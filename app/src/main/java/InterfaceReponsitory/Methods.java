package InterfaceReponsitory;

import Model.AccountInsertModel;

import Model.CallbackResultModel;
import Model.CangModel;
import Model.ChuyenBayModel;
import Model.CustomerInsertModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Methods {
    @GET("ords/datve/cang")
    Call<CangModel> GetCangs() ;

    @GET("ords/datve/cbmanage/searchcb")
    Call<ChuyenBayModel> GetChuyenBay(@Query("TENCANGDI") String TENCANGDI, @Query("TENCANGDEN") String TENCANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/khachhang")
    Call<TaiKhoanModel> GetTaiKhoan();

//    @POST("ords/datve/custmanage/add-account")
//    Call<CallbackResultModel> InsertAccount(@Body AccountInsertModel accountInsertModel);

    @POST("ords/datve/custmanage/insertcust")
    Call<CallbackResultModel> InsertAccount(@Body AccountInsertModel accountInsertModel);
}
