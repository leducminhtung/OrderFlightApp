package InterfaceReponsitory;

import Model.CangModel;
import Model.ChuyenBayModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Methods {
    String strmethod = "ords/datve/cbmanage/searchcb";

    //    "ords/datve/cbmanage/searchcb?MACANGDI="+MACANGDI+"&MACANGDEN="+MACANGDEN+"&GIOBAY="+GIOBAY+""

    @GET("ords/datve/cang")
    Call<CangModel> GetCangs() ;



    @GET("ords/datve/cbmanage/searchcb")
    Call<ChuyenBayModel> GetChuyenBay(@Query("TENCANGDI") String TENCANGDI, @Query("TENCANGDEN") String TENCANGDEN, @Query("GIOBAY") String GIOBAY);

//    @GET("ords/datve/chuyenbay")
//    Call<ChuyenBayModel> GetChuyenBay() ;
}
