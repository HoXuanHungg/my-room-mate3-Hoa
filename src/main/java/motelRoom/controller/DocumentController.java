package motelRoom.controller;


import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.service.documentService.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/Document")
public class DocumentController {

    private final DocumentService documentService;


    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;

    }

    @GetMapping
    public List<DocumentDetailDto> findAll(){
        return documentService.findAll();
    }

    @GetMapping("/{room_id}")
    public List<DocumentDetailDto> findAllByRoomId(@PathVariable String room_id){
        return documentService.findAllByRoomId(room_id);
    }
    @PostMapping("/search1")
    public List<DocumentDetailDto> findAllByRoomId1(@RequestBody DocumentDetailDto documentDetailDto){
        return documentService.findAllByRoomId(documentDetailDto.getRoom_id());
    }
    @PostMapping
    public ResponseEntity<DocumentDetailDto> create(@RequestBody DocumentCreateDto documentCreateDto)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentService.createDocument(documentCreateDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDetailDto> update(@PathVariable Long id, @RequestBody DocumentCreateDto documentCreateDto) {
        DocumentDetailDto documentDetailDto = documentService.updateDocument(id, documentCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentDetailDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        documentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
