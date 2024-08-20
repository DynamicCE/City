package com.erkan.City.service;

import com.erkan.City.model.City;
import com.erkan.City.repository.CityRepository;
import com.erkan.City.result.DataResult;
import com.erkan.City.result.ErrorResult;
import com.erkan.City.result.Result;
import com.erkan.City.result.SuccessDataResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public
class CityService {
    private
    CityRepository cityRepository;
    private static final Logger log = LoggerFactory.getLogger ( CityService.class );

    public
    CityService ( CityRepository cityRepository ) {
        this.cityRepository = cityRepository;
    }

    public
    Result<List<City>> getCities () {

        try {
            List<City> result = cityRepository.findAll ( );
            if (result.isEmpty ( )) {
                return new ErrorResult ( "veri bulunamadı" );
            }
            return new SuccessDataResult<> ( result );
        } catch (Exception e) {
            log.error ( "şehirler getirilirken hata oluştu" );
            return new ErrorResult ( "şehirler gelemedi :(" );
        }
    }

    public
    Result<City> getCityById ( short id ) {

        try {
           Optional<City> result = cityRepository.findById ( id );
           if(result.isPresent ()){
               return new SuccessDataResult<> (result  );
           }else {
               return new ErrorResult ( "bu id'ye sahip bir şehir yok" );
           }
        } catch (Exception e) {
            log.error ( "id'ye göre şehir gelirken hata" );
            return new ErrorResult ( "şehir gelemedi :(" );
        }
    }
}
