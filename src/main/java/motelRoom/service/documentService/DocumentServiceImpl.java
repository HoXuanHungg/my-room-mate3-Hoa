package motelRoom.service.documentService;


import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import motelRoom.mapper.DocumentMapper;
import motelRoom.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;
    @Autowired
    private final DocumentMapper mapper;

    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper mapper) {

        this.documentRepository = documentRepository;
        this.mapper = mapper;
    }
    //Hien thi list document
    @Override
    public List<DocumentDetailDto> findAll() {

        return mapper.fromListEntityToDto(documentRepository.findAll());
    }

    @Override
    public DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto) {
        DocumentEntity documentEntity = mapper.fromDocumentCreateDto(documentCreateDto);
        DocumentEntity documentEntityCreate = documentRepository.save(documentEntity);
        DocumentDetailDto documentDetailDto = null;
        if(documentEntityCreate != null){
            documentDetailDto = mapper.fromEntityToDto(documentEntityCreate);
        }
        return documentDetailDto;
    }

    @Override
    public DocumentDetailDto findById(long id) {
        return null;
    }

    public List<DocumentDetailDto> findAllByRoomID(String room_id){
        return mapper.fromListEntityToDto(documentRepository.findUserByRoom_idParamsNative(room_id));
    }

    @Override
    public DocumentDetailDto updateDocument(long id, DocumentCreateDto documentCreateDto) {
        return null;
    }

    @Override
    public List<DocumentDetailDto> findAllByRoomId(String room_id) {
        return mapper.fromListEntityToDto(documentRepository.findUserByRoom_idParamsNative(room_id));
    }

    @Override
    public List<DocumentDetailDto> findAllByRoomId1(String room_id) {
        return mapper.fromListEntityToDto(documentRepository.findUserByRoom_idParamsNative2(room_id));
    }

    @Override
    public void deleteById(long id) {
    documentRepository.deleteById(id);
    }
}
