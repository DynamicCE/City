package com.erkan.City.service;

import com.erkan.City.model.User;
import com.erkan.City.model.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.erkan.City.repository.UserRepository;
import com.erkan.City.result.ErrorResult;
import com.erkan.City.result.Result;
import com.erkan.City.result.SuccessDataResult;

public
class UserService {

    private
    UserRepository userRepository;

    public
    UserService ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    private static final Logger log = LoggerFactory.getLogger ( UserService.class );


    public
    Result<UserDto> createUser( UserDto userDto) {
        try {
            // DTO'dan entity'e dönüştürme (örneğin, ModelMapper kullanılarak)
            User user = modelMapper.map(userDto, User.class);

            // Gerekli işlemleri gerçekleştir (örneğin, şehir kontrolü, kullanıcı kaydı)
            // ...

            // Entity'i veritabanına kaydet
            User savedUser = userRepository.save(user);

            // Entity'i tekrar DTO'ya dönüştür
            UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

            return new SuccessDataResult<> (savedUserDto, "Kullanıcı başarıyla oluşturuldu");
        } catch (Exception e) {
            log.error("Kullanıcı oluşturulurken hata oluştu", e);
            return new ErrorResult ("Kullanıcı oluşturulamadı");
        }
    }
}
