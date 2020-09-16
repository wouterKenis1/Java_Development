// create array 5 todos
// print: you hava x todos
// print first and second to last items -> todo: walk the dog

let todos = ["1","2","3","4","5"];

let printTodoAmount = function(array){
    console.log(`you have ${array.length} todo's`);
}
let printTodos = function(array){
    printTodo(array[0]);
    printTodo(array[array.length-1]);
}
let printTodo = function(todo){
    console.log(`todo: ${todo}`);
}

printTodoAmount(todos);
printTodos(todos);

// challenge
// remove 3rd item
// add new item at back
// remove first item
console.log("-----")
todos = ["order cat food","clean the kitchen", "buy food", "do work", "exercise"];
todos.splice(2,1);
todos.push("new Todo");
todos.shift();
console.log(todos);

console.log("-----");
todos = ["order cat food","clean the kitchen", "buy food", "do work", "exercise"];

todos.forEach(
    function(todo,index){
        const num = index + 1;
        console.log(`${num}. ${todo}`);
    }
)

console.log("-----");
for(let i=0; i<=10;i++){
    console.log(i);
}


console.log("-----");
todos = ["order cat food","clean the kitchen", "buy food", "do work", "exercise"];
for(let i=0;i < todos.length; i++){
    console.log(`${i+1}. ${todos[i]}`);
}

console.log("----- challenge -----");
todos = ["order cat food","clean the kitchen", "buy food", "do work", "exercise"];
// 1. convert array to array of objects -> text, completed
// 2. Create function to remove todo by text value

todos = [
    {
        text: "order cat food",
        completed: false,
    },
    {
        text: "clean the kitchen",
        completed: false,
    },
    {
        text: "buy food",
        completed: false,
    },
    {
        text:  "do work",
        completed: false,
    },
    {
        text:  "exercise",
        completed: false,
    },
]

let deleteTodo = function(array,todoString){
    let index = array.findIndex(function(todo){
        return todo.text.toLowerCase() == todoString.toLowerCase();
    });
    console.log(index);
    array.splice(index,1);
}

console.log(todos);
deleteTodo(todos, "buy food");
console.log(todos);




