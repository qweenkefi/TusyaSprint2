public class MySuperScreen
        implements MyScreen {
    @Override
    public void create() {
        System.out.println("Load sprites");
        System.out.println(" Im ready to display");

    };

    @Override
    public void render() {
        System.out.println("Draw a bird");
        System.out.println("Move a bird");

    }
}
