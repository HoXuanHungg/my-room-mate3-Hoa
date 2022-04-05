package motelRoom.service.roomService;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import motelRoom.mapper.RoomMapper;
import motelRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;

    private final RoomMapper mapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper mapper) {
        this.roomRepository = roomRepository;

        this.mapper = mapper;
    }


    @Override
    public List<RoomDetailDto> findAll() {
        return mapper.fromListEntityToDto(roomRepository.findAll());
    }

    @Override
    public List<RoomDetailDto> findAllByFilter(String room_id,String user_id) {
        return mapper.fromListEntityToDto(roomRepository.findAllByFilter(room_id,user_id));
    }
    @Override
    public List<RoomDetailDto> query1(String province_id, float price, float capacity) {
        return mapper.fromListEntityToDto(roomRepository.query1(province_id,price,capacity));
    }

    @Override
    public List<RoomDetailDto> query2(String province_id, String district_id, float price, float capacity) {
        return mapper.fromListEntityToDto(roomRepository.query2(province_id,district_id,price,capacity));
    }

    @Override
    public List<RoomDetailDto> query3(String province_id, String district_id, String ward_id, float price, float capacity) {
        return mapper.fromListEntityToDto(roomRepository.query3(province_id,district_id,ward_id,price,capacity));
    }

    @Override
    public List<RoomDetailDto> query4(String province_id, String district_id, String ward_id, float price, float capacity) {
        return mapper.fromListEntityToDto(roomRepository.query4(province_id,district_id,ward_id,price,capacity));
    }

    @Override
    public List<RoomDetailDto> query5(String province_id, String district_id, String ward_id, float price, float capacity) {
        return mapper.fromListEntityToDto(roomRepository.query5(province_id,district_id,ward_id,price,capacity));
    }

}
