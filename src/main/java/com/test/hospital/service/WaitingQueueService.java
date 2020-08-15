package com.test.hospital.service;

import com.test.hospital.domain.WaitingQueue;
import com.test.hospital.repository.WaitingQueueRepository;
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

}
