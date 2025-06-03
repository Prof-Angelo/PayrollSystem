import java.util.InputMismatchException;
import java.util.Scanner;

public class AutomatedPayrollSystem {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        // ------------------ CREDENTIAL ARRAYS ------------------ //
        String[] users = {"Admin1", "Admin2", "Admin3"};
        String[] passwords = {"adm123", "adm456", "adm789"};

        // ------------------ AUTHENTICATION SYSTEM ------------------ //
        boolean isRepeat = true;
        while (isRepeat) {
            System.out.println("--------------------------------------");
            System.out.println("        Authentication Login       ");
            System.out.println("--------------------------------------");

            try {
                System.out.print("\n          Username: ");
                String username = scr.nextLine();

                System.out.print("          Password: ");
                String password = scr.nextLine();

                boolean isAuthenticated = false;
                for (int i = 0; i < users.length; i++) {
                    if (users[i].equalsIgnoreCase(username) && passwords[i].equals(password)) {
                        isAuthenticated = true;
                        isRepeat = false;
                        break;
                    }
                }

                if (!isAuthenticated) {
                    System.out.println("\n         (Wrong Credentials!)\n");
                } else {
                    System.out.println("\n         (Welcome, " + username + "!)\n");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scr.nextLine();
            }
        }
        

        
        // ------------------ PAYROLL SYSTEM ------------------ //
        int totalEmployee = 3;

        String[] empNames = new String[totalEmployee];
        int[] payrollDates = new int[totalEmployee];
        int[] empIds = new int[totalEmployee];
        int[] daysWorked = new int[totalEmployee];
        double[] dailyWage = new double[totalEmployee];
        double[] grossSalary = new double[totalEmployee];
        double[] sss = new double[totalEmployee];
        double[] philHealth = new double[totalEmployee];
        double[] hdmf = new double[totalEmployee];
        double[] incomeTax = new double[totalEmployee];
        double[] bonus = new double[totalEmployee];
        double[] loan = new double[totalEmployee];
        double[] netSalary = new double[totalEmployee];

        int empCounter = 0;
        boolean systemLoop = true;

        while (systemLoop) {
            System.out.println("\n--------------------------------------");
            System.out.println("           PAYROLL SYSTEM             ");
            System.out.println("--------------------------------------");
            System.out.println("[1] Add Employee");
            System.out.println("[2] Employee's Informations");
            System.out.println("[3] Calculate Employee's Payroll");
            System.out.println("[4] View Employee's Payslip");
            System.out.println("[5] Update Employee's Payslip");
            System.out.println("[6] Review Payroll Regulations");
            System.out.println("[7] Employee's with Loan");
            System.out.println("[8] Employee's with Bonus");
            System.out.println("[9] Exit");
        
            String yesNo = "";
            int choice;
        
            System.out.print("Enter your choice: ");
            choice = -1;
            
            try {
                choice = scr.nextInt();
                scr.nextLine();
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scr.nextLine();
                continue;
            }
        
            
            switch (choice) {
                case 1:
                
                    try {
                        if (empCounter < totalEmployee) {
                            
                            do {
                            System.out.print("Enter Employee Name: ");
                            empNames[empCounter] = scr.nextLine();
                                
                                System.out.println("Do you want to continue? (Yes/No): ");
                                yesNo = scr.nextLine();
                            } while (yesNo.equalsIgnoreCase("No"));
                                
                            do {
                            System.out.print("\nEnter Employee ID: ");
                            empIds[empCounter] = scr.nextInt();
                            scr.nextLine();
                                
                                System.out.println("Do you want to continue? (Yes/No): ");
                                yesNo = scr.nextLine();
                            } while (yesNo.equalsIgnoreCase("No"));

                            System.out.println("\nSUCCESSFULLY ADDED!");
                            
                            empCounter++;
                            
                        } else {
                            System.out.println("MAXIMUM EMPLOYEE LIMIT REACHED!");
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid data.");
                        scr.nextLine();
                    } break;

                
                case 2:
                   System.out.println("\n--- Employee's Informations ---");
                   boolean foundEmp = false;
                
                for (int i = 0; i < empCounter; i++) {
                    
                if (empNames[i] != null && !empNames[i].isEmpty()) {
                    foundEmp = true;
                    
            System.out.println("Employee Name: " + empNames[i] + "\nID No: (" + empIds[i] + ")\n");
        }
    }
            if (!foundEmp) {
                System.out.println("NO EMPLOYEE FOUND!");
            }
                
             break;
                
                
                case 3:
                    try {
                        if (empCounter > 0) {
                            int id;
                            
                            do {
                            System.out.print("Enter Employee ID: ");
                            id = scr.nextInt();
                            scr.nextLine();
                                
                                System.out.println("Do you want to continue? (Yes/No): ");
                                yesNo = scr.nextLine();
                            } while (yesNo.equalsIgnoreCase("No"));
                            
                            boolean found = false;
                            for (int i = 0; i < empCounter; i++) {
                                if (empIds[i] == id) {
                                    found = true;
                                    
                                    do {
                                        System.out.print("\nEnter Payroll Date (MM/DD/YYYY): ");
                                        payrollDates[i] = scr.nextInt();
                                    
                                    System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    
                                    do {
                                    System.out.print("\nEnter Daily Wage: ");
                                    dailyWage[i] = scr.nextDouble();
                                        
                                       System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    do {
                                    System.out.print("\nEnter Days Worked: ");
                                    daysWorked[i] = scr.nextInt();
                                        
                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    grossSalary[i] = dailyWage[i] * daysWorked[i];
                                    sss[i] = grossSalary[i] * 0.045;
                                    philHealth[i] = grossSalary[i] * 0.035;
                                    hdmf[i] = grossSalary[i] * 0.02;
                                    incomeTax[i] = grossSalary[i] * 0.10;

                                    do {
                                    System.out.print("\nEnter Bonus: ");
                                    bonus[i] = scr.nextDouble();
                                        scr.nextLine();
                                        
                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    do {
                                    System.out.print("\nEnter Loan Deduction: ");
                                    loan[i] = scr.nextDouble();
                                        scr.nextLine();
                                        
                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    netSalary[i] = (grossSalary[i] + bonus[i]) -
                                            (sss[i] + philHealth[i] + hdmf[i] + incomeTax[i] + loan[i]);

                                    System.out.println("\nPAYROLL SUCCESSFULLY CALCULATED!");
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("EMPLOYEE ID NOT FOUND!");
                            }
                        } else {
                            System.out.println("NO EMPLOYEE TO CALCULATE PAYROLL!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Try again.");
                        scr.nextLine();
                    }
                    break;

                
                case 4:
                    try {
                        if (empCounter > 0) {
                            int id;
                            
                            do {
                            System.out.print("Enter Employee ID: ");
                            id = scr.nextInt();
                                
                                System.out.println("Do you want to continue? (Yes/No): ");
                                yesNo = scr.nextLine();
                                scr.nextLine();
                            } while (yesNo.equalsIgnoreCase("No"));
                            
                            boolean found = false;

                            for (int i = 0; i < empCounter; i++) {
                                if (empIds[i] == id) {
                                    found = true;
                                    System.out.println("\n--- Payslip for " + empNames[i] + " ---");
                                    System.out.printf("\nDate (MM/DD/YYYY): " + payrollDates[i]);
                                    System.out.printf("\nEARNINGS: ");
                                    System.out.print("\nDays Worked: " + daysWorked[i] + " day/s");
                                    System.out.printf("\nGross Salary: %.2f%n", grossSalary[i]);
                                    System.out.printf("Bonus: %.2f%n", bonus[i]);
                                    System.out.printf("Total Earnings: %.2f%n", grossSalary[i] + bonus[i]);

                                    System.out.printf("\nDEDUCTIONS: ");
                                    System.out.printf("\nSSS: %.2f%n", sss[i]);
                                    System.out.printf("PhilHealth: %.2f%n", philHealth[i]);
                                    System.out.printf("Pag-IBIG/HDMF: %.2f%n", hdmf[i]);
                                    System.out.printf("Income Tax: %.2f%n", incomeTax[i]);
                                    System.out.printf("Loan: %.2f%n", loan[i]);
                                    System.out.printf("Total Deduction: %.2f%n", sss[i] + philHealth[i] + hdmf[i] + incomeTax[i] + loan[i]);

                                    System.out.printf("\n(NET SALARY): %.2f%n", netSalary[i]);
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("EMPLOYEE ID NOT FOUND!");
                            }
                        } else {
                            System.out.println("NO EMPLOYEE TO SHOW PAYSLIP!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scr.nextLine();
                    }
                    break;

                case 5:
                    try {
                        if (empCounter > 0) {
                            int id;
                            
                            do {
                            System.out.print("Enter Employee ID: ");
                            id = scr.nextInt();
                            scr.nextLine();
                            
                                System.out.println("Do you want to continue? (Yes/No): ");
                                yesNo = scr.nextLine();
                            } while (yesNo.equalsIgnoreCase("No"));
                            
                            boolean found = false;

                            for (int i = 0; i < empCounter; i++) {
                                if (empIds[i] == id) {
                                    found = true;

                                     do {
                                        System.out.print("Enter New Payroll Date (MM/DD/YYYY): ");
                                        payrollDates[i] = scr.nextInt();
                                    
                                    System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                         scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    do {
                                    System.out.print("Enter Daily Wage: ");
                                    dailyWage[i] = scr.nextDouble();
                                        
                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                        
                                    do {
                                    System.out.print("Enter Days Worked: ");
                                    daysWorked[i] = scr.nextInt();

                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    grossSalary[i] = dailyWage[i] * daysWorked[i];
                                    sss[i] = grossSalary[i] * 0.045;
                                    philHealth[i] = grossSalary[i] * 0.035;
                                    hdmf[i] = grossSalary[i] * 0.02;
                                    incomeTax[i] = grossSalary[i] * 0.10;

                                    do {
                                    System.out.print("Enter new Bonus: ");
                                    bonus[i] = scr.nextDouble();

                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));
                                    
                                    do {
                                    System.out.print("Enter new Loan: ");
                                    loan[i] = scr.nextDouble();
                                        
                                        System.out.println("Do you want to continue? (Yes/No): ");
                                        yesNo = scr.nextLine();
                                        scr.nextLine();
                                    } while (yesNo.equalsIgnoreCase("No"));

                                    netSalary[i] = (grossSalary[i] + bonus[i]) -
                                            (sss[i] + philHealth[i] + hdmf[i] + incomeTax[i] + loan[i]);

                                    System.out.println("PAYSLIP SUCCESSFULLY UPDATED!");
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("EMPLOYEE ID NOT FOUND!");
                            }
                        } else {
                            System.out.println("NO EMPLOYEE TO UPDATE PAYSLIP!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scr.nextLine();
                    }
                    break;

                case 6:
                    System.out.println("\n--- Payroll Regulations ---");
                    System.out.println("1. SSS: 4.5% of Gross Salary");
                    System.out.println("2. PhilHealth: 3.5% of Gross Salary");
                    System.out.println("3. HDMF (Pag-IBIG): 2% of Gross Salary");
                    System.out.println("4. Income Tax: 10% of Gross Salary");
                    System.out.println("5. Bonus and Loan are manually entered");
                    System.out.println("6. Loan interest is already included in loan value entered");
                    break;

                case 7:
                    System.out.println("\n--- Employees with Loan ---");
                    boolean foundLoan = false;
                    for (int i = 0; i < empCounter; i++) {
                        if (loan[i] > 0) {
                            foundLoan = true;
                            System.out.println("\nDate (MM/DD/YY): " + payrollDates[i]);
                            System.out.println("Employee Name: " + empNames[i]);
                            System.out.println("Loan Amount: " + loan[i]);
                            
                        }
                    }
                    if (!foundLoan) {
                        System.out.println("NO EMPLOYEE HAS A LOAN.");
                    }
                    break;

                case 8:
                    System.out.println("\n--- Employees with Bonus ---");
                    boolean foundBonus = false;
                    for (int i = 0; i < empCounter; i++) {
                        if (bonus[i] > 0) {
                            foundBonus = true;
                            System.out.println("\nDate (MM/DD/YY): " + payrollDates[i]);
                            System.out.println("Employee Name: " + empNames[i]);
                            System.out.println("Bonus Amount: " + bonus[i]);
                        }
                    }
                    if (!foundBonus) {
                        System.out.println("NO EMPLOYEE HAS A BONUS.");
                    }
                    break;

                case 9:
                    System.out.print("Do you want to exit? (Yes/No): ");
                    String exit = scr.nextLine();
                    if (exit.equalsIgnoreCase("Yes")) {
                        System.out.println("\nExiting the program...");
                        isRepeat = true;
                        systemLoop = false;
                    } break;
                
                

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scr.close();
    }
}