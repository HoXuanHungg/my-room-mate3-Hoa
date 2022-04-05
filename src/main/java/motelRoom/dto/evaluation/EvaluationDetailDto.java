package motelRoom.dto.evaluation;

import lombok.Data;

import java.io.Serializable;

@Data
public class EvaluationDetailDto implements Serializable {
    private String evaluation_id;
    private String room_id;
    private int rate;
    private String comment_rate;
}
