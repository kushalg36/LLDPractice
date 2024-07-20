package adapter;

import adaptee.WeighingMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeighingMachine weighingMachine;

    public WeightMachineAdapterImpl(WeighingMachine weighingMachine) {
        this.weighingMachine = weighingMachine;
    }
    @Override
    public double getWeightInKgs() {
        double weightInPound = weighingMachine.getWeightInPounds();
        return weightInPound * .45;
    }
}
