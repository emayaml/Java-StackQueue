/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg004TIretornopilas;

import javax.swing.JOptionPane;
import sun.net.www.content.text.plain;

/**
 *
 * @author Usuario
 */
public class MainMenu {

    public static void main(String[] args) {
        String menu[] = {"Add elements", "Take out", "Obtain odd and even elements",
            "Determine quantity", "Show", "Exit"};
        String name, opt;
        StackPila pilp = new StackPila();
        StackPila pl = new StackPila();
        StackPila pp = new StackPila();
        StackPila pr = new StackPila();
        StackPila impr = new StackPila();
        int numIP;

        do {
            opt = (String) JOptionPane.showInputDialog(null,
                    "Selected option",
                    "Main menu",
                    1,
                    null,
                    menu,
                    menu[0]);
            switch (opt) {
                case "Add elements":
                    addElements(pilp);
                    break;

                case "Take out":
                    int number = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                    JOptionPane.showMessageDialog(null, "The number " + number
                            + " was delete from the stack " + Delete(pilp, number));
                    Delete(pilp, number);
                    break;

                case "Obtain odd and even elements":
                    while (!pilp.isEmpty()) {
                        numIP = (int) pilp.Pop();
                        if (numIP % 2 == 0) {
                            impr.Push(numIP);
                        } else {
                            pr.Push(numIP);
                        }
                        pl.Push(numIP);
                    }
                    while (!pl.isEmpty()) {
                        pilp.Push(pl.Pop());
                    }
                    show(pr, pl, "Stack of even elements");
                    show(impr, pl, "Stack of odd elements");
                    break;

                case "Determine quantity":
                    JOptionPane.showMessageDialog(null, "The number of items in the stack is" + cantElementes(pilp));
                    break;

                case "Show":
                    showP(pilp, pl);
                    break;
            }
        } while (!opt.equals("Exit"));
    }
    //CREACION DE METODOS 

    //INGRESAR ELEMENTOS A LA PILA 
    public static void addElements(StackPila pilp) {
        int num, par = 0, imp = 0;
        num = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number"));
        if (par % 2 != 0) {
            par++;
        } else {
            imp++;
        }
        pilp.Push(num);
        JOptionPane.showMessageDialog(null, "Saved number");
    }
    
    //SACAR ELEMENTOS DE LA PILA 
    public static int Delete(StackPila pilp, int x) {
        StackPila aux = new StackPila();
        int num, cont = 0;
        while (!pilp.isEmpty()) {
            num = (int) pilp.Pop();
            if (num != x) {
                aux.Push(num);
            } else {
                cont++;
            }
        }
        while (!aux.isEmpty()) {
            pilp.Push(aux.Pop());
        }
        return cont;
    }

    //CANTIDAD ELEMENTOS POR PILA 
    public static double cantElementes(StackPila pilp) {
        StackPila aux = new StackPila();
        int cant = 0;
        while (!pilp.isEmpty()) {
            aux.Push(pilp.Pop());
            cant++;
        }
        while (!pilp.isEmpty()) {
            pilp.Push(pilp.Pop());
        }
        return cant;
    }

    //MOSTRAR 
    public static void show(StackPila pilp, StackPila pl, String code) {
        String texStack = "";
        int num;
        while (!pilp.isEmpty()) {
            num = (int) pilp.Pop();
            texStack += num + "\n";
            pl.Push(num);
        }
        while (!pl.isEmpty()) {
            pilp.Push(pl.Pop());
        }
        JOptionPane.showMessageDialog(null, code + "\n" + texStack);
    }
    
    public static void showP(StackPila pilp, StackPila pl) {
        String texStack = "";
        int num;
        while (!pilp.isEmpty()) {
            num = (int) pilp.Pop();
            texStack += num + "\n";
            pl.Push(num);
        }
        while (!pl.isEmpty()) {
            pilp.Push(pl.Pop());
        }
        JOptionPane.showMessageDialog(null, "\n" + texStack);
    }

    //END
}
