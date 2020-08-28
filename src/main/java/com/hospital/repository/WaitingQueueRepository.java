package com.hospital.repository;

import com.hospital.domain.WaitingQueue;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingQueueRepository extends CrudRepository<WaitingQueue, Long> {
    Iterable findAll(Sort colName);

}
