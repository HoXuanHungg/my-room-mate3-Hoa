package motelRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table_room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String room_id;
    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String province_id;
    @Column(nullable = false)
    private String district_id;
    @Column(nullable = false)
    private String ward_id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private float capacity;
    @Column(nullable = false)
    private String description_room;
    @Column(nullable = false)
    private boolean status_room;
}
