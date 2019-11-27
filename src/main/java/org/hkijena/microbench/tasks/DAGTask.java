package org.hkijena.microbench.tasks;

import com.github.dexecutor.core.task.Task;
import org.hkijena.microbench.DataInterface;

public abstract class DAGTask extends Task<Integer, Integer> {

    private Integer tid;
    private DataInterface dataInterface;

    protected DAGTask(Integer tid, DataInterface dataInterface) {
        this.tid = tid;
        this.dataInterface = dataInterface;
    }

    public DataInterface getDataInterface() {
        return dataInterface;
    }

    public Integer getTid() {
        return tid;
    }

    public abstract void work();

    public Integer execute() {
        work();
        return getTid();
    }
}
