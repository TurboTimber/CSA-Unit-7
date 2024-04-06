import java.util.Scanner;

public class EquationIn {

    private String eq;
    private int[] domain = new int[2];
    private String eqType;

    Scanner input = new Scanner(System.in);
    public void setEq() {
        System.out.println("Input Equation:");
        eq = input.nextLine();
    }

    public void setDomain() {
        System.out.println("Input domain lower bound: ");
        domain[0] = input.nextInt();
        System.out.println("Input domain upper bound: ");
        domain[1] = input.nextInt();

    }





}
