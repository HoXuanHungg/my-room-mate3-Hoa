package motelRoom.repository;

import motelRoom.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository <DocumentEntity, Long> {

    @Query(value = "SELECT * FROM document u WHERE u.room_id = :room_id", nativeQuery = true)
    List<DocumentEntity> findUserByRoom_idParamsNative(@Param("room_id") String room_id);

    @Query(value = "SELECT * FROM document u WHERE u.room_id = :room_id", nativeQuery = true)
    List<DocumentEntity> findUserByRoom_idParamsNative2(@Param("room_id") String room_id);
}
