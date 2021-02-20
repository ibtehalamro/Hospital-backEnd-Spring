package com.hospital.service;

import com.hospital.domain.WaitingQueue;
import com.hospital.repository.WaitingQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WaitingQueueService {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private WaitingQueueRepository waitingQueueRepository;

    public WaitingQueue createWaitingQueue(WaitingQueue waitingQueue) {
        return waitingQueueRepository.save(waitingQueue);
    }


    public WaitingQueue getWaitingQueueById(Long id) {

        return waitingQueueRepository.findById(id).get();
    }

    public Iterable getWaitingQueuesList() {
        return waitingQueueRepository.findAll(Sort.by(Sort.Direction.ASC, "clinic", "localTime"));
    }

    public void deleteWaitingQueueByID(Long id) {
        waitingQueueRepository.deleteById(id);
    }

    //get the number of patients in the waiting queue
    public long getWaitingQueueCount(){
        return waitingQueueRepository.count();
    }



}
