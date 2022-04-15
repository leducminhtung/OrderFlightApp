package InterfaceReponsitory;

import Model.AccountInsertModel;

import Model.CallbackResultModel;
import Model.CangModel;
import Model.ChuyenBayModel;
import Model.CustomerUpdateModel;
import Model.HistoryModel;
import Model.PhieuMuaVeInsertModel;
import Model.PhieuMuaVeModel;
import Model.TaiKhoanModel;
import Model.VeInsertModel;
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
    Call<ChuyenBayModel> GetChuyenBayTH(@Query("MACANGDI") String MACANGDI, @Query("MACANGDEN") String MACANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/cbmanage/searchcbtg")
    Call<ChuyenBayModel> GetChuyenBayTG(@Query("MACANGDI") String MACANGDI, @Query("MACANGDEN") String MACANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/khachhang")
    Call<TaiKhoanModel> GetTaiKhoan();

    @GET("ords/datve/phieumuave")
    Call<PhieuMuaVeModel> GetPhieuMuaVe();

    @GET("ords/datve/vemanage/history")
    Call<HistoryModel> GetHistory(@Query("CANCUOC") String CANCUOC);

    @PUT("ords/datve/custmanage/update-account")
    Call<CallbackResultModel> UpdateCust(@Body CustomerUpdateModel customerUpdateModel);

    @POST("ords/datve/custmanage/insertcust")
    Call<CallbackResultModel> InsertAccount(@Body AccountInsertModel accountInsertModel);

    @POST("ords/datve/pmvmanage/insert_pmv")
    Call<CallbackResultModel> InsertPhieu(@Body PhieuMuaVeInsertModel phieuMuaVeInsertModel);

    @POST("ords/datve/vemanage/addvetg")
    Call<CallbackResultModel> InsertVeTG(@Body VeInsertModel veInsertModel);

    @POST("ords/datve/vemanage/addveth")
    Call<CallbackResultModel> InsertVeTh(@Body VeInsertModel veInsertModel);
}
