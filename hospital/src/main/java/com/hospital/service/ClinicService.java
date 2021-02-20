package com.hospital.service;

import com.hospital.domain.Clinic;
import com.hospital.exceptions.ClinicExceptions.ClinicNameAlreadyExistsException;
import com.hospital.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public Clinic createClinic(Clinic clinic) {
       Clinic clinicName= clinicRepository.getClinicByClinicName(clinic.getClinicName());

       if(clinicName!=null){
           throw new ClinicNameAlreadyExistsException("Clinic name: "+clinic.getClinicName()+" already exists, please choose different name");
       }


//       if(c!=null){
//             try {
//               throw new Exception("clinic exisit");
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//       }
        return clinicRepository.save(clinic);
    }


    public Clinic getClinicById(Long id) {

        return clinicRepository.findById(id).get();
    }

    public Iterable getClinicsList() {
        return clinicRepository.findAll();
    }

    public void deleteClinicByID(Long id) {
        clinicRepository.deleteById(id);
    }

    public Clinic getQueueNumber(String ClinicName) {
        return clinicRepository.getQueueNumberByClinicNameEquals(ClinicName);
    }


}
