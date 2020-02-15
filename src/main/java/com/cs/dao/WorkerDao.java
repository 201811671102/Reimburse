package com.cs.dao;

import com.cs.pojo.Reimburse;
import com.cs.pojo.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDao extends Worker {
    public WorkerDao(Worker worker){
        this.setWid(worker.getWid());
        this.setWname(worker.getWname());
        this.setWduty(worker.getWduty());
        this.setWidfront(worker.getWidfront());
        this.setWidreverse(worker.getWidreverse());
    }
    List<Reimburse>  reimburseList;
}
