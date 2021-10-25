package ru.job4j.tracker;

public class CreateRandomAction implements UserAction {

    private final Output out;

    public CreateRandomAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add N random objects";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create N random objects ====");
        int n = input.askInt("Enter number of objects to create: ");
        for (int i = 0; i < n; i++) {
            tracker.add(new Item("item#" + n));
        }
        out.println(n + " items were created");
        return true;
    }
}
