package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;

import java.util.List;

public interface DocumentService {


    DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto);
    DocumentDetailDto findById(long id);
    List<DocumentDetailDto> findAll();
    DocumentDetailDto updateDocument(long id, DocumentCreateDto documentCreateDto);
    List<DocumentDetailDto> findAllByRoomId(String room_id);
    List<DocumentDetailDto> findAllByRoomId1(String room_id);
    void deleteById(long id);
}
