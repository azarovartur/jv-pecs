package core.mate.academy.service;

import java.util.List;

public interface MachineService<T> {
    List<T> getAll(Class<T> type);

    void fill(List<? super T> machines, T value);

    void startWorking(List<T> machines);
}
