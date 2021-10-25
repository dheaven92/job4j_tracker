package ru.job4j.tracker;

import java.util.List;

public class DeleteAllAction implements UserAction {

    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items from store";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> items = tracker.findAll();
        items.forEach(i -> tracker.delete(i.getId()));
        out.println("All items were deleted");
        return true;
    }
}
