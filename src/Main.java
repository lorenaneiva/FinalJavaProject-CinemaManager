import UI.MenuPrincipal;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();


        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
        //         MenuPrincipal menu = new MenuPrincipal();
        //         menu.exibirMenu();
        //         System.exit(0);
        //     }
        // });
    }
}