package example.jewelry.menu.commands;
import example.jewelry.handler.GemHandler;
public class AddStoneCommand implements Command {
    private GemHandler gemHandler;

    public AddStoneCommand(GemHandler gemHandler) {
        this.gemHandler = gemHandler;
    }

    @Override
    public void execute() {
        gemHandler.createRandomGem();
    }
}
