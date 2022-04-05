package motelRoom.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
public class RoomDetailDto implements Serializable {
    private long id;
    private String room_id;
    private String user_id;
    private String province_id;
    private String district_id;
    private String ward_id;
    private String street;
    private float price;
    private float capacity;
    private String description_room;
    private boolean status_room;
    //private int rate_pick;
}
