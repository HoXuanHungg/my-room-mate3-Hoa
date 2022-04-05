package motelRoom.controller;

import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.service.roomService.RoomService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;
    private RoomDetailDto roomDetailDto;
    private RoomDetailDto roomDetailDto1;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public List<RoomDetailDto> findAll(){
        return roomService.findAll();
    }
    @PostMapping("/search")
    public List<RoomDetailDto> SearchFilter(@RequestBody RoomDetailDto roomDetailDto)
    {
        return roomService.findAllByFilter(roomDetailDto.getRoom_id(),roomDetailDto.getUser_id());
    }
    @PostMapping("/search2")
    public List<RoomDetailDto> SearchFilter1(@RequestBody RoomDetailDto roomDetailDto)
    {

        List<RoomDetailDto> list = new ArrayList<>();
        if(roomDetailDto.getProvince_id() == null &&
                roomDetailDto.getDistrict_id()==null &&
                roomDetailDto.getWard_id()==null &&
                roomDetailDto.getPrice()==0 &&
                roomDetailDto.getCapacity()==0){
            return findAll();
        }
        else{
            //Filter 1 điều kiện.
            if(roomDetailDto.getProvince_id()!=null &&  // lủng
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getCapacity()==0&&
                    roomDetailDto.getDistrict_id()==null&&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query1(roomDetailDto.getProvince_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
             else if(roomDetailDto.getProvince_id()==null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()==0&&
                    roomDetailDto.getDistrict_id()==null&&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query1(roomDetailDto.getProvince_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
             else if(roomDetailDto.getProvince_id()==null &&
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()==null&&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query1(roomDetailDto.getProvince_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            //Filter 2 điều kiện.
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getDistrict_id()==null &&
                    roomDetailDto.getCapacity()==0 &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query2(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getDistrict_id()==null &&
                    roomDetailDto.getCapacity()!=0 &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query2(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()==null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getDistrict_id()==null &&
                    roomDetailDto.getCapacity()!=0 &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query2(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getCapacity()==0 &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query2(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            //Filter 3 điều kiện.
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()==null &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query3(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()==0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query3(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()==0 && roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query3(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getCapacity()==0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()!=null){
                list = roomService.query3(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            //Filter 4 dieu kien.
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()==null){
                list = roomService.query4(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()==0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()!=null){
                list = roomService.query4(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()==0 &&
                    roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()!=null){
                list = roomService.query4(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }
            //Filter 5 dieu kien.
            else if(roomDetailDto.getProvince_id()!=null &&
                    roomDetailDto.getPrice()!=0 &&
                    roomDetailDto.getCapacity()!=0&&
                    roomDetailDto.getDistrict_id()!=null &&
                    roomDetailDto.getWard_id()!=null){
                list = roomService.query5(roomDetailDto.getProvince_id(),roomDetailDto.getDistrict_id(),
                        roomDetailDto.getWard_id(),roomDetailDto.getPrice(),roomDetailDto.getCapacity());
            }

        }

        return list;
    }


}
