package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.Collections;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        MachineProducer<Machine> machineProducer = null;
        if (type == Bulldozer.class) {
            return new BulldozerProducer().get();
        }
        if (type == Truck.class) {
            return new TruckProducer().get();
        }
        if (type == Excavator.class) {
            return new ExcavatorProducer().get();
        }
        return Collections.emptyList();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine machine) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, machine);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
