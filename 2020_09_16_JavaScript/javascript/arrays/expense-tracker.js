const account = {
    name: "Wouter",
    expenses: [],
    incomes: [],
    addExpense: function(description, amount){
        this.expenses.push({
            description: description,
            amount: amount,
        })
    },
    addIncome: function(description, amount){
        this.incomes.push({
            description: description,
            amount: amount,
        })
    },
    getAccountSummary: function(){
        let totalIncome = 0;
        let totalExpense = 0;
        for(expense of this.expenses){
            totalExpense += expense.amount;
        }
        for(income of this.incomes){
            totalIncome += income.amount;
        }
        let balance = totalIncome - totalExpense;
        return `${this.name} has a balance of ${balance}. ${totalIncome} in income. ${totalExpense} in expenses.`;
    },

}

// expense -> Description, amount
// addExpense -> desc+amount
// getAccountSummary -> total up all expenses --> name has total in expenses.



// 1. add income array
// 2. addIncome(desc, amount)
// 3. tweak getAccountSummary() -> name has a balance of (Incomes-Expenses). incomes in income, expenses in expenses.


account.addExpense("Rent", 950);
account.addExpense("Coffee",2);
account.addIncome("Job",1000);
console.log(account.getAccountSummary());
