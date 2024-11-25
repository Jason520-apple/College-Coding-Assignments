// PC4-14.cpp 
// Jason Vo
// OCCC FALL 2024
// Programming Challenge: 14 - Bank Charges

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    //variables and constants
    double beginningBalance, totalAmountDeposited, totalAmountOfChecks;
    int numberOfChecks, numberOfATM, ATMwithdrawn;

    double checkFee;

    //constants (atm fee)
    const double ATM_FEE = 0.10;
    const double MINIMUM_BALANCE = 400.00;
    const double OVERDRAWN_FEE = 20.00;
    const double LOW_BALANCE_FEE = 15.00;
    const int FIRST_FIVE_ATM_FREE = 5.00;

    //constants (check fees)
    const double MONTHLY_BANK_FEE = 10.00;
    const double FEE_FEWER_20 = 0.10;
    const double FEE_20TO39 = 0.08;
    const double FEE_40TO59 = 0.06;
    const double FEE_60_MORE = 0.04;

    const int ATM_DISPENSES_20 = 20;

    //contsants for less than 20, 20-39, etc
    const int CHECK_FEE_QTY_1 = 20;
    const int CHECK_FEE_QTY_2 = 40;
    const int CHECK_FEE_QTY_3 = 60;


    //calcualted and displayed
    double bankServiceFees;


    //asking for input
    cout << "What is the beginning balance: $";
    cin >> beginningBalance;

    cout << "What is the total amount deposited? ";
    cin >> totalAmountDeposited;

    if (totalAmountDeposited < 0)
    {
        cout << "Invalid, cannot be value less than 0";
        return 1;
    }

    cout << "What is the number of checks written? ";
    cin >> numberOfChecks;

    if (numberOfChecks < 0)
    {
        cout << "The account is overdrawn!";
        return 1;
    }

    else if (numberOfChecks >= 0)
    {
        cout << "What is the total amount of the checks written? ";
        cin >> totalAmountOfChecks;
    }

    cout << "What is the number of ATM transactions? ";
    cin >> numberOfATM;

    if (numberOfATM < 0)
    {
        cout << "Must be greater than zero";
        return 1;
    }
    else
    {
        cout << "What is the total amount withdrawn? ";
        cin >> ATMwithdrawn;
        if (ATMwithdrawn <= 0 || (static_cast<int>(ATMwithdrawn) % ATM_DISPENSES_20) != 0)
        {
            cout << "Error, ATM only dispenses 20, the withdrawn amount must be a multiple of 20";
            return 1;
        }
    }


        //calculate check fees
        if (numberOfChecks < CHECK_FEE_QTY_1)
            checkFee = numberOfChecks * FEE_FEWER_20;
        else if (numberOfChecks < CHECK_FEE_QTY_2)
            checkFee = numberOfChecks * FEE_20TO39;
        else if (numberOfChecks < CHECK_FEE_QTY_3)
            checkFee = numberOfChecks * FEE_40TO59;
        else if (numberOfChecks >= CHECK_FEE_QTY_3)
            checkFee = numberOfChecks * FEE_60_MORE;

        //calculate ATM, balance after charges, final balance, low balance fee, overdrawn fee

        // Calculate ATM fees
        double atm_fees;
        if (numberOfATM > FIRST_FIVE_ATM_FREE)
        {
            atm_fees = (numberOfATM - FIRST_FIVE_ATM_FREE) * ATM_FEE;
        }
        else
            atm_fees = 0.00;

        // Calculate balance after charges and withdrawals
        double balance_after_charges = beginningBalance - MONTHLY_BANK_FEE - checkFee - atm_fees - ATMwithdrawn;

        // Calculate final balance
        double final_balance = balance_after_charges + totalAmountDeposited;

        // Apply low balance fee if necessary
        if (balance_after_charges < MINIMUM_BALANCE)
        {
            balance_after_charges -= LOW_BALANCE_FEE;
        }

        // Apply overdrawn fee if necessary
        if (balance_after_charges < 0)
        {
            balance_after_charges -= OVERDRAWN_FEE;
        }

        //final balance
        final_balance = balance_after_charges + totalAmountDeposited;


        //display
        cout << fixed << setprecision(2);
        cout << "Initial Balance:         $" << beginningBalance << "\n";
        cout << "Monthly Fee:             $" << MONTHLY_BANK_FEE << "\n";
        cout << "Number of Checks:        " << numberOfChecks << "\n";
        cout << "Check Charge:            $" << checkFee << "\n";
        cout << "# of ATM Transactions:   " << numberOfATM << "\n";
        cout << "ATM Charge:              $" << atm_fees << "\n";
        cout << "ATM Withdrawn:           $" << ATMwithdrawn << "\n";
        cout << "Balance after charges:   $" << balance_after_charges << "\n";
        cout << "Low Balance Fee:         $" << (balance_after_charges < MINIMUM_BALANCE ? LOW_BALANCE_FEE : 0.00) << "\n";
        cout << "Overdrawn Fee:           $" << (balance_after_charges < 0 ? OVERDRAWN_FEE : 0.00) << "\n";
        cout << "Total Deposit:           $" << totalAmountDeposited << "\n";
        cout << "Final Balance:           $" << final_balance << "\n";

        return 0;
    
}
    