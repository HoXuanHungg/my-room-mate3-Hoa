package motelRoom.service.roomService;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomService {
    List<RoomDetailDto> findAll();
    List<RoomDetailDto> findAllByFilter(String room_id,String user_id);
    List<RoomDetailDto> query1(String province_id,float price,float capacity);
    List<RoomDetailDto> query2(String province_id,String district_id,float price,float capacity);
    List<RoomDetailDto> query3(String province_id,String district_id,String ward_id,float price,float capacity);
    List<RoomDetailDto> query4(String province_id,String district_id, String ward_id,float price,float capacity);
    List<RoomDetailDto> query5(String province_id,String district_id,String ward_id,float price,float capacity);

}
