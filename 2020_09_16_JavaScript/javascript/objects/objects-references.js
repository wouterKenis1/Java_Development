let myAccount = {
    name: "Wouter Kenis",
    expenses: 0,
    income: 0,
    balance: 0,
}

let addExpense = function(account, amount){
    account.expenses += amount;
}

let otherAccount = myAccount;

console.log(myAccount);
addExpense(myAccount,2.5);
console.log(myAccount);
otherAccount.income = 100;
console.log(myAccount);


// addIncome
let addIncome = function(account, amount){
    account.income += amount;
}

// resetAccount
let resetAccount = function(account){
    account.income = 0;
    account.expenses = 0;
    account.balance = 0;
}

// getAccountSummary
// Account for Wouter has 900. 1000 in income. 100 in expenses.
let getAccountSummary = function(account){
    return `Account for ${account.name} has €${account.balance}. €${account.income} in income. €${account.expenses} in expenses.`
}

let acc = {
    name: "Wouter Kenis",
    expenses: 0,
    income: 0,
    balance: 0,
}


addIncome(acc,1000);
addExpense(acc,50);
addExpense(acc,25);
console.log(getAccountSummary(acc));
resetAccount(acc)
console.log(getAccountSummary(acc));
