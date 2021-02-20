package com.hospital.Web;

import com.hospital.domain.WaitingQueue;
import com.hospital.service.WaitingQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/queue")
public class WaitingQueueController {

    @Autowired
    private WaitingQueueService waitingQueueService;

    @PostMapping("/")
    public ResponseEntity createWaitingQueue(@RequestBody WaitingQueue waitingQueue) {

        WaitingQueue response = waitingQueueService.createWaitingQueue(waitingQueue);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getWaitingQueueById(@PathVariable Long id) {

        WaitingQueue waitingQueue = waitingQueueService.getWaitingQueueById(id);

        return new ResponseEntity(waitingQueue, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteWaitingQueueById(@PathVariable Long id) {

        waitingQueueService.deleteWaitingQueueByID(id);
        return new ResponseEntity("waitingQueue with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private ResponseEntity getWaitingQueuesList() {
        HashMap<String, List<WaitingQueue>> map = new HashMap<>();

        List<WaitingQueue> iterator = (List<WaitingQueue>) waitingQueueService.getWaitingQueuesList();

        for (WaitingQueue queue : iterator) {
            List<WaitingQueue> tempList = new ArrayList<>();
            if (map.containsKey(queue.getClinic())) {
                tempList = map.get(queue.getClinic());
            }
            tempList.add(queue);
            map.put(queue.getClinic(), tempList);

        }

        return new ResponseEntity(map, HttpStatus.ACCEPTED);
    }

    @GetMapping("/count")
    private ResponseEntity getWaitingQueueCount(){
        return new ResponseEntity(waitingQueueService.getWaitingQueueCount(), HttpStatus.OK);
    }

}
