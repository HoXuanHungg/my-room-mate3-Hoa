package motelRoom.repository;

import motelRoom.entity.EvaluationEntity;
import motelRoom.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    @Query(value = "SELECT * FROM table_room u WHERE u.room_id = :room_id or u.user_id = :user_id", nativeQuery = true)
    List<RoomEntity> findAllByFilter(@Param("room_id") String room_id,@Param("user_id") String user_id);
    //                                        Filter

    @Query(value = "select * from table_room where province_id =:province_id or capacity=:capacity or price=:price ",nativeQuery = true)
    List<RoomEntity> query1(@Param("province_id")String province_id,@Param("price")float price,@Param("capacity")float capacity);

    @Query(value = "select * from table_room where (province_id = :province_id and price=:price) " +
            "or(province_id = :province_id and capacity=:capacity) " +
            "or(price=:price and capacity=:capacity) " +
            "or(province_id = :province_id and district_id=:district_id)",nativeQuery = true)
    List<RoomEntity> query2(@Param("province_id")String province_id,@Param("district_id")String district_id,@Param("price")float price,@Param("capacity")float capacity);

    @Query(value = "select * from table_room where (province_id =:province_id and capacity=:capacity and price=:price) " +
            "or(province_id = :province_id and district_id=:district_id and price=:price) " +
            "or(province_id =:province_id and district_id=:district_id and capacity=:capacity) " +
            "or(province_id = :province_id and district_id=:district_id and ward_id=:ward_id) ",nativeQuery = true)
    List<RoomEntity> query3(@Param("province_id")String province_id,@Param("district_id")String district_id,@Param("ward_id") String ward_id,@Param("price")float price,@Param("capacity")float capacity);

    @Query(value = "select * from table_room where(province_id =:province_id and district_id=:district_id and price=:price and capacity=:capacity) " +
            "or(province_id = :province_id and district_id=:district_id and ward_id=:ward_id and price=:price) " +
            "or(province_id = :province_id and district_id=:district_id and ward_id=:ward_id and capacity=:capacity)",nativeQuery = true)
    List<RoomEntity> query4(@Param("province_id")String province_id,@Param("district_id")String district_id,@Param("ward_id") String ward_id,@Param("price")float price,@Param("capacity")float capacity);

    @Query(value = "select * from table_room where (province_id = :province_id and district_id=:district_id and ward_id=:ward_id and price=:price and capacity=:capacity)",nativeQuery = true)
    List<RoomEntity> query5(@Param("province_id")String province_id,@Param("district_id")String district_id,@Param("ward_id") String ward_id,@Param("price")float price,@Param("capacity")float capacity);

}



//SELECT * FROM table_room\n" +
//        "where (select case when :price!='' and :capacity='' and :province_id='' then price = :price when :price='' and :capacity!='' and :province_id='' then capacity = :capacity when :price='' and :capacity='' and :province_id!='' then province_id = :province_id  else 0 end) or" +
//        " (province_id = :province_id and price=:price) or(province_id = :province_id and capacity=:capacity) or(price=:price and capacity=:capacity) or " +
//        "(province_id =:province_id and capacity=:capacity and price=:price)\n" +
//        "or (province_id = :province_id and district_id=:district_id and price=:price) or (province_id =:province_id and district_id=:district_id and capacity=:capacity) " +
//        "or(province_id =:province_id and district_id=:district_id and price=:price and capacity=:capacity)\n" +
//        "or (province_id = :province_id and district_id=:district_id and ward_id=:ward_id and price=:price) " +
//        "or(province_id = :province_id and district_id=:district_id and ward_id=:ward_id and capacity=:capacity) " +
//        "or (province_id = :province_id and district_id=:district_id and ward_id=:ward_id and price=:price and capacity=:capacity)\n" +
//        "or (province_id = :province_id and district_id=:district_id)" +
//        "or (province_id = :province_id and district_id=:district_id and ward_id=:ward_id)