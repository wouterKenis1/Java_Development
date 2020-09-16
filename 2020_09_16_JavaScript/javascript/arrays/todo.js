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


