package InterfaceReponsitory;

import Model.CangModel;
import Model.ChuyenBayModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Methods {
    @GET("ords/datve/cang")
    Call<CangModel> GetCangs() ;

    @GET("ords/datve/cbmanage/searchcb")
    Call<ChuyenBayModel> GetChuyenBay(@Query("TENCANGDI") String TENCANGDI, @Query("TENCANGDEN") String TENCANGDEN, @Query("NGAYBAY") String NGAYBAY);

    @GET("ords/datve/khachhang")
    Call<TaiKhoanModel> GetTaiKhoan();
}
