package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.domain.ImageFile;
import yun.test.shoppingboot.repository.ImageFileRepository;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService{
    private final ImageFileRepository imageFileRepository;

    @Transactional(readOnly = true)
    public ImageFile getImageFile(Long id){
        return imageFileRepository.findById(id).get();
    }
}
