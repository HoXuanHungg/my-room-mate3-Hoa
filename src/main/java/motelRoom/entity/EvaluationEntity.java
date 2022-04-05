package motelRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "evaluation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String evaluation_id;
    private String room_id;
    private int rate;
    private String comment_rate;

}
