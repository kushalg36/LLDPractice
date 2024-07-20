import adaptee.BabyWeighingMachine;
import adapter.WeightMachineAdapter;
import adapter.WeightMachineAdapterImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new BabyWeighingMachine());
        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}