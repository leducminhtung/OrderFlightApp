package InterfaceReponsitory;

import Model.AccountInsertModel;

import Model.CallbackResultModel;
import Model.CangModel;
import Model.ChuyenBayModel;
import Model.CustomerUpdateModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Methods {
    @GET("ords/datve/cang")
    Call<CangModel> GetCangs() ;

    @GET("ords/datve/cbmanage/searchcbth")
    Call<ChuyenBayModel> GetChuyenBayTH(@Query("TENCANGDI") String TENCANGDI, @Query("TENCANGDEN") String TENCANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/cbmanage/searchcbtg")
    Call<ChuyenBayModel> GetChuyenBayTG(@Query("TENCANGDI") String TENCANGDI, @Query("TENCANGDEN") String TENCANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/khachhang")
    Call<TaiKhoanModel> GetTaiKhoan();

    @PUT("ords/datve/custmanage/update-account")
    Call<CallbackResultModel> UpdateCust(@Body CustomerUpdateModel customerUpdateModel);

    @POST("ords/datve/custmanage/insertcust")
    Call<CallbackResultModel> InsertAccount(@Body AccountInsertModel accountInsertModel);
}
