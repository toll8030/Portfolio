using System;
using System.Collections.Generic;

namespace Excercise6
{
    class Bank
    {
        public Bank(List<Account> m, decimal b)
        {
            this.Members = m;
            this.Balance = b;
        }

        private List<Account> Members = new List<Account>();
        private decimal Balance;

        public void UpdateBank()
        {
            Account remove = null;
            foreach (Account a in Members)
            {
                if (a.CheckActive())
                {
                    Balance += a.AccountBalance();
                }
                else
                {
                    Balance -= a.AccountBalance();
                    remove = a;
                }
            }
            if (remove != null)
            {
                Members.Remove(remove);
            }
        }
        public void ListAllMembers()
        {
            Console.WriteLine("The members of this bank are:");
            foreach (Account a in Members)
            {
                Console.WriteLine(a.CheckName());
            }
        }

        public void GetAccountTypeCount()
        {
            int Checking = 0;
            int Savings = 0;
            foreach (Account a in Members)
            {
                if (a.CheckType() == 0)
                {
                    Checking++;
                }
                else if(a.CheckType() == 1)
                {
                    Savings++;
                }
            }
            Console.WriteLine("This bank has " + Checking + " checking accounts and " + Savings + " savings accounts.");
        }

        public int GetTransactionCount()
        {
            int transactions = 0;
            foreach(Account a in Members)
            {
                transactions += a.CheckTransactions();
            }
            Console.WriteLine("This bank has " + transactions + " transactions.");
            return transactions;
        }

        public decimal CheckBalance()
        {
            return Balance;
        }
    }
    
    class Account
    {
        public Account(string n, decimal b)
        {
            this.Name = n;
            this.Balance = b;
        }

        private bool Active = true; //Implemented Encapsulation, needs to be referenced for Bank functions
        public bool CheckActive()
        {
            return Active;
        }

        private int Type; //Implemented Encapsulation, needs to be referenced for Bank functions
        public int CheckType()
        {
            return Type;
        }

        private string Name; //Implemented Encapsulation, needs to be referenced for Bank functions
        public string CheckName()
        {
            return Name;
        }

        private decimal Balance; //Implemented Encapsulation, needs to be referenced for Bank functions
        public decimal AccountBalance()
        {
            return Balance;
        }

        private int Transactions = 1; //Implemented Encapsulation, needs to be referenced for Bank functions
        public int CheckTransactions()
        {
            return Transactions;
        }

        public void CloseAccount()
        {
            Active = false;
        }

        public void AddFunds(decimal d)
        {
            Balance += d;
            Transactions++;
        }

        public decimal PrintBalance()
        {
            Console.WriteLine("This account has a balance of $" + Balance);
            return Balance;
        }

        public int GetTransactionCount()
        {
            Console.WriteLine("This account has " + Transactions + " transactions.");
            return Transactions;
        }
    }

    class CheckingAccount: Account 
    {

    }

    class SavingsAccount : Account
    {

    }

    class Program
    {
        static void Main(string[] args)
        {
            List<Account> accounts = new List<Account>()
            {
                new Account(0, "B Smith", 500),
                new Account(1, "S Johnson", 100), 
                new Account(0, "A Boring", 50),
                new Account(1, "R McDonald", 400)
            };
            Bank MyBank = new Bank(accounts, 100);
            accounts[1].AddFunds(100);
            MyBank.UpdateBank();
            accounts[2].CloseAccount();
            MyBank.UpdateBank();
            MyBank.ListAllMembers();
            MyBank.GetAccountTypeCount();
            MyBank.GetTransactionCount();

            Console.ReadKey();
        }
    }
}
